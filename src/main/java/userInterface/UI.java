package userInterface;

import api.AdminResource;
import api.HotelResource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

public class UI {
    
    private static final AdminResource adminResource = new AdminResource();
    private static final HotelResource hotelResource = new HotelResource();
    
    
    public static void userInterface(){
        
        int userChoice = 0;
        Scanner input = new Scanner(System.in);
    do {
        try{
            System.out.println("-----------Main--Menu-----------\n");
            System.out.println("1-Find and reserve a room");
            System.out.println("2-See my reservations");
            System.out.println("3-Create an account");
            System.out.println("4-Admin");
            System.out.println("5-(E)xit\n");
            System.out.println("--------------------------------");
            System.out.print("Choose an option please : ");

            userChoice = Integer.parseInt(input.nextLine());
            switch (userChoice) {
                case 1:
                    customerFindAndReserveRoom();
                    break;
                case 2:
                    customerSeeReservation();
                    break;
                case 3:
                    customerCreateAccount();
                    break;
                case 4:
                    adminMenu();
                case 5:
                    System.out.println("---------------------------------");
                    System.out.println("Thank you for choosing us!");
                    System.out.println("Hotel Reservation App ");
                    break;
            }   
        }
        catch(NumberFormatException e){
            System.out.println("Please enter number!!");
        }
    }
    while (userChoice!=5);
}
    
    public static void adminMenu() {

            int userChoice = 0;
            Scanner input = new Scanner(System.in);
    do{    
        try{
            System.out.println("-----------Admin--Menu-----------\n");
            System.out.println("1-See all customers");
            System.out.println("2-See all rooms");
            System.out.println("3-See all reservations");
            System.out.println("4-Add a room");
            System.out.println("5-(B)ack to the main menu\n");
            System.out.println("---------------------------------");
            System.out.print("Choose an option please : ");
            
            userChoice = Integer.parseInt(input.nextLine());
            switch (userChoice) {
                case 1:
                    adminSeeAllCustomers();
                    break;
                case 2:
                    adminSeeAllRooms();
                    break;
                case 3:
                    AdminResource.displayAllReservations();
                    break;
                case 4:
                    adminAddRoom();
                    break;
                case 5:
                    userInterface();
                    break;
            }
            
        }
        catch(NumberFormatException e){
            System.out.println("Please enter number!");
        }
    }
    while (userChoice!=5);
    
}
        
        public static void customerCreateAccount(){
            Scanner input = new Scanner(System.in);
            String email, name, lastName;
            
            System.out.println("---------Create--Account---------");
            System.out.print("Please enter your name : ");
            name = input.nextLine();
            System.out.print("Last name : ");
            lastName = input.nextLine();
            System.out.print("Email (name@server.com) : ");
            email = input.nextLine();
            hotelResource.createACustomer(email, lastName, lastName);
            System.out.println("Account created!");
        }
        
        public static void adminSeeAllCustomers(){
            for (Customer each : AdminResource.getAllCustomers()) {
                System.out.println(each.toString());
            }
        }
        
        public static void adminSeeAllRooms(){
            for (IRoom each : AdminResource.gettAllRooms()) {
                System.out.println(each.toString());
            }
        }
        
        public static void adminAddRoom(){
            Scanner input = new Scanner(System.in);
            String number;
            int price;
            int type;
            RoomType t = null;
            System.out.println("----------Add--Room----------");
            System.out.print("Please enter room number : ");
            number = input.nextLine();
            System.out.print("Please enter price per night : ");
            price = Integer.parseInt(input.nextLine());
            System.out.println("(1) for Single Room");
            System.out.println("(2) for Double Room");
            System.out.print("Room type :");
            type = input.nextInt();
            if (type==1) {
                t = RoomType.SINGLE;
            }
            else if(type==2){
                t = RoomType.DOUBLE;
            }
            AdminResource.addRoom(number, price, t);
            System.out.println("Room added!");
        }
        
        public static void customerFindAndReserveRoom(){
            Scanner input = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String checkInDateString = null, checkOutDateString = null, key=null, emailString, roomNumber;
            IRoom room = new Room();
            Date chOut = new Date();
            Date chIn = new Date();
            boolean b = true;
            
            System.out.println("---------Reserve-A-Room---------");
            
            do{
            System.out.print("Enter check-in date (01-01-2020) : ");
            checkInDateString = input.next();
            } while(!isValidDate(checkInDateString));
            
            try {
                chIn = dateFormat.parse(checkInDateString);
            } catch (ParseException e) {
                e.getMessage();
            }
            
            do{
            System.out.print("Enter check-out date (01-01-2020) : ");
            checkOutDateString = input.next();
            } while (!isValidDate(checkOutDateString));
            
            try {
                chOut = dateFormat.parse(checkOutDateString);
            } catch (ParseException e) {
                e.getMessage();
            }
            
            System.out.println("Available rooms for this days :");
            System.out.println(HotelResource.findARoom(chIn, chOut));
            
            while(true){
            try{
                System.out.print("Would you like to book a room? (Y)-(N) :");
                if (input.next().equalsIgnoreCase("Y")) {
                    System.out.print("Do you have account with us? (Y)-(N)");
                    if (input.next().equalsIgnoreCase("Y")) {
                        System.out.print("Please type your email : ");
                        emailString = input.next();
                        if(HotelResource.getCustomer(emailString).getEmail().equals(emailString)){
                            System.out.print("What room would you like to reserve? : ");
                            input.nextLine();
                            roomNumber = input.nextLine();
                            room = HotelResource.getRoom(roomNumber);
                            HotelResource.bookARoom(emailString, room, chIn, chOut);
                            System.out.println("Reservation done!");
                            System.out.println(HotelResource.getCustomerReservations(emailString));
                            break;
                        }
                        else {//if(!HotelResource.customerService.getCustomer(emailString).getEmail().equals(emailString)){
                            System.out.println("Could not find your record!");
                            break;
                        }
                    }
                        else{
                            customerCreateAccount();
                        }
            }
                else {
                    break;
                }

            }catch(Exception e){}
        }
            
        }
        
        public static boolean isValidDate(String date){
            boolean b = false;
            try {
            String regex = "^\\d{2}-\\d{2}-\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(date);
            b = matcher.matches();
            if(b==true){
                return b;
            }
            else{
                System.out.println("Please enter date in right format! Example : 01-01-2020");
            }
            } catch(PatternSyntaxException e){
                System.out.println("Invalid input!");
                return false;
            }
            return b;
        }
        
        public static void customerSeeReservation(){
            Scanner input = new Scanner(System.in);
            String emailString;
            try{
            System.out.println("---------My-Reservations---------");
            System.out.println("Please enter your email : ");
            emailString = input.nextLine();
            System.out.println(HotelResource.getCustomerReservations(emailString));
            }
            catch(NullPointerException e){System.out.println("No reservation found!");}
        }
}
