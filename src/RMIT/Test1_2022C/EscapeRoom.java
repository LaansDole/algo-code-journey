package RMIT.Test1_2022C;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Problem 1
public class EscapeRoom {
    static Stack<String> enteredRooms;
    private static String[] targetRooms;
    public EscapeRoom() {
        enteredRooms = new Stack<>();
        targetRooms = new String[]{"A", "B", "C"};
    }
    //enterRoom complexity = O(1)
    public static void enterRoom(String room) {
        enteredRooms.add(room);
    }
    //exitRoom complexity = O(1)
    public static String exitRoom() {
        return enteredRooms.pop();
    }
    //minOperations complexity = O(n)
    public static int minOperations() {
        String[] enterRooms = toStringEnteredRoom();
        int minEnterAndExit = 0;
        if(targetRooms != enterRooms) {
            int correctRooms;
            // Loop through the smaller array to avoid throwing null exception
            if(targetRooms.length > enterRooms.length) {
                correctRooms = roomInCorrectOrder(targetRooms, enterRooms);
            } else {
                correctRooms = roomInCorrectOrder(enterRooms, targetRooms);
            }
            int roomsToExit = enterRooms.length - correctRooms;
            int roomsToEnter = targetRooms.length - correctRooms;
            minEnterAndExit = roomsToExit + roomsToEnter;
        }
        return minEnterAndExit;
    }
    //for JUnit Testing the minOperations operation
    public static int minOperations(String[] enterRooms, String[] target) {
        enteredRooms.addAll(List.of(enterRooms));
        int minEnterAndExit = 0;
        if(target != enterRooms) {
            int correctRooms;
            // Loop through the smaller array to avoid throwing null exception
            if(target.length > enterRooms.length) {
                correctRooms = roomInCorrectOrder(target, enterRooms);
            } else {
                correctRooms = roomInCorrectOrder(enterRooms, target);
            }
            int roomsToExit = enterRooms.length - correctRooms;
            int roomsToEnter = target.length - correctRooms;
            minEnterAndExit = roomsToExit + roomsToEnter;
        }
        return minEnterAndExit;
    }
    //roomInCorrectOrder complexity = O(n)
    public static int roomInCorrectOrder(String[] bigRooms, String[] smallRooms) {
        int countCorrectRooms = 0;
        for(int i = 0; i < smallRooms.length; i++) {
            if(bigRooms[i].equals(smallRooms[i])) {
                countCorrectRooms++;
            } else {
                break;
            }
        }
        return countCorrectRooms;
    }
    //toStringEnteredRoom complexity = O(n)
    public static String[] toStringEnteredRoom() {
        Object[] enterRooms;
        enterRooms = enteredRooms.toArray();
        return Arrays.copyOf(enterRooms, enterRooms.length, String[].class);
    }
    //inspectEnteredRoom complexity = O(n)
    public static void inspectEnteredRoom() {
        System.out.print("Room has entered: \n");
        for(String room : enteredRooms) {
            System.out.print(room+ " ");
        }
    }
    public static void main(String[] args) {
        new EscapeRoom();
        int operations;

        enterRoom("A");
        enterRoom("B");
        enterRoom("D");
        inspectEnteredRoom();
        operations = minOperations();
        System.out.println("\nThe number of operations needed to escape: "+operations);

        String roomJustExit;
        roomJustExit = exitRoom();
        System.out.println("Exit room: "+ roomJustExit);

        inspectEnteredRoom();

        operations = minOperations();
        System.out.println("\nThe number of operations needed to escape: "+operations);
    }
}
