package tools;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DateTimeHandler {

    public String todaysDate;

    public DateTimeHandler(){
        //lager klassen
    }

    public String GetTodaysDate() {
        ArrayList<String> list = new ArrayList<>();
        String date = LocalDateTime.now().toString();
        String[] format = date.split("-");
        String[] findday = format[2].split("T");
        list.add(findday[0]); //day
        if (list.get(0).length() == 1) { list.set(0, "0" + list.get(0)); }
        list.add(format[1]); //month
        if (list.get(1).length() == 1) { list.set(1, "0" + list.get(1)); }
        list.add(format[0]); //year
        String finalDate = DateFormatReturn(list);
        todaysDate = finalDate;
        System.out.println(finalDate);
        return finalDate;
    }

    public int DateComparison(String[] Date1, String[] Date2) {
        int returnCode = 0; //0 - ALL IS CORRECT, 1 - YEAR IS IN THE PAST, 2 - MONTH IN THE PAST, 3 - DAY IS TODAY OR IN THE PAST
        ArrayList<Integer> sdDate = new ArrayList<Integer>();
        ArrayList<Integer> tdDate = new ArrayList<Integer>();
        for (int i=0;i<3;i++) {
            sdDate.add(Integer.parseInt(Date1[i])); }
        for (int i=0;i<3;i++) {
            tdDate.add(Integer.parseInt(Date2[i])); }
        int day1 = sdDate.get(0);
        int day2 = tdDate.get(0);
        int month1 = sdDate.get(1);
        int month2 = tdDate.get(1);
        int year1 = sdDate.get(2);
        int year2 = tdDate.get(2);


        if (year1 >= year2) { //året er 2022 eller høyere?:
            if (year1 == year2) { //er året 2022?:
                if (month1 == month2) { //er måneden november?
                    if (day1 <= day2) { //er dagen søndag 13 eller tidligere?
                        returnCode = 3; //FEIL KODE 3
                    } else {
                        //SUBMIT
                    }
                } else if (month1 > month2) { //Ikke likt: er måneden større enn November?
                        //SUBMIT
                } else {
                    returnCode = 2; //FEIL KODE 2
                }
            } else {
                //SUBMIT
            }
        } else {
            returnCode = 1; //FEIL KODE 1
        }
        return returnCode;
    }

    public String DateFormatReturn(ArrayList<String> Date) {
        String formated = Date.get(0) + "-" + Date.get(1) + "-" + Date.get(2);
        return formated;
    }

    public int CheckTimeFormat(String[] timeList) {
        int status = 0; //status must be 2, to be processed
        if (timeList[0].length() == 2 && timeList[1].length() == 2) {
            for (int i=0; i<=24; i++) {
                if (Integer.parseInt(timeList[0]) == i) {
                    status += 1;
                }
            }
            for (int i=0; i<=60; i++) {
                if (Integer.parseInt(timeList[1]) == i) {
                    status += 1;
                }
            }
        }
        return status;
    }
}
