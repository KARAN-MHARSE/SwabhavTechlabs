package com.aurionpro.bms.util;

import java.util.regex.Pattern;

public class InputValidatorUtil {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final String MOBILE_REGEX = "^[0-9]{10}$";
    private static final Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX);

    private static final String AADHAR_REGEX = "^[0-9]{12}$";
    private static final Pattern AADHAR_PATTERN = Pattern.compile(AADHAR_REGEX);

    private InputValidatorUtil() {}

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidMobileNumber(Long mobileNumber) {
        if (mobileNumber == null) return false;
        return MOBILE_PATTERN.matcher(String.valueOf(mobileNumber)).matches();
    }

    public static boolean isValidAdharNumber(Long adharNumber) {
        if (adharNumber == null) return false;
        return AADHAR_PATTERN.matcher(String.valueOf(adharNumber)).matches();
    }
}
