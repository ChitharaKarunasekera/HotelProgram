public class Queue {
    private int SIZE = 8;
    private Room roomQueue[] = new Room[SIZE];
    private int front, rear;

    // Creating a queue with rooms initialized with "e"
    public Queue() {
        front = -1;
        rear = -1;

        for (int i = 0; i < roomQueue.length; i++) {
            roomQueue[i] = new Room(i,"e");//pass "e" as name to initialize all rooms through rooms constructor
        }
    }

    boolean isFull() {
        if (front == 0 && rear == SIZE - 1)
        {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Add elements into stack
    public Room push() {
        if (front == -1)
            front = 0;
        rear++;
        return roomQueue[rear];
    }

    // Remove element from stack
    public Room pop() {
        Room element;
        element = roomQueue[front];
        if (front >= rear) {
            //remove last element
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }
        return (element);
    }
}
