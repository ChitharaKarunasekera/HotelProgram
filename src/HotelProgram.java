
import java.util.*;

public class HotelProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;

        String[] hotel = new String[7];//Array of rooms

        for (int x = 0; x < 6; x++) {
            hotel[x] = "";//initialise
        }

        initialise(hotel); //calling initialize method



        while (true)
        {
            System.out.println("V - ‘View All Rooms ");

            System.out.println("Enter room number (0-5) or 6 to stop:");
            roomNum = input.nextInt();//get the input room number

            //if the room number is not 6
            if(roomNum != 6)
            {
                System.out.println("Enter name for room " + roomNum + " :");
                roomName = input.next();//store name for room
                hotel[roomNum] = roomName;//assign the name to array index holding the room number
            }
            else
            {
                System.out.println("system will terminate!");
                break;
            }
        }
    }

    //Method to initialize empty rooms
    private static void initialise(String hotelRef[]) {
        for (int x = 0; x < 6; x++) {
            hotelRef[x] = "e";
        }
        System.out.println("initialised ");
    }

    //Method to view all rooms
    private static void view(String hotelRef[]) {
        int roomNum = 0;
        while (roomNum < 6) {
            for (int x = 0; x < 6; x++) {
                if (hotelRef[x].equals("e")) {
                    System.out.println("room " + x + " is empty");
                }
            }
            
            for (int x = 0; x < 6; x++) {
                System.out.println("room " + x + " occupied by " + hotelRef[x]);
            }
        }
    }
}
