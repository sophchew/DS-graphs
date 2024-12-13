public class Main {
    /*
            Terms to remember:
            A vertex represents the entity within a graph (such as a location)
            An edge represents the relationship between entities
     */
    public static void main(String[] args) {
        MyMaps mapMatrix = new MyMaps(MyMaps.AdjacencyType.MATRIX, false);
        MyMaps mapList = new MyMaps(MyMaps.AdjacencyType.LIST, true);

        mapMatrix.printLocations();
        mapList.printLocations();


      /*
           I know coming back from break is rough, here are some incredible jokes just for you guys.
           (These WERE the best ones I could find)

           Why did the private classes break up?
           Because they never saw each other.

           What did the array say to the linked list?
           "At least I know my limits!"

            What's a stack's favorite exercise?
            Push-ups.

            What's a priority queue's favorite movie?
            The First Element.

            What did the doubly-linked list say to its therapist?
            I have trouble moving forward because I'm always looking back.
       */
    }
}