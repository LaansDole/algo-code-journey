package RMIT.Test1_2022C;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Problem 1
public class EscapeRoom {
    Stack<String> enteredRooms;
    private final String[] targetRooms;
    public EscapeRoom() {
        enteredRooms = new Stack<>();
        targetRooms = new String[]{"A", "B", "C"};
    }
    //enterRoom complexity = O(1)
    public void enterRoom(String room) {
        enteredRooms.add(room);
    }
    //exitRoom complexity = O(1)
    public String exitRoom() {
        return enteredRooms.pop();
    }
    //minOperations complexity = O(n)
    public int minOperations() {
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
    public int minOperations(String[] enterRooms, String[] target) {
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
    private int roomInCorrectOrder(String[] bigRooms, String[] smallRooms) {
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
    private String[] toStringEnteredRoom() {
        Object[] enterRooms;
        enterRooms = enteredRooms.toArray();
        return Arrays.copyOf(enterRooms, enterRooms.length, String[].class);
    }
    //inspectEnteredRoom complexity = O(n)
    private void inspectEnteredRoom() {
        System.out.print("Room has entered: \n");
        for(String room : enteredRooms) {
            System.out.print(room+ " ");
        }
    }
    public static void main(String[] args) {
        EscapeRoom player = new EscapeRoom();
        int operations;

        player.enterRoom("A");
        player.enterRoom("B");
        player.enterRoom("D");
        player.inspectEnteredRoom();
        operations = player.minOperations();
        System.out.println("The number of operations needed to escape: "+operations);

        String roomJustExit;
        roomJustExit = player.exitRoom();
        System.out.println("Exit room: "+ roomJustExit);

        player.inspectEnteredRoom();

        operations = player.minOperations();
        System.out.println("The number of operations needed to escape: "+operations);
    }
}
