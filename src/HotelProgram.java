
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
            //Option Menu
            System.out.println(
                    "\n----------------------------\n" +
                            "V - View All Rooms\n" +
                            "A - Add Customer to Room\n" +
                            "E - Display Empty rooms\n" +
                            "D - Delete customer from room\n" +
                            "F - Find room from customer name\n" +
                            "S - Store program data into file\n" +
                            "L - Load program data from file\n" +
                            "O - Ordered alphabetically by name.\n" +
                            "S - Stop\n" +
                            "----------------------------"
            );

            System.out.print("Select your option: ");
            option = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case

            if (option == 'V') {
                System.out.println("View all Rooms.");
                view(hotel);//calling view method
            } else if (option == 'A') {
                System.out.println("Add customer to room.");
                add(hotel);//calling add method
            } else if (option == 'E') {
                System.out.println("Empty rooms.");
                //calls the isEmpty method and checks if each room is empty or not
                for (int i=0; i<hotel.length-1; i++)
                {
                    if(isEmpty(hotel,i) != -1)
                    {
                        System.out.println("Room " + i);//Display room number is the function returns the number
                    }
                }
            } else if (option == 'S') {
                System.out.println("System will terminate!");
                break;
            }
        }
    }

    //find empty rooms
    private static int isEmpty(String hotelRef[], int roomNum) {
        if (hotelRef[roomNum].equals("e")) {
            //System.out.println("room " + roomNum + " is empty");
            return roomNum;
        } else
            //return -1 if the room is occupied
            return -1;
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
            if (isEmpty(hotelRef,x) != -1) {
                //if the method's return value is not -1 the room is empty
                System.out.println("room " + x + " is empty");
            } else {
                //when return value is -1 the room is occupied. then display by whom it is
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
            System.out.print("Enter room number (0-5) or 6 to stop:");
            roomNum = input.nextInt();//get the input room number

            //if the room number is between the existing room numbers
            if (roomNum < 6 && roomNum >= 0) {
                System.out.print("Enter name for room " + roomNum + " :");
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
                System.out.println("\nInvalid room number!\n");
            }
        }
    }
}
