package LeetCode;

public class NimGame292 {
    public static void main(String[] args) {
        int n = 8;
        boolean ans = canWinNim(n);
        System.out.println(ans);
    }
    public static boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
