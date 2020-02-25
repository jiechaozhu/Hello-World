package com.mifan2009.chimport.utils;

import com.mifan2009.chimport.entity.chdata.Build;
import com.mifan2009.chimport.entity.chdata.NWindDataSet;
import com.mifan2009.chimport.entity.chdata.Room;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Dom4jUtil
 * @Description: 解析xml文件
 * @Author: mifan2009
 * @CreateDate: 2019-04-26 14:36
 * @Version: 2019-v1.0
 */
@Component
public class Dom4jUtil {
    //
    private static Logger logger = LoggerFactory.getLogger(Dom4jUtil.class);

    public NWindDataSet readXml(String filePath){
        NWindDataSet nWindDataSet=new NWindDataSet();
        // 1. 创建一个 saxReader 对象
        SAXReader saxReader = new SAXReader();
        // 2. 将数据读取到 document 对象中
        try {
            Document document = saxReader.read(filePath);
            // 3. 使用 document 对象调用 getRootElement 方法获取根标签, 返回 Element 接口实现类对象
            Element rootElement = document.getRootElement();

            this.logger.info(getClass().getName() + "xml文件读取成功,文件为={}", filePath);
            //遍历所有的元素节点
            nWindDataSet = listNodes(rootElement);
        } catch (DocumentException e) {
            e.printStackTrace();
            nWindDataSet=null;
            this.logger.info(getClass().getName() + "xml文件读取失败,文件为={}", filePath);
        }

        return nWindDataSet;
    }

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *
     * @param nodeElement
     */
    public NWindDataSet listNodes(Element nodeElement) {

        this.logger.info(getClass().getName() + "开始解析xml文件内容");

        NWindDataSet nWindDataSet = new NWindDataSet();
        List<Build> buildList=new ArrayList<>();
        List<Room> roomLists = new ArrayList<>();
        // 4. 使用 rootElement 根标签对象调用 element 方法, 传入 Build, 获取Build标签对象
        Element buildElement = nodeElement.element("Build");
        // 5. 获取该标签下的子标签数据内容, 使用父标签对象调用elementText方法, 传入子标签名称获取数据
        Build build=new Build();
        //
        build.setProjectName(buildElement.elementText("ProjectName"));
        build.setStreetLane(buildElement.elementText("StreetLane"));
        build.setID(buildElement.elementText("ID"));
        build.setFullName(buildElement.elementText("FullName"));
        build.setMainBuldName(buildElement.elementText("MainBuildName"));
        build.setLogicBuildNo(buildElement.elementText("LogicBuildNo"));
        build.setArchStruct(buildElement.elementText("ArchStruct"));
        build.setUsePurpose(buildElement.elementText("UsePurpose"));
        build.setCompletionDate(buildElement.elementText("CompletionDate"));
        build.setFloorNumOverground(buildElement.elementText("FloorNumOverground"));
        build.setFloorNumUnderground(buildElement.elementText("FloorNumUnderground"));
        build.setTotalFloorNum(buildElement.elementText("TotalFloorNum"));
        build.setArchArea(buildElement.elementText("ArchArea"));
        build.setBldType(buildElement.elementText("BldType"));
        build.setRoomCount(buildElement.elementText("RoomCount"));
        //
        buildList.add(build);

        this.logger.info(getClass().getName() + "build标签解析结束，build内容为:\n{}",build);
        // 使用 rootElement 根标签对象调用 elements 方法, 传入 Room, 获取Room标签对象
        List<Element> roomElements = nodeElement.elements("Room");
        for (Element roomElement : roomElements) {
            Room room=new Room();
            //
            room.setID(roomElement.elementText("ID"));
            room.setRoomFullName(roomElement.elementText("RoomFullName"));
            room.setFloorName(roomElement.elementText("FloorName"));
            room.setFloorOrder(roomElement.elementText("FloorOrder"));
            room.setStartFloor(roomElement.elementText("StartFloor"));
            room.setEndFloor(roomElement.elementText("EndFloor"));
            room.setAddFloorName(roomElement.elementText("AddFloorName"));
            room.setRoomLocation(roomElement.elementText("RoomLocation"));
            room.setPurpose(roomElement.elementText("Purpose"));
            //户室结构
            room.setStructure(roomElement.elementText("Structure"));
            room.setKZHouseArchCode(roomElement.elementText("KZHouseArchCode"));
            room.setKzPreUseCode(roomElement.elementText("KzPreUseCode"));
            room.setKzPreUse(roomElement.elementText("KzPreUse"));
            room.setKZUseCode(roomElement.elementText("KZUseCode"));
            //房屋用途-实际用途
            room.setKZUse(roomElement.elementText("KZUse"));
            room.setSetInArea(roomElement.elementText("SetInArea"));
            room.setAppArea(roomElement.elementText("AppArea"));
            room.setArchArea(roomElement.elementText("ArchArea"));
            //房屋性质-房产类型
            room.setKZProperty(roomElement.elementText("KZProperty"));
            //房屋类型-设计用途
            room.setKZType2(roomElement.elementText("KZType2"));
            //户室序号-楼层内码
            room.setKZType2(roomElement.elementText("KZType2"));
            //
            roomLists.add(room);
        }
        this.logger.info(getClass().getName() + "room标签解析结束，roomLists长度为:\n{}",roomLists.size());
        //
        nWindDataSet.setBuildList(buildList);
        nWindDataSet.setRoomList(roomLists);
        return nWindDataSet;

    }


}

    

