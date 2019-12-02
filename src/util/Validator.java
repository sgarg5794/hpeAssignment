package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static String validateCredetials(BufferedReader inputReader,Map<String,String> employeeData) throws IOException {
        String loggedInEmployee="";
        while(true){
            System.out.println("Login into system :please enter userid and password separated by space");
            String usrNamePassword = inputReader.readLine();
            if (usrNamePassword.contains(" ")) {
                String[] userNamePassword = usrNamePassword.split(" ");
                if(employeeData.keySet().contains(userNamePassword[0]) &&
                        employeeData.get(userNamePassword[0]).equals(userNamePassword[1])){
                    System.out.println("Authentication Successful");
                    loggedInEmployee=userNamePassword[0];
                    break;
                }else{
                    System.out.println("Invalid Credentails");
                    continue;
                }
            }else {
                System.out.println("Invalid Input");
                continue;
            }
        }
        return loggedInEmployee;

    }

    public boolean validateEmail(String email){
        String  emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        Pattern  pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("[1-9]{1}[0-9]{9}");
    }


}
