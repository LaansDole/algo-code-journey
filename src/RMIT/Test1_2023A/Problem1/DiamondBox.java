package RMIT.Test1_2023A.Problem1;

import RMIT.Week3.Stack.LinkedListStack;

public class DiamondBox {
    LinkedListStack<Character> diamondBox;
    String configuration;
    public DiamondBox(String configuration) {
        diamondBox = new LinkedListStack<>();
        this.configuration = configuration;
    }

    private boolean isBalanced() {
        diamondBox = new LinkedListStack<>();
        for (int i = 0; i < configuration.length(); i++) {
            char c = configuration.charAt(i);

            if(c == '*') {
                continue;
            }

            if (c == '[') {
                diamondBox.push(c);
                continue;
            }

            if (diamondBox.isEmpty()) {
                return false;
            }

            char c2 = diamondBox.peek().getData();
            diamondBox.pop();

            if (c == ']' && c2 != '['){
                return false;
            }
        }

        return diamondBox.isEmpty();
    }

    private boolean isDiamondInBox() {
        return (configuration.charAt(0) != '*'
                && configuration.charAt(configuration.length()-1) != '*');
    }

    private boolean haveOutermostBox() {
        int level = -1;

        for(int i = 0; i < configuration.length(); i++) {
            char c = configuration.charAt(i);

            if(c == '[') {
                level++;
                continue;
            }

            if(c == ']' && level == 0 && i != configuration.length()-1) {
                return false;
            }

            if(c == ']') {
                level--;
            }
        }
        return true;
    }

    // Time complexity: Linear O(N) with the N elements in the stack
    public boolean isValid() {
        return isDiamondInBox() && isBalanced() && haveOutermostBox();
    }

    private char[][] getBoxesMatrix() { // get a matrix of boxes based on different level
        int level = -1;
        char[][] boxMatrix = new char[deepestLevel()+1][configuration.length()+1];
        for (int i = 0; i < configuration.length(); i++) {
            char c = configuration.charAt(i);

            if(c == ']' && i != configuration.length()-1) {
                boxMatrix[level][i] = c;
                level--;
                continue;
            }

            if(c == '[') {
                level++;
            }

            boxMatrix[level][i] = c;
        }
        return boxMatrix;
    }

    // Time complexity: O(N) if the diamond box is valid
    public int deepestLevel() {
        if(!isValid()) {
            return 0;
        }

        int level = 0;
        int maxLevel = 0;

        for (int i = 0; i < configuration.length(); i++) {
            char c = configuration.charAt(i);

            if(c == '*') {
                continue;
            }

            if (c == '[') {
                level++;
                continue;
            }

            // if c is not [, reset level to 1
            maxLevel = Math.max(maxLevel,level);
            level = 1;
        }
        return maxLevel;
    }

    // Assumed that the configuration is correct, Time complexity: O(N^2)
    public int maxDiamonds() {
        if(!isValid()) {
            return 0;
        }

        int diamond = 0;
        int maxDiamond = 0;

        char[][] boxes = getBoxesMatrix();

        for (char[] box : boxes) {
            for (char insideBox : box) {
                if (insideBox == '\u0000') {
                    continue;
                }

                if (insideBox == '*') {
                    diamond++;
                    continue;
                }

                if (insideBox == ']') {
                    maxDiamond = Math.max(diamond , maxDiamond); // max diamonds on each boxes on the same level
                    diamond = 0; // reset the number of diamond
                }
            }
            maxDiamond = Math.max(diamond , maxDiamond); // max diamonds on each level
            diamond = 0;
        }

        return maxDiamond;
    }


    public static void main(String[] args) {
        DiamondBox diamondBox1 = new DiamondBox("[**[**]*]");
        System.out.println("Box1 is valid: "+diamondBox1.isValid());
        System.out.println("Box1 deepest level: "+diamondBox1.deepestLevel());
        System.out.println("Max diamonds in a box1: "+diamondBox1.maxDiamonds());

        System.out.println('\n');

        DiamondBox diamondBox2 = new DiamondBox("[**[**]]*");
        System.out.println("Box2 is valid: "+diamondBox2.isValid());
        System.out.println("Box2 deepest level: "+diamondBox2.deepestLevel());
        System.out.println("Max diamonds in a box2: "+diamondBox2.maxDiamonds());

        System.out.println('\n');

        DiamondBox diamondBox3 = new DiamondBox("[**[**]][]");
        System.out.println("Box3 is valid: "+diamondBox3.isValid());
        System.out.println("Box3 deepest level: "+diamondBox3.deepestLevel());
        System.out.println("Max diamonds in a box3: "+diamondBox3.maxDiamonds());
    }
}

