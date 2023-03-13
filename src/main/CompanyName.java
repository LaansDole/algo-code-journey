/*
You are given an array of strings ideas that represents a list of names to be used in the process of naming a company. The process of naming a company is as follows:

Choose 2 distinct names from ideas, call them ideaA and ideaB.
Swap the first letters of ideaA and ideaB with each other.
If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
Otherwise, it is not a valid name.
Return the number of distinct valid names for the company.
*/
package main;

import java.util.*;

public class CompanyName {
    public CompanyName() {}
    public static boolean validateNames(HashSet<String> set, String name1, String name2) {
        // if the two names have the same first character
        if(name1.charAt(0) == name2.charAt(0)) {
            return false;
        }
        // if the two names have the same index [1..*] character
        if(name1.substring(1).equals(name2.substring(1))) {
            return false;
        }
        String idea1 = name1.charAt(0) + name2.substring(1);
        String idea2 = name2.charAt(0) + name1.substring(1);
        return !(set.contains(idea1) || set.contains(idea2));
    }

    public static long distinctNames(String[] ideas) {
        int distinctName = 0;
        HashSet<String> ideasSet = new HashSet<>(Arrays.asList(ideas));
//        List<String> ideasArray = new ArrayList<>(Arrays.asList(ideas));
//        List<String> ideasLinked = new LinkedList<>(Arrays.asList(ideas));
//        for (String name1 : ideasArray) {
//            ideasLinked.remove(0);
//            for (String name2 : ideasLinked) {
//                if(validateNames(ideasSet, name1, name2)) {
//                    distinctName+=2;
//                }
//            }
//        }
        for(int name1=0; name1<ideas.length; name1++) {
            for(int name2=name1+1; name2<ideas.length; name2++) {
                if(validateNames(ideasSet, ideas[name1], ideas[name2])) {
                    distinctName+=2;
                }
            }
        }
        return distinctName;
    }
}
// 74/89 test cases passed
