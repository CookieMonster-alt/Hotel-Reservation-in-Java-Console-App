package api;

import model.Customer;
import model.IRoom;

import java.util.Collection;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

public class AdminResource {

    public static CustomerService customerService = new CustomerService();
    public static ReservationService reservationService = new ReservationService();
    
    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public static void addRoom(String roomNumber, int price, RoomType type){
        reservationService.addRoom(roomNumber, price, type);
    }
    public static Collection<IRoom> gettAllRooms(){
            if(reservationService.getAllRooms().isEmpty()){
                System.out.println("No records found!");
            }
        return reservationService.getAllRooms();
    }
    public static Collection<Customer> getAllCustomers(){
            if(customerService.getAllCustomers().isEmpty()){
                System.out.println("No records found!");
            }
        return customerService.getAllCustomers();
    }
    
    public static void displayAllReservations(){
        if(reservationService.printAllReservation().isEmpty()){
            System.out.println("No reservation foumd!");
        }
        else{
            System.out.println(reservationService.printAllReservation());
        }
    }
}
