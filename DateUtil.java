package com.mifan2009.chimport.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName: DateUtil
 * @Description: java类作用描述
 * @Author: mifan2009
 * @CreateDate: 2019-05-05 16:57
 * @Version: 2019-v1.0
 */
@Component
public class DateUtil {

    public  LocalDateTime parseStringToDateTime(String time)
    {


            time=time+" 00:00:00";
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            return LocalDateTime.parse(time, df);

    }
}

    

