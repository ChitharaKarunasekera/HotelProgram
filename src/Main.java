import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hotel myHotel = new Hotel();//all rooms gets initialized to "z"

        char option;//users option at the menu
        int roomNum;//room number required
        String roomName;//required room name

        String[] hotel = new String[7];//Array of rooms


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
                            "Q - Quit\n" +
                            "----------------------------"
            );

            System.out.print("Select your option: ");
            option = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case
            System.out.println("");

            if (option == 'V') {
                System.out.println("View all Rooms.");
                //view(hotel);//calling view method
                myHotel.view();
            } else if (option == 'A') {
                System.out.println("Add customer to room.");
                myHotel.add();//calling add method
            } else if (option == 'E') {
                System.out.println("Empty rooms.");
                //calls the isEmpty method and checks if each room is empty or not
                for (int i = 0; i < hotel.length - 1; i++) {
                    if (myHotel.isEmpty(i) != -1) {
                        System.out.println("Room " + i);//Display room number is the function returns the number
                    }
                }
            } else if (option == 'D') {
                System.out.println("Delete a customer.");
                System.out.print("Enter Room number: ");
                roomNum = input.nextInt();//store the room number the user want to delete
                myHotel.delete(roomNum);
            } else if (option == 'F') {
                System.out.println("Find a customer.");
                System.out.print("Enter the name for room: ");
                roomName = input.next();//get the name to find room number
                myHotel.find(roomName);
            } else if (option == 'S') {
                System.out.println("Storing data to file.");
                myHotel.store();
            } else if (option == 'L') {
                System.out.println("Loading data from file.");
                myHotel.load();
            } else if (option == 'O') {
                System.out.println("Names in Alphabetical order.");
                myHotel.sortNames();
            } else if (option == 'Q') {
                System.out.println("System will terminate!");
                break;
            }
        }
    }
}
