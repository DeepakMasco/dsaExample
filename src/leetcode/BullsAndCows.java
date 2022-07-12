package leetcode;

import java.util.HashMap;
import java.util.Map;

/*You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.

Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.



Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"




In this we can use hashMap tp store the frequenct of elements.
And then we can iterate and see in 2 loops.
First we will count the matching characters in a loop and whateber is not matching in secret key we will add them in map
then we can do another loop and check what all characters are not matching and then check if it is present in map
if yes we will add cows count and then decrease freq in the map.


*/
public class BullsAndCows {

    public static void main(String[] args) {
        System.out.println(getHint("1048","1840"));
    }


    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int n = secret.length();

        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1==c2) {
                bulls++;
            } else {
                freq.put(c1,freq.getOrDefault(c1,0)+1);
            }
        }


        for(int i=0;i<n;i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1!=c2) {
                if(freq.containsKey(c2)) {
                    cows++;
                    int val = freq.get(c2);
                    if(val==1) {
                        freq.remove(c2);
                    } else {
                        freq.put(c2,val-1);
                    }
                }
            }


        }
        return bulls+"Bulls"+cows+"Cows";
    }
}
