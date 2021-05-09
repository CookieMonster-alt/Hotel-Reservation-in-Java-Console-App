package model;

import java.util.Date;

public class Reservation {

    private String customer;
    private IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(String customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    //Getter
    public String getCustomer(){
        return this.customer;
    }
    public IRoom getRoom(){
        return this.room;
    }
    
    public Date getCheckInDate(){
        return this.checkInDate;
    }
    
    public Date getCheckOutDate(){
        return this.checkOutDate;
    }

    //Setter
    public void setCustomer(String customer){
        this.customer = customer;
    }
    
    public void setRoom(IRoom room){
        this.room = room;
    }
    
    public void setCheckInDate(Date checkInDate){
        this.checkInDate = checkInDate;
    }
    
    public void setCheckOutDate(Date checkOutDate){
        this.checkOutDate = checkOutDate;
    }
    
    @Override
    public String toString(){
        return "|Customer name : "+this.getCustomer()+
                "\n|Room number : "+this.room.getRoomNumber()+" |Room price : "+this.room.getRoomPrice()+" |Room type : "+this.room.getRoomType()+
                "\n|Check in date : "+this.checkInDate+
                "\n|Check out date : "+this.checkOutDate;
    }
}
