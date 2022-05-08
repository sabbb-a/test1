package javaapplication45;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author stella <your.name at your.org>
 */
public class test {

    public static void main(String[] args) throws ParseException {
        String input = "August 26, 1968";

        Date date = new Date(input);
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
        Calendar cal = Calendar.getInstance();
        Date d = df.parse(input);
        System.out.println("AAAAA" + d);
        System.out.println("BBBBB" + date);
        System.out.println(d.compareTo(date));
        String CurrentDate = df.format(date);
        System.out.println(CurrentDate);

        LocalDate ldate;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println(date.toLocaleString());
    }

}
