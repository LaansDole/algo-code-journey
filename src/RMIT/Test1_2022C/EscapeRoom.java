package RMIT.Test1_2022C;

import java.io.PrintWriter;
import java.util.List;
import java.util.Stack;

//Problem 1
public class EscapeRoom {
    Stack<String> enteredRooms = new Stack<>();
    public EscapeRoom() {}
    public void enterRoom(String room) {
        enteredRooms.add(room);
    }
    public String exitRoom() {
        return enteredRooms.pop();
    }
    public int minOperations(String[] target, String[] enterRooms) {
        enteredRooms.addAll(List.of(enterRooms));
        PrintWriter out = new PrintWriter(System.out);
        int minEnterAndExit = 0;
        if(target == enterRooms) {
            out.println("You have reached the winning order");
        } else {
            int correctRooms = 0;
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
}
