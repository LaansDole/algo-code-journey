package main;

public class s3963207Problem2 {
    public static void main(String[] args) {
        int[][] cost = new int[][]{
           //     0  1   2   3
                {-1, 3, 10, 15}, // 0
                {5, -1, 8, 5}, // 1
                {6, 4, -1, 2}, // 2
                {7, 3, 1, -1} // 3
        };
        AnAlgoTravel algoTravel = new AnAlgoTravel(cost);
        System.out.println(algoTravel.cheapestCity());
        for(int query: algoTravel.costQueries(new int[]{1,2})) {
            System.out.println(query);
        }
    }

    public static class AnAlgoTravel {
        int[][] costs;
        int M; // Money amount
        private int cityNum;
        public AnAlgoTravel(int[][] costs) {
            this.costs = costs;
            cityNum = costs.length;
        }

        // Complexity: O(N*N) where N is the number of cities
        public int cheapestCity() {
            int[][] distance = costs;
            for(int i = 0; i < cityNum; i++) {
                for(int j = 0; j < cityNum; j++) {
                    if(distance[i][j] == -1) {
                        distance[i][j] = 0;
                    }
                }
            }

            int minCost = Integer.MAX_VALUE;
            int cheapestCity = 1;
            for(int i = 1; i < cityNum; i++) {
                int costToCity = FirstCityToLastCity.shortestPath(distance, 0, i);
                if(minCost > costToCity) {
                    minCost = costToCity;
                    cheapestCity = i;
                }
            }
            return cheapestCity;
        }

        // return the most optimal cost
        // from 0 -> 2 (optimal is 0 -> 1 -> 3 -> 2: cost[0][1] + [1][3] + [3][2] = 3 + 5 + 1 = 9)
        // Complexity: O(N*N) where N is the number of cities

        public int[] costQueries(int[] targetCities) {
            int[][] distance = costs;
            for(int i = 0; i < cityNum; i++) {
                for(int j = 0; j < cityNum; j++) {
                    if(distance[i][j] == -1) {
                       distance[i][j] = 0;
                    }
                }
            }

            int[] queries = new int[targetCities.length];
            for(int i = 0; i < targetCities.length; i++) {
                queries[i] = FirstCityToLastCity.shortestPath(distance, 0, targetCities[i]);
            }
            return queries;
        }

        static class FirstCityToLastCity {
            static int shortestPath(int[][] nodes, int src, int dest) {
                int n = nodes.length;

                int[] distances = new int[n];  // distance[i] stores the minimum distance from src to i
                boolean[] visited = new boolean[n];  // visited state
                int[] previous = new int[n];  // used to construct the shortest path; previous[i] stores the node that is visited before i

                // initialization
                for (int i = 0; i < n; i++) {
                    distances[i] = Integer.MAX_VALUE;
                    previous[i] = -1;
                }
                distances[src] = 0;  // zero distance from the src to itself

                while (true) {
                    // Greedy choice: retrieve the shortest-distance node from
                    // unvisited nodes
                    int shortest = Integer.MAX_VALUE;
                    int shortestNode = -1;
                    for (int i = 0; i < n; i++) {
                        if (visited[i]) {
                            continue;
                        }
                        if (shortest > distances[i]) {
                            shortest = distances[i];
                            shortestNode = i;
                        }
                    }

                    // update the shortest distance through shortest node
                    // to all unvisited nodes
                    for (int i = 0; i < n; i++) {
                        if (visited[i]) {
                            continue;
                        }
                        // shortestNode and i are connected?
                        if (nodes[shortestNode][i] > 0) {
                            // current distance to i > distance reached through shortestNode
                            if (distances[i] > distances[shortestNode] + nodes[shortestNode][i]) {
                                distances[i] = distances[shortestNode] + nodes[shortestNode][i];
                                previous[i] = shortestNode;
                            }
                        }
                    }

                    if (shortestNode == dest) {
                        // we reach the destination
                        // display the shortest path
                        String path = shortestNode + "";
                        while (previous[shortestNode] != -1) {
                            shortestNode = previous[shortestNode];
                            path = shortestNode + " -> " + path;
                        }

                        System.out.println("Shortest path: " + path);
                        return distances[dest];
                    }

                    // even shortest is INFINITY => stop
                    if (shortest == Integer.MAX_VALUE) {
                        // we cannot go further
                        return Integer.MAX_VALUE;
                    }
                    // continue the next round
                    visited[shortestNode] = true;
                }
            }
        }
//        public int maxVisted() {
//
//        }
    }
}
