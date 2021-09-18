
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



        while (true)
        {
            System.out.println(
                    "V - ‘View All Rooms" +
                    "A - Add Customer to Room");

            System.out.println("Select your option: ");
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

    //Method to add customers
    private static void add(String hotelRef[]) {
        Scanner input = new Scanner(System.in); //
        String roomName;
        int roomNum;
    }
}
