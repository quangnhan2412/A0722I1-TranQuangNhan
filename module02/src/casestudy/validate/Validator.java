package casestudy.validate;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Validator {
    public static LocalDate dateInputDOB(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(userInput, dateFormat);
    }


//    public static LocalDate dateInput(String userInput)  {
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate birthDay = null;
//        try {
//            birthDay = LocalDate.parse(userInput, dateFormat);
//            LocalDate now = LocalDate.now();
//            if (now.getYear() - birthDay.getYear() < 18 || now.getYear() - birthDay.getYear() > 100) {
//                throw new IOException("Age You must be over 18 years old and less than 100 years old");
//            }
//            return birthDay;
//        } catch ( DateTimeParseException | IOException e) {
//            System.out.println("Date of Birth Incorrect Format (yyyy-MM-dd)");;
//        }
//        return birthDay;
//    }

//    public static void main(String[] args)throws Exception {
//        String sDate1="31/12/1998";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        simpleDateFormat.setLenient(false);
//        Date date1=simpleDateFormat.parse(sDate1);
//        System.out.println(sDate1+"\t"+date1);
//    }

}
