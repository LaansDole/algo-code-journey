package main;

import org.jetbrains.annotations.NotNull;

class Zigzag {
    public static char[][] toZigZag(char[][] zigzag, @NotNull String s, int numRows, int numCols) {
        String tempStr = s;
        for(int i=0; i<numRows; i++) {
            if(tempStr.length() == 0) {
                return zigzag;
            }
            zigzag[i][numCols] = s.charAt(i);
            tempStr = tempStr.substring(1); //remove the first character of the string every loops
        }
        for(int j=numRows-2; j>0; j--) {
            if(tempStr.length() == 0) {
                return zigzag;
            }
            numCols++;
            zigzag[j][numCols] = tempStr.charAt(0);
            tempStr = tempStr.substring(1);
        }
        numCols++;
        return toZigZag(zigzag, tempStr, numRows, numCols);
    }
    public String convert(String s, int numRows) {
        char[][] zigzag = new char[numRows][s.length()]; //array_name[row_index][column_index]
        zigzag = toZigZag(zigzag, s, numRows, 0);
        String result = "";
        for(int m=0; m<numRows; m++) {
            for(char c : zigzag[m]) {
                if(c!='\u0000') {
                    result+=c;
                }
            }
        }
//        result=result.replace("\\u0000", "");
        return result;
    }
}