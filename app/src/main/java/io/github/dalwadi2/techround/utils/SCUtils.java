package io.github.dalwadi2.techround.utils;

import android.text.format.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SCUtils {

    //use either formatted_date or time_ago (below)
    public static String formatted_date(long timestamp) {
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();//get your local time zone.
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma", Locale.US); //dd MMM yyyy KK:mma
        sdf.setTimeZone(tz);//set time zone.
        String localTime = sdf.format(new Date(timestamp * 1000));
        return localTime.toLowerCase();
    }

    public static String formatted_date_us(long timestamp) {
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();//get your local time zone.
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()); //MMM dd, yyyy
        sdf.setTimeZone(tz);//set time zone.
        return sdf.format(new Date(timestamp * 1000));
    }

    public static Date getDateCurrentTimeZone(long timestamp) {
        try {
            Calendar calendar = Calendar.getInstance();
            TimeZone tz = TimeZone.getDefault();
            calendar.setTimeInMillis(timestamp * 1000);
            calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
            return calendar.getTime();
        } catch (Exception e) {
        }
        return null;
    }

    public static String getNow() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US).format(new Date());
    }

    public static String time_ago(long message_timestamp) {

        CharSequence xx = DateUtils.getRelativeTimeSpanString(message_timestamp * 1000L, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
        return xx.toString();
    }

    public static long getTimestamp(String date) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US);
            Date date1 = formatter.parse(date);
            return date1.getTime() / 1000L;
        } catch (ParseException ignored) {
            return 0;
        }
    }
}
