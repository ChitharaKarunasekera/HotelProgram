
import java.util.*;
public class HotelProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;
        String[] hotel = new String[7];
    for (int x = 0; x < 6; x++ ) hotel[x] = ""; //initialise
        initialise(hotel); //better to initialise in a procedure
        while ( roomNum < 6 )
        {
            for (int x = 0; x < 6; x++ )
            {
                if (hotel[x].equals("e"))System.out.println("room " + x + " is empty");
            }
            System.out.println("Enter room number (0-5) or 6 to stop:" );
            roomNum = input.nextInt();
            System.out.println("Enter name for room " + roomNum +" :" ) ;
            roomName = input.next();
            hotel[roomNum] = roomName ;
            for (int x = 0; x < 6; x++ )
            {
                System.out.println("room " + x + " occupied by " + hotel[x]);
            }
        }
    }
    private static void initialise( String hotelRef[] ) {
        for (int x = 0; x < 6; x++ ) hotelRef[x] = "e";
        System.out.println( "initilise ");
    }
}
