package model;

public class Room implements IRoom {

    String roomNumber;
    private int price;
    private RoomType type;
    private boolean isFree;

    public Room() {
    }
    
    public Room(String roomNumber, int price, RoomType type) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
        this.isFree = false;
    }

    //Interface methods
    @Override
    public String getRoomNumber(){
        return this.roomNumber;
    }
    @Override
    public int getRoomPrice(){
        return this.price;
    }
    @Override
    public RoomType getRoomType(){
        return this.type;
    }

    //Setter methods
    public void setRoomNumber(String number){
        this.roomNumber = number;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setRoomType(RoomType type){
        this.type = type;
    }
    
    @Override
    public boolean isFree(){
        return false;
    }

    @Override
    public String toString(){
        return "|Room number : "+roomNumber+" |Room price : "+price+" |Is available : "+this.isFree();
    }

}
