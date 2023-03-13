package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class LandDistance {
    LandDistance() {}
    public static int maxDistance(int[][] grid) {
        int width = grid.length;
        Queue<int[]> landQueue = new LinkedList<>();
        for (int i = 0; i < width * width; i++) {
            int row = i / width; // determines row
            int column = i % width; // determines column
            if (grid[row][column] == 1) {
                landQueue.add(new int[]{row, column});
            }
            // testing output
        }
        if (landQueue.isEmpty() || landQueue.size() == width * width) {
            return -1;
        }
        Iterator itr = landQueue.iterator();
        int[] land;
        int distance = -1;
        java.util.function.BiFunction<Integer, Integer, Boolean> checkAdjacent = (rowIndex, colIndex) -> {
            if(grid[rowIndex][colIndex] == 0) {
                grid[rowIndex][colIndex] = 1;
                return true;
            }
            return false;
        };
        int rotation = landQueue.size();
        int count =0;
        while (itr.hasNext()) {
            // land[0] is row position, land[1] is column position
            land = landQueue.poll(); // remove and return the first element of the queue
            int row = land[0];
            int col = land[1];
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
            if (col + 1 < width) { // right column NOT OutOfBounds
                if (checkAdjacent.apply(row, col + 1)) { // adjacent, (1,2)
                    landQueue.add(new int[]{row, col + 1});
                }
            }
            // update the iterator for the queue
            itr = landQueue.iterator();
            count++;
            if (count==rotation) { // everytime the queue completes its generation
                distance++;
                count = 0;
                rotation = landQueue.size();
            }
        }
        return distance;
    }
}