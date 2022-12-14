package tools;

import models.Car;
import models.User;

import java.util.ArrayList;

public final class Functions {

    static JsonFileHandler jfh = new JsonFileHandler();

    public static String CreateAdFieldCheck(String regNr, String carType, String carModel, String yearModel, String mileage, String pricePerDay, String gearbox, String fuel) {
        try {
            if (regNr.isEmpty()) {
                return "Registration Number field cannot be empty";
            }if (carType.isEmpty()) {
                return "Car Type field cannot be empty";
            }if (carModel.isEmpty()) {
                return "Car model field cannot be empty";
            }if (yearModel.isEmpty()) {
                return "Year model field cannot be empty";
            }if (mileage.isEmpty()) {
                return "Mileage field cannot be empty";
            }if (pricePerDay.isEmpty()) {
                return "Price field cannot be empty";
            }
            float price = Integer.parseInt(pricePerDay);
            if (regNr.length() < 7) { //checks if number has 7 numbers + letters
                return "Registration Number is too short";
            }if (regNr.length() > 7) { //checks if number has 7 numbers + letters
                return "Registration Number is too long";
            }if (!regNr.matches("[a-zA-Z0-9]+")) { //checks if regnr only contains letters/numbers
                return "Registration Number can only contain Letters and Numbers";
            }if (!mileage.matches("[0-9]+")) {
                return "Mileage can only contain numbers";
            }if (!pricePerDay.matches("[0-9]+")) {
                return "Price can only contain numbers";
            }if (price == 0) {
                return "Price cannot be 0";
            }
            return "";
        } catch (NumberFormatException e) {
            return "Price can only contain numbers";
        }
    }

    public static String BookListingFieldCheck(String regNum, String brand, String model, String year, String mileage, String price, String bookingStartDate, String bookingStartTime, String bookingEndDate, String bookingEndTime) {
        try {
            DateTimeHandler dateTimeHandler = new DateTimeHandler();
            if (regNum.isEmpty() || brand.isEmpty() || model.isEmpty() || year.isEmpty()) {
                return "Something went wrong, please try again later";
            }
            if (bookingStartDate.isEmpty()) {
                return "Booking StartDate cannot be empty";
            }
            if (bookingStartTime.isEmpty()) {
                return "Booking StartTime cannot be empty";
            }
            if (bookingEndDate.isEmpty()) {
                return "Booking EndDate cannot be empty";
            }
            if (bookingEndTime.isEmpty()) {
                return "Booking EndTime cannot be empty";
            }

            if (bookingStartDate.contains(".")) {
                String[] SDF = bookingStartDate.split(".");
                bookingStartDate = (SDF[0] + "-" + SDF[1] + "-" + SDF[2]); }
            if (bookingEndDate.contains(".")) {
                String[] SDF = bookingEndDate.split(".");
                bookingEndDate = (SDF[0] + "-" + SDF[1] + "-" + SDF[2]); }
            String todaysDate = dateTimeHandler.GetTodaysDate();
            String[] td1 = todaysDate.split("-"); //0 - dd, 1 - mm, 2 - yyyy
            String startDate = bookingStartDate;
            String[] sd1 = startDate.split("-"); //0 - dd, 1 - mm, 2 - yyyy
            String endDate = bookingEndDate;
            String[] ed1 = endDate.split("-"); //0 - dd, 1 - mm, 2 - yyyy
            String startTime = bookingStartTime;
            String[] st1 = startTime.split(":"); //0 - hh, 1 - mm
            int startTimeCorrect = dateTimeHandler.CheckTimeFormat(st1);
            String endTime = bookingEndTime;
            String[] et1 = endTime.split(":"); //0 - hh, 1 - mm
            int endTimeCorrect = dateTimeHandler.CheckTimeFormat(et1);
            if (startTimeCorrect == 2 && endTimeCorrect == 2) {
                //Start date
                if (dateTimeHandler.DateComparison(sd1,td1) == 1) {
                    return "StartDate year is in the past";
                } else if (dateTimeHandler.DateComparison(sd1,td1) == 2) {
                    return "StartDate month is in the past";
                } else if (dateTimeHandler.DateComparison(sd1,td1) == 3) {
                    return "Booking must start tomorrow or later";
                } else { //End date
                    if (dateTimeHandler.DateComparison(ed1,td1) == 1) {
                        return "EndDate year is in the past";
                    } else if (dateTimeHandler.DateComparison(ed1,td1) == 2) {
                        return "EndDate month is in the past";
                    } else if (dateTimeHandler.DateComparison(ed1,td1) == 3) {
                        return "EndDate must be at least one day after start date";
                    } else { //Is EndDate after StartDate
                        if (dateTimeHandler.DateComparison(ed1,sd1) == 1) {
                            return "EndDate year is lower than StartDate year";
                        } else if (dateTimeHandler.DateComparison(ed1,sd1) == 2) {
                            return "EndDate month is lower than StartDate month";
                        } else if (dateTimeHandler.DateComparison(ed1,sd1) == 3) {
                            return "EndDate cannot be before StartDate";
                        } else {
                            return "";
                        }
                    }
                }
            } else {
                return "Start or Endtime is invalid";
            }

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "Date or Time Format is wrong (DD-MM-YYYY, HH:MM)";
        }
    }


    public static String PayOrderFieldCheck(String cardNumber, String expireMonth, String expireYear, String cvv) {
        try {
            DateTimeHandler dateTimeHandler = new DateTimeHandler();
            if (cardNumber.isEmpty()) {
                return "Cardnumber cannot be empty";
            }
            if (expireMonth.isEmpty()) {
                return "Expire Month cannot be empty";
            }
            if (expireYear.isEmpty()) {
                return "Expire Year cannot be empty";
            }
            if (cvv.isEmpty()) {
                return "CVV cannot be empty";
            }
            String todaysdate = dateTimeHandler.GetTodaysDate();
            String[] dates = todaysdate.split("-");
            if (cardNumber.length() != 16) {
                return "Cardnumber needs to contain 16 digits";
            }
            else if (!cardNumber.matches("[0-9]+")) {
                return "Cardnumber can only contain numbers";
            }
            else if(cardNumber.startsWith("0")) {
                return "Cardnumber is invalid and cannot start with 0";
            }
            else if (expireMonth.length() != 2) {
                return "Expire month can only contain 2 digits";
            }
            else if (!expireMonth.matches("[0-9]+")) {
                return "Expire month can only contain numbers";
            }
            else if (expireYear.length() != 2) {
                return "Expire year can only contain 2 digits";
            }
            else if (!expireYear.matches("[0-9]+")) {
                return "Expire year can only contain numbers";
            }
            else if (dates[2].substring(dates[2].length()-2).equals(expireYear)) {
                if (Integer.parseInt(dates[1]) >= Integer.parseInt(expireMonth)) {
                    return "Card has expired";
                }
            }
            else if (cvv.length() != 3) {
                return "CVV can only contain 3 digits";
            }
            else if (!cvv.matches("[0-9]+")) {
                return "CVV can only contain numbers";
            } else {//ALL INFO CORRECT
                return "";
            }
        } catch (NumberFormatException n) {
            return "Numberformatexception";
        }
        return "Error";
    }

    public static boolean LogInnUser(String username, int userId) {
        boolean success = false;
        ArrayList<User> userList = jfh.readUserFromJSONfile();
        for (User u: userList) {
            if ((u.getId() == userId) && (u.getFirstName().equals(username))) {
                //user exists
                success = true;
            }
        }
        return success;
    }

    public static ArrayList<Car> GetListings(int userId) {
        boolean success = false;
        ArrayList<Car> carList = jfh.readCarFromJSONfile();
        ArrayList<Car> returnList = new ArrayList<>();
        for (Car c: carList) {
            if (c.getOwnerId() == userId) {
                returnList.add(c);
            }
        }
        if (returnList.isEmpty()) {
            return null;
        }
        return returnList;
    }

    public static boolean DeleteAction(int action, int commit) {
        if (commit == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean LogOutUser() {
        return true;
    }
}
