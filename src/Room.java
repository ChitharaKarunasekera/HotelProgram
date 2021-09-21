public class Room {
    private final int roomNum;
    private String roomName;

    public Room(int roomNum, String roomName){
        this.roomNum = roomNum;
        this.roomName = roomName;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public String getRoomName(){
        return roomName;
    }

    public void setRoomName(String roomName){
        this.roomName = roomName;
    }
}
