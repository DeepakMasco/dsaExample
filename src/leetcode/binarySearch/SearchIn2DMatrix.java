package leetcode.binarySearch;
/*Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.



Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/
public class SearchIn2DMatrix {

    public static void main(String[] args) {
        boolean result = searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 60);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int i = matrix.length;
        int j = matrix[0].length;
        int a = 0;
        int b = j-1;
        while(a>=0 && b>=0 && a<i && b<j) {
            if(matrix[a][b]==target) {
                return true;
            } else if(matrix[a][b] > target) {
                b--;
            } else if(matrix[a][b] < target) {
                a++;
            }
        }

        return res;
    }
}
