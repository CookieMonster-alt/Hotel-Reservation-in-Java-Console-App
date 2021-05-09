package service;

import java.util.ArrayList;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import model.FreeRoom;
import model.RoomType;

public class ReservationService {

    public static HashSet<IRoom> roomsList = new HashSet<>();
    public static HashSet<Reservation> reservationsList = new HashSet<>();
    
    public void addRoom(String roomNumber, int price, RoomType type){
        IRoom room = new FreeRoom(roomNumber, price, type);
        roomsList.add(room);
    }
    public IRoom getARoom(String roomId){
        
        for (IRoom iRoom : roomsList) {
            
            if(iRoom.getRoomNumber().equals(roomId))
                return iRoom;
        }   
        return null;
    }
    public Reservation reserveARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customerEmail, room, checkInDate, checkOutDate);
        reservationsList.add(reservation);
        return reservation;
    }
    
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        
    List<IRoom> foundedRooms = new ArrayList<>();
            
      for(IRoom room : roomsList){
          
          for(Reservation reservation: reservationsList){
            
              if((room.getRoomNumber() == reservation.getRoom().getRoomNumber()&&((!checkInDate.after(reservation.getCheckInDate())&&!checkInDate.before(reservation.getCheckOutDate())) ||
                      (!checkOutDate.after(reservation.getCheckInDate()) && !checkInDate.before(reservation.getCheckOutDate())))) ||
                (!reservation.getRoom().getRoomNumber().contains(room.getRoomNumber()))){
            
                  foundedRooms.add(room);
              }
        }
}
      return foundedRooms;
}
    public Collection<Reservation> getCustomersReservation(String customerEmail){
        
        List<Reservation> customersReservations = new ArrayList<>();
    
        for (Reservation eachcustomerReservation : reservationsList) {
            if(eachcustomerReservation.getCustomer().equals(customerEmail))
                customersReservations.add(eachcustomerReservation);
        }
        return customersReservations;
    }
    
    public Collection<Reservation> printAllReservation(){
        return reservationsList;
    }
    
    public HashSet<IRoom> getAllRooms(){
        return roomsList;
    }
}
