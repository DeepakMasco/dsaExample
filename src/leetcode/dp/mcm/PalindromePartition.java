package leetcode.dp.mcm;
/*Given a string str, a partitioning of the string is a palindrome partitioning if
every sub-string of the partition is a palindrome.
 Determine the fewest cuts needed for palindrome partitioning of the given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings
are "a", "babbbab", "b", "ababa".

Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".


*/
public class PalindromePartition {

    public static void main(String[] args) {
        // As we are just accessing current element the i can start from 0 and j will start from len - 1
        System.out.println(solve("aab",0,3-1));
    }

    private static int solve(String input, int i, int j)
    {
        //if the string is empty or it has only one char(i==j) then also we dont need to divide.
        //As single char is already a palindrome.
        //And if the given string is already palindrome we need 0 partition
        if(i>=j || isPalindrome(input, i , j))  {
            System.out.println(input.substring(i,j+1));
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            // For every operation we add the cost which is 1 in this case and we call the subtrees to get the ans.
            int temp = 1 + solve(input,i,k) + solve(input,k+1,j);
            min = Math.min(min, temp);
        }
        return min;
    }

    private static boolean isPalindrome(String input, int i, int j) {
        while(i<j) {
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
