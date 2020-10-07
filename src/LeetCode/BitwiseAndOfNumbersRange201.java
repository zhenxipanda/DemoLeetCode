package LeetCode;

public class BitwiseAndOfNumbersRange201 {
    public static void main(String[] args) {

    }
    public static int rangeBitwiseAnd(int m, int n){
        while (m < n){
            n = n & (n - 1);
        }
        return n;
    }
}
