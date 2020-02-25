package com.mifan2009.chimport.utils;

import com.baomidou.mybatisplus.generator.config.IFileCreate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ProjectHouseUtil
 * @Description: java类作用描述
 * @Author: mifan2009
 * @CreateDate: 2019-05-05 17:47
 * @Version: 2019-v1.0
 */
@Component
public class ProjectHouseUtil {

    private  static  Map<String,Integer> buildStructMap=new HashMap<>();
    static {
        buildStructMap.put("钢结构",1301);
        buildStructMap.put("钢和钢筋混凝土结构",1302);
        buildStructMap.put("钢筋混凝土结构",1302);
        buildStructMap.put("混合结构",1304);
        buildStructMap.put("砖木结构",1305);
        buildStructMap.put("其他结构",1309);
    }

    private  static  Map<String,Integer> useDesignMap=new HashMap<>();
    static {
        useDesignMap.put("住宅",1010);
        useDesignMap.put("商业用房",1025);
        useDesignMap.put("办公用房",1035);
        useDesignMap.put("工业用房",1020);
        useDesignMap.put("仓储用房",1305);
        useDesignMap.put("车库",1014);
        useDesignMap.put("其他",1020);
    }

    private  static  Map<String,Integer> useFactMap =new HashMap<>();
    static {
        useFactMap.put("住宅",5010);
        useFactMap.put("成套住宅",5011);
        useFactMap.put("别墅",5111);
        useFactMap.put("高档公寓",5010);
        useFactMap.put("非成套住宅",5012);
        useFactMap.put("集体宿舍",5013);
        useFactMap.put("工业、交通、仓储",5021);
        useFactMap.put("工业",5021);
        useFactMap.put("公共设施",5022);
        useFactMap.put("铁路",5023);
        useFactMap.put("民航",5024);
        useFactMap.put("航运",5025);
        useFactMap.put("公共运输",5026);
        useFactMap.put("仓储",5027);
        useFactMap.put("商业、金融、信息",5030);
        useFactMap.put("商业服务",5031);
        useFactMap.put("经营",5032);
        useFactMap.put("旅游",5033);
        useFactMap.put("金融保险",5034);
        useFactMap.put("电讯信息",5035);
        useFactMap.put("教育、医疗、卫生、科研",5040);
        useFactMap.put("教育",5041);
        useFactMap.put("医疗卫生",5042);
        useFactMap.put("科研",5043);
        useFactMap.put("文化、娱乐、体育",5051);
        useFactMap.put("文化",5051);
        useFactMap.put("娱乐",5053);
        useFactMap.put("园林绿化",5054);
        useFactMap.put("体育",5055);
        useFactMap.put("办公",5060);
        useFactMap.put("军事",5070);
        useFactMap.put("其他",5080);
        useFactMap.put("涉外",5081);
        useFactMap.put("宗教",5082);
        useFactMap.put("监狱",5083);
        useFactMap.put("物管用房",5090);
        useFactMap.put("非住宅",5012);
        useFactMap.put("其他（杂房）",5080);
    }

    private  static  Map<String,Integer> realtyTypeMAP=new HashMap<>();
    static {
        realtyTypeMAP.put("商品房",3901);
        realtyTypeMAP.put("房改房",3904);
        realtyTypeMAP.put("经济适用住房",3914);
        realtyTypeMAP.put("廉租住房",3915);
        realtyTypeMAP.put("自建房",3906);
        realtyTypeMAP.put("其它",3909);
    }

    public Integer transBuildStruct(String build_struct){
        if (buildStructMap.get(build_struct)!=null){
            return buildStructMap.get(build_struct);
        }else{
            return 1309;
        }
    }

    public Integer transUseDesign(String bldtype){
        if (useDesignMap.get(bldtype)!=null){
            return useDesignMap.get(bldtype);
        }else{
            return 1020;
        }
    }

    public Integer transUseFact(String usepopose){
        if (usepopose.indexOf(";")>0){
          String[] usepopseArr= usepopose.split(";");
            if (useFactMap.get(usepopseArr[0])!=null){
                return useFactMap.get(usepopseArr[0]);
            }else{
                return 5080;
            }
        }else{
            if (useFactMap.get(usepopose)!=null){
                return useFactMap.get(usepopose);
            }else{
                return 5080;
            }
        }
    }

    public Integer transRealtyType(String kzproperty){
        if (realtyTypeMAP.get(kzproperty)!=null){
            return realtyTypeMAP.get(kzproperty);
        }else{
            return 3909;
        }

    }


}

    

