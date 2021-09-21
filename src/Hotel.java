import java.util.Locale;
import java.util.Scanner;
import java.io.File;//File Classes to create file
import java.io.IOException;// class ro handle error in file handling
import java.io.FileWriter;//File class to write to file
import java.io.FileNotFoundException;//Exception if file was not found

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

    //Find empty rooms
    public int isEmpty(int roomNum) {
        //Check if room name is "e"
        if (getRooms()[roomNum].getRoomName().equals("e")) {
            return roomNum;
        } else
            //return -1 if the room is occupied
            return -1;
    }

    //View all rooms
    public void view() {
        for (int x = 0; x < getRooms().length; x++) {
            if (isEmpty(x) != -1) {
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
                if (isEmpty(roomNum) != -1) {
                    System.out.print("Enter name for room " + roomNum + " : ");
                    roomName = input.next();//store name for room
                    roomName = roomName.substring(0, 1).toUpperCase(Locale.ROOT) + roomName.substring(1);
                    getRooms()[roomNum].setRoomName(roomName);
                    System.out.println("Customer " + getRooms()[roomNum].getRoomName() + " was successfully added to room " + roomNum + "\n");
                } else {
                    System.out.println("Sorry! This room is already occupied. Please choose a different room.\n");
                }
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

    //Delete customers from rooms
    public void delete(int roomNum) {
        Scanner input = new Scanner(System.in);
        char ans;

        //check if the room is not empty
        if (isEmpty(roomNum) == -1) {
            //confirm the request
            System.out.print("Are you sure you want to remove Customer " + getRooms()[roomNum].getRoomName() + " from room" + roomNum + "(y/n)?");
            ans = (char) (input.next().charAt(0) & 0x5f);//Convert inout to upper case

            //remove the customer if the request was confirmed or else cancel the requests
            if (ans == 'Y') {
                System.out.println(getRooms()[roomNum].getRoomName() + " was removed from room " + roomNum);
                getRooms()[roomNum].setRoomName("e");

            } else {
                System.out.println("Request has been canceled! Customer " + getRooms()[roomNum].getRoomName() + " was not removed.");

            }
        } else {
            System.out.println("\nSorry! This room is already empty.\n");

        }
    }

    //Find customer from name
    public void find(String roomName) {
        for (int i = 0; i < getRooms().length; i++) {
            if (getRooms()[i].getRoomName().equalsIgnoreCase(roomName)) {
                System.out.println("Customer " + getRooms()[i].getRoomName() + " is in room " + i);
                break;
            }
            if (i == getRooms().length - 1) {
                System.out.println("Sorry! Customer " + roomName + " does not exist.");
            }
        }
    }

    //Store program data to file
    public void store() {
        //Writing data to file
        try {
            FileWriter writerObject = new FileWriter("E:\\Java\\HotelProgram\\hotelData.txt");//Writer object
            //writerObject.write("From store method!\n");
            //writing data to file
            for (int i = 0; i < getRooms().length; i++) {
                if (isEmpty(i) != -1) {
                    //if the method's return value is not -1 the room is empty
                    writerObject.write("room " + i + " is empty\n");
                } else {
                    //when return value is -1 the room is occupied. then display by whom it is
                    writerObject.write("room " + i + " occupied by " + getRooms()[i].getRoomName() + "\n");
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
    public void load() {
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
            e.printStackTrace();
        }
    }

    //View guests ordered alphabetically by name.
    public void sortNames() {
        String temp;
        System.out.println("\nGuests Ordered alphabetically");

        //Arrange the names in order using bubble sort algorithm
        for (int j = 0; j < getRooms().length-1; j++) {
            for (int i = j + 1; i < getRooms().length-1; i++) {
                if (!(getRooms()[i].getRoomName().equals("e"))) {
                    //Check if the first element of the array is less than the next element and swap them
                    if (getRooms()[i].getRoomName().compareTo(getRooms()[j].getRoomName()) < 0) {
                        temp = getRooms()[j].getRoomName();
                        getRooms()[j].setRoomName(getRooms()[i].getRoomName());
                        getRooms()[i].setRoomName(temp);
                    }
                }
            }
        }

        for (int i = 0; i < getRooms().length-1; i++) {
            if (!(getRooms()[i].getRoomName().equals("e"))) {
                System.out.println(getRooms()[i].getRoomName());//Display the sorted names if the name is not "e"
            }
        }
    }
}
