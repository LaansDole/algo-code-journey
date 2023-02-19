package main;

import java.util.*;

public class LandDistance {
    public int maxDistance(int[][] grid) {
        int width = grid.length;
        Queue<int[]> landQueue = new LinkedList<>();
        ArrayList<int[]> seaQueue = new ArrayList<>();
        for (int i = 0; i < width * width; i++) {
            int row = i / width; // determines row
            int column = i % width; // determines column
            if (grid[row][column] == 1) {
                landQueue.add(new int[]{row, column});
            } else if (grid[row][column] == 0) {
                seaQueue.add(new int[]{row, column});
            }
            // testing output
//            System.out.println("Value[" + grid[row][column] + "] Row[" + row + "] Column[" + column + "]");
        }
        if (landQueue.isEmpty() || seaQueue.isEmpty()) {
            return -1;
        }
        Iterator itr = landQueue.iterator();
        int[] land;
        int distance = 0;
        java.util.function.BiFunction<Integer, Integer, Boolean> checkAdjacent = (rowIndex, colIndex) -> {
            if(grid[rowIndex][colIndex] == 0) {
                grid[rowIndex][colIndex] = 1;
                // TODO: remove the object from the seaArray
                return true;
            }
            return false;
        };
        int rotation = landQueue.size(); // a rotation is the size of the queue for each generation
        int count = -1; // count the number of "visited" lands have been removed/polled
        while (itr.hasNext()) {
            count++;
            // land[0] is row position, land[1] is column position
            land = landQueue.poll(); // remove and return the first element of the queue
            int row = land[0];
            int col = land[1];
            assert land != null; // testing
            // System.out.println("Value[" + land + "] Row[" + row + "] Column[" + col + "]"); // testing
            // adjacent 1
            if (row - 1 >= 0) { // top row NOT OutOfBounds
                if (checkAdjacent.apply(row - 1, col)) { // adjacent, (0,1)
                    landQueue.add(new int[]{row - 1, col});
                }
            }
            // adjacent 2
            if (col - 1 >= 0) { // left column NOT OutOfBounds
                if (checkAdjacent.apply(row, col - 1)) { // adjacent, (1,0)
                    landQueue.add(new int[]{row, col - 1});
                }
            }
            // adjacent 3
            if (row + 1 < width) { // bottom row NOT OutOfBounds
                if (checkAdjacent.apply(row + 1, col)) { // adjacent, (2,1)
                    landQueue.add(new int[]{row+1, col});
                }
            }
            // adjacent 4
            if (col + 1 < width) { // right column NOT OutOfBounds
                if (checkAdjacent.apply(row, col + 1)) { // adjacent, (1,2)
                    landQueue.add(new int[]{row, col + 1});
                }
            }
            // update the iterator for the queue
            itr = landQueue.iterator();
            if (count==rotation) { // everytime the queue completes its generation
                distance++;
                count = 0;
                rotation = landQueue.size();
            }
            // TODO: return distance if the seaArray is empty
        }
        System.out.println("Sea Queue Length: "+seaQueue.size());
        return distance;
    }
}
