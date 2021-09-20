import java.util.*;
import java.io.File;//File Classes to create file
import java.io.IOException;// class ro handle error in file handling
import java.io.FileWriter;//File class to write to file
import java.io.FileNotFoundException;//Exception if file was not found

public class HotelProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char option;//users option at the menu
        int roomNum;//room number required
        String roomName;//required room name

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
                            "Q - Quit\n" +
                            "----------------------------"
            );

            System.out.print("Select your option: ");
            option = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case
            System.out.println("");

            if (option == 'V') {
                System.out.println("View all Rooms.");
                view(hotel);//calling view method
            } else if (option == 'A') {
                System.out.println("Add customer to room.");
                add(hotel);//calling add method
            } else if (option == 'E') {
                System.out.println("Empty rooms.");
                //calls the isEmpty method and checks if each room is empty or not
                for (int i = 0; i < hotel.length - 1; i++) {
                    if (isEmpty(hotel, i) != -1) {
                        System.out.println("Room " + i);//Display room number is the function returns the number
                    }
                }
            } else if (option == 'D') {
                System.out.println("Delete a customer.");
                System.out.print("Enter Room number: ");
                roomNum = input.nextInt();//store the room number the user want to delete
                delete(hotel, roomNum);
            } else if (option == 'F') {
                System.out.println("Find a customer.");
                System.out.print("Enter the name for room: ");
                roomName = input.next();//get the name to find room number
                find(hotel, roomName);
            } else if (option == 'S') {
                System.out.println("Storing data to file.");
                store(hotel);
            } else if (option == 'L') {
                System.out.println("Loading data from file.");
                load();
            } else if (option == 'O') {
                System.out.println("Names in Alphabetical order.");
                sortNames(hotel);
            } else if (option == 'Q') {
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
            if (isEmpty(hotelRef, x) != -1) {
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

    private static void delete(String hotelRef[], int roomNum) {
        Scanner input = new Scanner(System.in);
        char ans;

        while (true) {
            //check if the room is not empty
            if (isEmpty(hotelRef, roomNum) == -1) {
                //confirm the request
                System.out.print("Are you sure you want to remove Customer " + hotelRef[roomNum] + " from room" + roomNum + "(y/n)?");
                ans = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case

                //remove the customer if the request was confirmed or else cancel the requests
                if (ans == 'Y') {
                    System.out.println(hotelRef[roomNum] + " was removed from room " + roomNum);
                    hotelRef[roomNum] = "e";
                    break;
                } else {
                    System.out.println("Request has been canceled! Customer " + hotelRef[roomNum] + " was not removed.");
                    break;
                }
            } else {
                System.out.println("\nSorry! This room is already empty.\n");
            }
        }
    }

    //Function to find customer from name
    private static void find(String hotelRef[], String roomName) {
        for (int i = 0; i < hotelRef.length - 1; i++) {
            if (hotelRef[i].equalsIgnoreCase(roomName)) {
                System.out.println("Customer " + hotelRef[i] + " is in room " + i);
                break;
            }
            if (i == hotelRef.length - 2) {
                System.out.println("Sorry! Customer " + roomName + " does not exist.");
            }
        }
    }

    //Store program data to file
    private static void store(String hotelRef[]) {
        //Writing data to file
        try {
            FileWriter writerObject = new FileWriter("E:\\Java\\HotelProgram\\hotelData.txt");//Writer object
            writerObject.write("From store method!\n");
            //writing data to file
            for (int i = 0; i < hotelRef.length - 1; i++) {
                if (isEmpty(hotelRef, i) != -1) {
                    //if the method's return value is not -1 the room is empty
                    writerObject.write("room " + i + " is empty\n");
                } else {
                    //when return value is -1 the room is occupied. then display by whom it is
                    writerObject.write("room " + i + " occupied by " + hotelRef[i] + "\n");
                }
            }
            writerObject.close();//close file
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred! Could not write to file.");
            e.printStackTrace();//throw exception
        }
    }

    //Loading data from file
    private static void load() {
        try {
            File fileObject = new File("E:\\Java\\HotelProgram\\hotelData.txt");
            Scanner fileReader = new Scanner(fileObject);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();//
        }
    }

    //View guests ordered alphabetically by name.
    private static void sortNames(String hotelRef[]) {
        String temp;
        System.out.println("\nGuests Ordered alphabetically");

        //Arrange the names in order using bubble sort algorithm
        for (int j = 0; j < hotelRef.length-1; j++) {
            for (int i = j + 1; i < hotelRef.length-1; i++) {
                if (!(hotelRef[i].equals("e"))) {
                    //Check if the first element of the array is less than the next element and swap them
                    if (hotelRef[i].compareTo(hotelRef[j]) < 0) {
                        temp = hotelRef[j];
                        hotelRef[j] = hotelRef[i];
                        hotelRef[i] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < hotelRef.length-1; i++) {
            if (!(hotelRef[i].equals("e"))) {
                System.out.println(hotelRef[i]);//Display the sorted names if the name is not "e"
            }
        }
    }
}
