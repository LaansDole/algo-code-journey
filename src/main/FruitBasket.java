package main;

public class FruitBasket {
    public FruitBasket() {}
    public static int totalFruit(int[] fruits) {
        int firstBasket;
        int secondBasket = 0;
        int position = 1;
        int collected = 1;
        int fruits_count;
        while(position<fruits.length) {
            firstBasket = fruits[position-1];
            fruits_count = 1;
            for (int i = position; i < fruits.length; i++) { // Get the basket 2 type
                if (fruits[i] == firstBasket) {
                    position++;
                    fruits_count++;
                    continue;
                }
                secondBasket = fruits[i];
                position++;
                fruits_count++;
                break;
            }
            if(position==fruits.length) { // return the fruit collected if it's already the end of the array
                return Math.max(collected, fruits_count);
            }
            int streak1 = 0;
            int streak2 = 0;
            for (int j = position; j < fruits.length; j++) { // collecting the fruit from the two basket type
                if(fruits[j] == firstBasket) { // if the current fruit has same type with basket 1
                    position++;
                    fruits_count++;
                    if(position>=fruits.length) { // return the fruit collected if it's already the end of the array
                        return Math.max(collected, fruits_count);
                    }
                    streak1++; // return the number of basket 1 type streak;
                    streak2 = 0; // set basket 2 streak to 0
                    continue;
                } else if (fruits[j] == secondBasket) { // if the current fruit has same type with basket 2
                    position++;
                    fruits_count++;
                    if(position>=fruits.length) {
                        return Math.max(collected, fruits_count);
                    }
                    streak2++; // return the number of basket 2 type streak;
                    streak1 = 0; // set basket 1 streak to 0
                    continue;
                }
                collected = Math.max(collected, fruits_count);
                position-=Math.max(streak1, streak2); // set the position back to the initial break point
                break;
            }
        }
        return collected;
    }
}
