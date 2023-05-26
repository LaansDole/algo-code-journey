package main;

public class s3963207Problem3 {
    public static void main(String[] args) {
        String initState = "AAAA";
        AnRMITLock rmitLock = new AnRMITLock(initState);

        System.out.println(rmitLock.minStep());
        System.out.println(new AnRMITLock("RMIV").minStep());
        System.out.println(new AnRMITLock("RMIV").freeTransform());

    }

    public static class AnRMITLock {
        String initState;
        private final String KEY = "RMIT";
        private int[] keyHash = new int[4];
        private final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public AnRMITLock(String initState) {
            this.initState = initState;
            initKeyHash();
        }

        private String getCharacter(int pos) {
            return String.valueOf(ALPHA.charAt(pos));
        }

        private int hashCharacter(char c) {
            return ALPHA.indexOf(c);
        }

        // Initialize a matrix of all lock states
        private int[][] initAllPossibleState() {
            int[][] states = new int[4][26];
            char[] alphabets = ALPHA.toCharArray();

            for(int i = 0; i < 4; i++) {
                for(char c: alphabets) {
                    states[i][hashCharacter(c)] = hashCharacter(c);
                }
            }
            return states;
        }

        private void initKeyHash() {
            for(int i = 0; i < 4; i++) {
                keyHash[i] = hashCharacter(KEY.charAt(i));
            }
        }

        private int[] initLockHash() {
            int[] lockHash = new int[4];
            for(int i = 0; i < 4; i++) {
                lockHash[i] = hashCharacter(initState.charAt(i));
            }

            return lockHash;
        }


        // Complexity: O(N*L)
        public int minStep() {
            int steps = 0;

            for(int i = 0; i < 4; i++) {
                if(initState.charAt(i) != KEY.charAt(i)) {
                    int currentHash = hashCharacter(initState.charAt(i));
                    int distance = Math.abs(currentHash - keyHash[i]);

                    if(distance < 14) {
                        steps += distance;
                    } else {
                        steps += (ALPHA.length() - distance);
                    }
                }
            }

            return steps;
        }

        public String freeTransform() {
            String transform = initState;
            String previousState = initState;
            int[] initStateHash = initLockHash();
            int[][] states = initAllPossibleState();

            for(int i = 0; i < 4; i++) {
                if(initState.charAt(i) != KEY.charAt(i)) {
                    int currentHash = hashCharacter(initState.charAt(i));
                    int distance = Math.abs(currentHash - keyHash[i]);

                    if(distance < 14) {

                        // Loop forward
                        for(int j = 0; j < distance; j++) {
                            states[i][initStateHash[i]] = states[i][initStateHash[i] + j];

                            String currentState = ((
                                    getCharacter(states[0][initStateHash[0]])+
                                            getCharacter(states[1][initStateHash[1]])+
                                            getCharacter(states[2][initStateHash[2]])+
                                            getCharacter(states[3][initStateHash[3]])
                            ));
                            transform += " -> " + currentState;

                        }

                    } else {

                        // Loop backward
                        for(int j = 0; j < (ALPHA.length() - distance); j++) {
                            states[i][initStateHash[i]] = states[i][initStateHash[i] - j];

                            String currentState = ((
                                    getCharacter(states[0][initStateHash[0]])+
                                            getCharacter(states[1][initStateHash[1]])+
                                            getCharacter(states[2][initStateHash[2]])+
                                            getCharacter(states[3][initStateHash[3]])
                            ));
                            transform += " -> " + currentState;
                        }
                    }

                }
            }

            return transform;
        }
    }
}
