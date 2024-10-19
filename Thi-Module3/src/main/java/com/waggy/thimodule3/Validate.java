package com.waggy.thimodule3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean validateUsername(String username) {
        String regex = "^[a-zA-Z0-9]{5,50}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }


}
