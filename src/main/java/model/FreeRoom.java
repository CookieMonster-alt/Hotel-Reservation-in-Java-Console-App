package model;

public class FreeRoom extends Room{
    
    public FreeRoom(String roomNumber, int price, RoomType type) {
        super(roomNumber, price, type);
    }

    @Override
    public boolean isFree() {
        return true;
    }
    
    @Override
    public String toString(){
        return "|Room number : "+super.getRoomNumber()+" |Price per night : "+super.getRoomPrice()+" |Room type : "+super.getRoomType()+" |Is Available? : "+this.isFree();
    }
}
