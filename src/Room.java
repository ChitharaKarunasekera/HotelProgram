public class Room {
    private final int roomNum;
    private String roomName;
    private int noOfGuests;
    private Person payingGuest;

    public Room(int roomNum, String roomName){
        this.roomNum = roomNum;
        this.roomName = roomName;
        this.noOfGuests = 0;
        this.payingGuest = null;
    }

    //Getters
    public int getRoomNum() {
        return roomNum;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public Person getPayingGuest() {
        return payingGuest;
    }

    public String getRoomName(){
        return roomName;
    }

    //Setters
    public void setRoomName(String roomName){
        this.roomName = roomName;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public void addPayingGuest(String firstName, String lastName, String creditCardNo){
        this.payingGuest = new Person(firstName, lastName, creditCardNo);
    }

    public void deletePayingGuest(){
        this.payingGuest = null;
    }
}
