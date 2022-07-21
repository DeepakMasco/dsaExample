package leetcode.Random;


import java.util.HashMap;

/*Convert Given Roman numeral to integer

I -> 1
V -> 5
X ->10
L -> 50
C ->100
D-> 500
M-> 1000

Example:

MCMIV -> 1904,  XXVII -> 27*/
public class RomanToInteger {

    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();

        String s = "XXVII";
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int nextIndex = i+1;
            if(nextIndex<s.length() && map.get(s.charAt(nextIndex)) > map.get(s.charAt(i))) {
                sum+= map.get(s.charAt(nextIndex)) - map.get(s.charAt(i));
                i++;
            } else {
                sum+= map.get(s.charAt(i));
            }
        }
        System.out.println(sum);

    }
}
