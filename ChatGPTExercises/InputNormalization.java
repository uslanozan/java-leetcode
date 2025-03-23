/*
🚀 Improved Task: User Input Validation & Normalization
Scenario:
We will write a Java service that validates and normalizes user inputs for a web application.

Requirements:
📌 Name-Surname:

First letter should be uppercase, others should be lowercase. (john DOE → John Doe)
Must contain only letters. (J0hn D03 ❌)
📌 Email:

Remove spaces at the beginning and end.
Convert to lowercase.
Must contain @ and .
📌 Phone:

Must be normalized to +90 format. ("00905321234567" or "5321234567" → "+905321234567")
Only Turkish numbers should be accepted (those not starting with +90 ❌).
📌 Password:

Must be at least 8 characters long.
Must contain at least 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character (!@#$%^&*).

📌 Method Output:
Write a Java method that performs all these checks and returns a Map<String, String> containing the verified data.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputNormalization {
    public static void main(String[] args) {

        Map<String, String> result = validateAndNormalizeUserInput("John Doe", "johndoe@example.com", "5515963209",
                "ValidPassword123!");

        System.out.println(result);
    }

    public static Map<String, String> validateAndNormalizeUserInput(String fullName,
     String email, String phone, String password) {

        Map<String, String> results = new HashMap<String, String>();
        List<String> errors = new ArrayList<>();
        String specialChars = "!@#$%&*()_+=|<>?{}\\[\\]~-";

        // Check fullName
        String[] nameParts = fullName.trim().split(" ");
        if (nameParts.length < 2) {
            errors.add("Full name must contain at least first and last name.");
        } else {
            String item;
            String name;

            for (int i = 0; i < nameParts.length; i++) {
                item = nameParts[i];
                name = (i == 0) ? "lastName" : "firstName";

                // This regex check if includes number
                if (item.matches(".*\\d.*")) {
                    results.put(name, "Invalid");
                    errors.add(item + " is wrong. Cannot contain number !");
                    continue;
                }
                // First char is lowercase
                else if (!Character.isUpperCase(item.charAt(0))) {
                    results.put(name, "Invalid");
                    errors.add(item + " is wrong. Cannot start with lowercase !");
                    continue;
                }
                // This regex check rest of the item if it uppercase
                else if (!item.substring(1).matches("[a-z]+")) {
                    results.put(name, "Invalid");
                    errors.add(item + " is wrong. Cannot continue with uppercase !");

                    continue;
                }

                results.put(name, item);
            }
        }

        // Check email
        String newEmail = email.replace(" ", "");
        newEmail = newEmail.toLowerCase();
        // If not contains @ and .
        if( !(newEmail.contains("@") && newEmail.contains("."))){
            results.put(email, "Invalid");
            errors.add(email + " is wrong. Email must contain '@' and '.'");
        }else{
            results.put("email", newEmail);
        }

        // Check number
        for (int index = 0; index < phone.length(); index++) {
            if( (phone.charAt(index) == '5')){
                phone = phone.substring(index);
                phone = "+90"+phone;
                if(phone.length() == 13){
                    results.put("phone", phone);
                }else{
                    results.put("phone", "Invalid");
                    errors.add("Phone must be 10 units");
                }
                break;
            }
        }

        // Check password
        if(password.length() < 8){
            results.put("password", "Invalid");
            errors.add("Password must be longer than 7");
        }else{
            // If no number in it
            if(!password.matches(".*\\d.*")){
                results.put("password", "Invalid");
                errors.add("Password must contain a number");
            }else{
                // If no lowercase letter
                if(!password.matches(".*[a-z].*")){
                    results.put("password", "Invalid");
                    errors.add("Password must contain a lowercase letter");
                }else{
                    // If no uppercase letter
                    if(!password.matches(".*[A-Z].*")){
                        results.put("password", "Invalid");
                        errors.add("Password must contain a uppercase letter");
                    }else{
                        // If no special characters
                        boolean hasSpecial = false;
                        for (char letter : password.toCharArray()) {
                            if (specialChars.indexOf(letter) != -1) { 
                                hasSpecial = true;
                                break;  // Özel karakter bulunduğunda döngüden çık!
                            }
                        }
                        
                        if (!hasSpecial) {
                            results.put("password", "Invalid");
                            errors.add("Password must contain a special character");
                        } else {
                            results.put("password", "******");
                        }
                    }
                }
            }
        }

        if(errors.isEmpty()){
            System.out.println("No Error");
            System.out.println("\nCongrats! Please go on to verify your account!\n");
        }else{
            System.out.println(errors);
        }
        return results;

    }
}
