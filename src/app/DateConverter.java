package app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public Date convertString(String strDate) {
        Date result = new Date();

        try {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        result = format.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public java.sql.Date convertToDateSql(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
