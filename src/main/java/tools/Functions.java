package tools;

public final class Functions {


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
            if (bookingEndTime.isEmpty()) {
                return "Booking Date cannot be empty";
            }
            if (bookingEndDate.isEmpty()) {
                return "Booking Date cannot be empty";
            }
            if (bookingStartTime.isEmpty()) {
                return "Booking Date cannot be empty";
            }
            if (bookingStartDate.isEmpty()) {
                return "Booking Date cannot be empty";
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
                    return "Cars can be booked at least one day after the application date";
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
            System.out.println(dates[2].substring(dates[2].length()-2));
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
}
