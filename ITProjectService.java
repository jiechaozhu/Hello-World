package com.mifan2009.chimport.service;

import com.mifan2009.chimport.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mifan2009.chimport.entity.chdata.NWindDataSet;

import java.util.List;

/**
 * <p>
 * 工程项目信息表 服务类
 * </p>
 *
 * @author mifan2009
 * @since 2019-04-25
 */
public interface ITProjectService extends IService<TProject> {


    TInsertResult initProject(NWindDataSet nWindDataSet, Integer projectallId);


    TInsertResult initSlaveProject(TBuilding tBuilding, TLogicbuilding tLogicbuilding, List<THouse> tHouseList);
}
