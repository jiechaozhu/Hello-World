package com.mifan2009.chimport.utils;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mifan2009.chimport.config.MyConfig;
import com.mifan2009.chimport.entity.TBuilding;
import com.mifan2009.chimport.entity.THouse;
import com.mifan2009.chimport.entity.TLogicbuilding;
import com.mifan2009.chimport.entity.TProject;
import com.mifan2009.chimport.entity.chdata.Build;
import com.mifan2009.chimport.entity.chdata.NWindDataSet;
import com.mifan2009.chimport.entity.chdata.Room;
import com.mifan2009.chimport.mapper.TBuildingMapper;
import com.mifan2009.chimport.service.ITProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Myutil
 * @Description: java类作用描述
 * @Author: mifan2009
 * @CreateDate: 2019-04-25 17:07
 * @Version: 2019-v1.0
 */
@Component
public class Myutil {

    @Autowired
    private ITProjectService itProjectService;
    @Resource
    private TBuildingMapper tBuildingMapper;
    @Autowired
    private MyConfig myConfig;
    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private ProjectHouseUtil projectHouseUtil;

    public Boolean isProjectExist(String fullName, String Id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("PROJECT_NAME", fullName);
        queryWrapper.like("PROJECT_DESC", Id);
        TProject tProject = itProjectService.getOne(queryWrapper, false);
        if (tProject == null) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * @MethodName
     * @Author mifan2009
     * @Description 测绘数据build转project
     * @Date 15:56 2019-05-05
     * @Param
     * @return
     **/
    public TProject transNWDToProject(Build build) {
        TProject tProject = new TProject();
        //
        tProject.setProjectName(build.getFullName());
        tProject.setCityDistrict(Integer.valueOf(myConfig.getDistrict()));
        tProject.setProjectAddress(build.getStreetLane());
        tProject.setProjectDesc("测绘数据导入,唯一ID:" + build.getID());
        //
        return tProject;
    }

    /*
     * @MethodName
     * @Author mifan2009
     * @Description 测绘数据build转build
     * @Date 15:56 2019-05-05
     * @Param
     * @return
     **/
    public TBuilding transNWDToBuilding(Build build, Integer PROJECT_ID) {
        TBuilding tBuilding = new TBuilding();
        //
        tBuilding.setProjectId(PROJECT_ID);
        //
        tBuilding.setBuildingNumberTransition(build.getLogicBuildNo());
        tBuilding.setBuildingNumber(build.getLogicBuildNo());
        tBuilding.setBuildingAddressTransition(build.getStreetLane());
        tBuilding.setBuildingAddress(build.getStreetLane());
        tBuilding.setCityDistrict(Integer.valueOf(myConfig.getDistrict()));
        tBuilding.setDistrictName(build.getProjectName());
        tBuilding.setUnderfloorCount(build.getFloorNumUnderground());
        //获取guid
        tBuilding.setBuildingGuid(tBuildingMapper.selectGuid());
        //
        tBuilding.setBuildingDesc("测绘数据导入:唯一ID:"+build.getID());
        //
        return tBuilding;
    }

    /*
     * @MethodName
     * @Author mifan2009
     * @Description 测绘数据build转logicbuild
     * @Date 15:57 2019-05-05
     * @Param
     * @return
     **/
    public TLogicbuilding transNWDToLogicBuilding(Build build, Integer BUILDING_ID) {
        TLogicbuilding tLogicbuilding = new TLogicbuilding();
        //
        tLogicbuilding.setBuildingId(BUILDING_ID);
        //
        tLogicbuilding.setLogicbuildingNumber(build.getLogicBuildNo());
        tLogicbuilding.setLogicbuildingAddress(build.getStreetLane());
        tLogicbuilding.setFloorCount(Integer.valueOf(build.getTotalFloorNum()));
        tLogicbuilding.setHouseCount(Integer.valueOf(build.getRoomCount()));
        tLogicbuilding.setBuildArea(Double.valueOf(build.getArchArea()));
        if (!build.getCompletionDate().isEmpty()&&build.getCompletionDate().length()>0){
            tLogicbuilding.setConstructDate(dateUtil.parseStringToDateTime(build.getCompletionDate()));
        }
        tLogicbuilding.setBuildStruct(projectHouseUtil.transBuildStruct(build.getArchStruct()));
        tLogicbuilding.setUseDesign(projectHouseUtil.transUseDesign(build.getBldType()));
        tLogicbuilding.setUseFact(projectHouseUtil.transUseFact(build.getUsePurpose()));

        return tLogicbuilding;
    }

    public THouse transNWDToHouse(Room room, Build build, Integer LOGICBUILDING_ID) {
        THouse tHouse = new THouse();
        //
        tHouse.setLogicbuildingId(LOGICBUILDING_ID);
        tHouse.setHouseAddress(room.getRoomLocation());
        tHouse.setPresellrealtyType(Integer.valueOf(myConfig.getPresellrealtype()));
        tHouse.setRealtyType(projectHouseUtil.transRealtyType(room.getKZProperty()));
        tHouse.setLogicbuildingNumber(build.getLogicBuildNo());
        tHouse.setBuildingNumber(build.getLogicBuildNo());
        tHouse.setRoomNumber(room.getRoomFullName());
        tHouse.setBuildStruct(projectHouseUtil.transBuildStruct(room.getStructure()));
        tHouse.setFloorId(Integer.valueOf(room.getFloorOrder()));
        tHouse.setFloorRealright(room.getAddFloorName());
        tHouse.setFloorStart(Integer.valueOf(room.getStartFloor()));
        tHouse.setFloorEnd(Integer.valueOf(room.getEndFloor()));
        tHouse.setBuildArea(Double.valueOf(room.getArchArea()));
        tHouse.setBuildAreaInside(Double.valueOf(room.getSetInArea()));
        tHouse.setBuildAreaShare(Double.valueOf(room.getAppArea()));
        tHouse.setUseDesign(projectHouseUtil.transUseDesign(room.getKZType2()));
        tHouse.setUseFact(projectHouseUtil.transUseFact(room.getKZUse()));
        tHouse.setRealtyrightState(1005);
        tHouse.setMortagageState(1010);
        tHouse.setLimitState(1010);
        tHouse.setTransactionMark(0);

        String guid = tBuildingMapper.selectGuid();
        System.out.println("the guid==>" + guid);
        //GUID
        tHouse.setHouseGuid(guid);
        return tHouse;
    }

    public List<THouse> transNWDToHouseList(NWindDataSet nWindDataSet, Integer LOGICBUILDING_ID) {
        List<THouse> tHouseList = new ArrayList<>();
        Build build = nWindDataSet.getBuildList().get(0);
        List<Room> roomList = nWindDataSet.getRoomList();
        for (int i = 0; i < roomList.size(); i++) {
            THouse tHouse = new THouse();
            Room room = roomList.get(i);
            //
            tHouse.setLogicbuildingId(LOGICBUILDING_ID);
            tHouse.setHouseAddress(room.getRoomLocation());
            tHouse.setPresellrealtyType(Integer.valueOf(myConfig.getPresellrealtype()));
            tHouse.setRealtyType(projectHouseUtil.transRealtyType(room.getKZProperty()));
            tHouse.setLogicbuildingNumber(build.getLogicBuildNo());
            tHouse.setBuildingNumber(build.getLogicBuildNo());
            tHouse.setRoomNumber(room.getRoomFullName());
            tHouse.setBuildStruct(projectHouseUtil.transBuildStruct(room.getStructure()));
            tHouse.setFloorId(Integer.valueOf(room.getFloorOrder()));
            tHouse.setFloorRealright(room.getAddFloorName());
            tHouse.setFloorStart(Integer.valueOf(room.getStartFloor()));
            tHouse.setFloorEnd(Integer.valueOf(room.getEndFloor()));
            tHouse.setBuildArea(Double.valueOf(room.getArchArea()));
            tHouse.setBuildAreaInside(Double.valueOf(room.getSetInArea()));
            tHouse.setBuildAreaShare(Double.valueOf(room.getAppArea()));
            tHouse.setUseDesign(projectHouseUtil.transUseDesign(room.getKZType2()));
            tHouse.setUseFact(projectHouseUtil.transUseFact(room.getKZUse()));
            tHouse.setRealtyrightState(1005);
            tHouse.setMortagageState(1010);
            tHouse.setLimitState(1010);
            tHouse.setTransactionMark(0);

            String guid = tBuildingMapper.selectGuid();
            System.out.println("the guid==>" + guid);
            //GUID
            tHouse.setHouseGuid(guid);

            tHouseList.add(tHouse);
        }
        return tHouseList;
    }


    public com.mifan2009.chimport.entity.TBuilding2 changeBuild(TBuilding tBuilding) {
        com.mifan2009.chimport.entity.TBuilding2 tBuilding2 = new com.mifan2009.chimport.entity.TBuilding2();

        tBuilding2.setBuildingId(Long.valueOf(tBuilding.getBuildingId()));
        //
        tBuilding2.setProjectId(tBuilding.getProjectId());
        //
        tBuilding2.setBuildingNumber(tBuilding.getBuildingNumber());
        if (tBuilding.getBuildingAddress().isEmpty()||tBuilding.getBuildingAddress().length()==0){
            tBuilding2.setBuildingAddress("null");
        }else{
            tBuilding2.setBuildingAddress(tBuilding.getBuildingAddress());
        }
        tBuilding2.setCityDistrict(tBuilding.getCityDistrict());
        tBuilding2.setDistrictName(tBuilding.getDistrictName());
        tBuilding2.setUnderfloorCount(Integer.valueOf(tBuilding.getUnderfloorCount()));
        //获取guid
        tBuilding2.setBuildingGuid(tBuilding.getBuildingGuid());

        return tBuilding2;

    }

    public com.mifan2009.chimport.entity.TLogicbuilding2 changeLogicBuild(TLogicbuilding tLogicbuilding) {

        com.mifan2009.chimport.entity.TLogicbuilding2 tLogicbuilding2 = new com.mifan2009.chimport.entity.TLogicbuilding2();

        tLogicbuilding2.setLogicbuildingId(tLogicbuilding.getLogicbuildingId());
        //
        tLogicbuilding2.setBuildingId(Long.valueOf(tLogicbuilding.getBuildingId()));
        //
        tLogicbuilding2.setLogicbuildingNumber(tLogicbuilding.getLogicbuildingNumber());
        tLogicbuilding2.setLogicbuildingAddress(tLogicbuilding.getLogicbuildingAddress());
        tLogicbuilding2.setFloorCount(Integer.valueOf(tLogicbuilding.getFloorCount()));
        tLogicbuilding2.setHouseCount(Integer.valueOf(tLogicbuilding.getHouseCount()));
        tLogicbuilding2.setBuildArea(Double.valueOf(tLogicbuilding.getBuildArea()));
        tLogicbuilding2.setConstructDate(tLogicbuilding.getConstructDate());
        tLogicbuilding2.setBuildStruct(tLogicbuilding.getBuildStruct());
        tLogicbuilding2.setUseDesign(tLogicbuilding.getUseDesign());
        tLogicbuilding2.setUseFact(tLogicbuilding.getUseFact());

        return tLogicbuilding2;
    }

    public List<com.mifan2009.chimport.entity.THouse2> changeThouseList(List<THouse> tHouseList) {

        List<com.mifan2009.chimport.entity.THouse2> tHouseList2 = new ArrayList<>();

        for (int i = 0; i < tHouseList.size(); i++) {
            com.mifan2009.chimport.entity.THouse2 tHouse2 = new com.mifan2009.chimport.entity.THouse2();
            THouse tHouse = tHouseList.get(i);

            tHouse2.setHouseId(Long.valueOf(tHouse.getHouseId()));
            //
            tHouse2.setLogicbuildingId(tHouse.getLogicbuildingId());
            tHouse2.setHouseAddress(tHouse.getHouseAddress());
            tHouse2.setRealtyType(tHouse.getRealtyType());
            tHouse2.setRoomNumber(tHouse.getRoomNumber());
            tHouse2.setBuildStruct(tHouse.getBuildStruct());
            tHouse2.setFloorId(Long.valueOf(tHouse.getFloorId()));
            tHouse2.setFloorRealright(tHouse.getFloorRealright());
            tHouse2.setFloorStart(tHouse.getFloorStart());
            tHouse2.setFloorEnd(tHouse.getFloorEnd());
            tHouse2.setBuildArea(tHouse.getBuildArea());
            tHouse2.setBuildAreaInside(tHouse.getBuildAreaInside());
            tHouse2.setBuildAreaShare(tHouse.getBuildAreaShare());
            tHouse2.setUseDesign(tHouse.getUseDesign());
            tHouse2.setUseFact(tHouse.getUseFact());
            tHouse2.setRealtyrightState(1005);
            tHouse2.setMortagageState(1010);
            tHouse2.setLimitState(1010);
            tHouse2.setTransactionMark(0);
            //GUID
            tHouse2.setHouseGuid(tHouse.getHouseGuid());

            tHouseList2.add(tHouse2);
        }

        return tHouseList2;
    }

}

    

