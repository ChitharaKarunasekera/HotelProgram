
import java.util.*;

public class HotelProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char option;

        String[] hotel = new String[7];//Array of rooms

        for (int x = 0; x < 6; x++) {
            hotel[x] = "";//initialise
        }

        initialise(hotel); //calling initialize method


        while (true) {
            System.out.println(
                    "\n----------------------------\n" +
                            "V - View All Rooms\n" +
                            "A - Add Customer to Room\n" +
                            "S - Stop\n" +
                            "----------------------------"
            );
            
            System.out.print("Select your option: ");
            option = (char) (input.next().charAt(0) & 0x5f);
            
            if (option == 'V')
            {
                System.out.println("View all Rooms.");
                view(hotel);//calling view method
            }
            else if(option == 'A')
            {
                System.out.println("Add customer to room.");
                add(hotel);//calling add method
            }
            else if (option == 'S')
            {
                System.out.println("System will terminate!");
                break;
            }
        }
    }

    //Method to initialize empty rooms
    private static void initialise(String hotelRef[]) {
        for (int x = 0; x < 6; x++) {
            hotelRef[x] = "e";
        }
    }

    //Method to view all rooms
    private static void view(String hotelRef[]) {
        for (int x = 0; x < 6; x++) {
            if (hotelRef[x].equals("e")) {
                System.out.println("room " + x + " is empty");
            } else {
                System.out.println("room " + x + " occupied by " + hotelRef[x]);
            }
        }
    }

    //Method to add customers
    private static void add(String hotelRef[]) {
        Scanner input = new Scanner(System.in); //
        String roomName;
        int roomNum;

        while (true) {
            System.out.println("Enter room number (0-5) or 6 to stop:");
            roomNum = input.nextInt();//get the input room number

            //if the room number is between the existing room numbers
            if (roomNum < 6 && roomNum >= 0) {
                System.out.println("Enter name for room " + roomNum + " :");
                roomName = input.next();//store name for room
                hotelRef[roomNum] = roomName;//assign the name to array index holding the room number
            }
            //if number is 6 stop adding customers
            else if (roomNum == 6) {
                System.out.println("Stopped adding customers to rooms");
                break;
            }
            //Entered an invalid room number
            else {
                System.out.println("Invalid room number. Please enter a number between 0 - 5");
            }
        }
    }
}
