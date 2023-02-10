package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class LandDistance {
    public int maxDistance(int[][] grid) {
        int width = grid.length;
        Queue<int[]> landQueue = new LinkedList<>();
        Queue<int[]> seaQueue = new LinkedList<>();
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
        while (itr.hasNext()) {
            // land[0] is row position, land[1] is column position
            land = landQueue.poll(); // for example, land at (1,1)
//            int adjacent1 = grid[land[0]-1][land[1]]; // (0,1)
//            int adjacent2 = grid[land[0]][land[1]-1]; // (1,0)
//            int adjacent3 = grid[land[0]+1][land[1]]; // (2,1)
//            int adjacent4 = grid[land[0]][land[1]+1]; // (1,2)

            // update the iterator for the queue
            itr = landQueue.iterator();
        }
        return 1;
    }
}
