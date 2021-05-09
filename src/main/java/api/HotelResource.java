package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import model.Room;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {

    public static CustomerService customerService = new CustomerService();
    public static ReservationService reservationService = new ReservationService();
    
    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
        }

    public static IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public static void bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        reservationService.reserveARoom(customerEmail, room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        if (reservationService.getCustomersReservation(customerEmail).isEmpty()) {
            System.out.println("No reservation found!");
        }
        return reservationService.getCustomersReservation(customerEmail);
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);
    }
}
