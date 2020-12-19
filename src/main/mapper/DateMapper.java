package main.mapper;

import java.util.Date;

public class DateMapper {

    public String dateToString(Date date){
        return date.getYear() + "-"+ date.getMonth() + "-" + date.getDate();
    }

}
