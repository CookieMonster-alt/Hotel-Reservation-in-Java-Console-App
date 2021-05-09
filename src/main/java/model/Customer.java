package model;
import java.util.Scanner;
import java.util.regex.*;

public class Customer {
    
    private String firstName;
    private String lastName;
    private String email;

    public Customer() {
    }

    Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        emailMatcher(email);
    }

    //Getter methods
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }

    //Setter methods
    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
        emailMatcher(email);
    }

    //Email address format correcter
    public void emailMatcher(String email) {

        String emailPattern = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        Scanner scanKey = new Scanner(System.in);
        boolean isEmailRight;
        String key;

        if (!pattern.matcher(this.getEmail()).matches()) {
            System.out.println("Email address does not match with right format!!");
            isEmailRight = false;

            while (!isEmailRight == true) {
                System.out.print("Please enter email in right format (name@server.com) : ");
                key = scanKey.nextLine();

                if (pattern.matcher(key).matches()) {
                    isEmailRight = true;
                    email = key;
                    this.setEmail(email);
                }
                else {
                    isEmailRight = false;
                }
            }
        }
    }

    @Override
    public String toString(){
        return "|Custumer name : "+this.firstName+" |Last name : "+this.lastName+" |Email :"+this.email;
    }
}
