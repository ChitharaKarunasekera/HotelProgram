import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Hotel {
    private Room rooms[] = new Room[6];//hotel contains 5 rooms

    public Room[] getRooms() {
        return rooms;
    }

    public Hotel() {
        for (int x = 0; x < getRooms().length; x++) {
            getRooms()[x] = new Room(x, "e");
        }
    }

    //View all rooms
    public void view() {
        for (int x = 0; x < getRooms().length; x++) {
            if (getRooms()[x].getRoomName() == "e") {
                //if the method's return value is not -1 the room is empty
                System.out.println("room " + x + " is empty");
            } else {
                //when return value is -1 the room is occupied. then display by whom it is
                System.out.println("room " + x + " occupied by " + this.rooms[x].getRoomName());
            }
        }
    }

    //Add customers
    public void add() {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum;

        while (true) {
            System.out.print("Enter room number (0-5) or 6 to stop: ");
            roomNum = input.nextInt();//get the input room number

            //if the room number is between the existing room numbers
            if (roomNum < 6 && roomNum >= 0) {
                System.out.print("Enter name for room " + roomNum + " : ");
                roomName = input.next();//store name for room
                roomName = roomName.substring(0, 1).toUpperCase(Locale.ROOT) + roomName.substring(1);
                getRooms()[roomNum].setRoomName(roomName);
            }
            //if number is 6 stop adding customers
            else if (roomNum == 6) {
                System.out.println("Stopped adding customers to rooms");
                break;
            }
            //Entered an invalid room number
            else {
                System.out.println("\nInvalid room number!\n");
            }
        }
    }
}
