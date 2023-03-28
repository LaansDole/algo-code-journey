package RMIT.Test1_2022C;

import RMIT.Week3.Stack.LinkedListStack;
import RMIT.Week3.Node;

//Problem 1: Implementing Last In First Out for rooms that the player enter
public class EscapeRoom {
    static LinkedListStack<String> enteredRooms;
    public EscapeRoom() {
        enteredRooms = new LinkedListStack<>();
    }

    //enterRoom complexity = O(1)
    public void enterRoom(String room) {
        enteredRooms.push(room);
    }

    //exitRoom complexity = O(1)
    public String exitRoom() {
        if(!enteredRooms.isEmpty()) {
            String roomExit = enteredRooms.peek().getData();
            enteredRooms.pop();
            return roomExit;
        }
        return null;
    }

    public int minOperations(String[] target, String[] enterRooms) {
        if(enterRooms != null) {
            new EscapeRoom();
            for(String room : enterRooms) {
                enteredRooms.push(room);
            }
        } else {
            enterRooms = new String[enteredRooms.size()];
            int i = 0;
            Node<String> currentNode = enteredRooms.peek();
            while(!enteredRooms.isEmpty()) {
                enterRooms[i] = currentNode.getData();
                if(currentNode.hasNext()) {
                    currentNode = currentNode.next;
                    i++;
                } else {
                    break;
                }
            }
        }

        int minEnterAndExit = 0;
        if(target==null) {
            target = new String[0];
        }
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

    private int getSize() {
        return enteredRooms.size();
    }
    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom();
        int operations;

        escapeRoom.enterRoom("A");
        escapeRoom.enterRoom("B");
        escapeRoom.enterRoom("D");

        System.out.println("Number of rooms: "+escapeRoom.getSize());

        operations = escapeRoom.minOperations(null, null);
        System.out.println("\nThe number of operations needed to escape: "+operations);

        System.out.println("Room just exit: "+escapeRoom.exitRoom());

        operations = escapeRoom.minOperations(null, null);
        System.out.println("\nThe number of operations needed to escape: "+operations);
    }
}
