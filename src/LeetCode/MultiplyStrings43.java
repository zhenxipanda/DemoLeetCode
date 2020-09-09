package LeetCode;

/**
 * LeetCode 43
 * 题意：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 思路：两层循环，从后向前遍历，用数组存结果，
 *      因为可能数组的此位置已有数值，所以要 加上再处理
 *      96.23% ，66.21%
 */
public class MultiplyStrings43 {
    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "456";
        String res = multiply(nums1 , nums2);
        System.out.println(res);
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for(int i = m - 1;i >= 0;i --){
            int a = num1.charAt(i) - '0';
            for(int j = n - 1;j >= 0; j --){
                int b = num2.charAt(j) - '0';
                int sum = arr[i + j + 1] + a * b;   // 先加上这个位置的数值
                arr[i + j + 1] = sum % 10;
                arr[i + j] +=  sum / 10;    // 这里是 += ，不是 =
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < m + n; i ++){
            if(i == 0 && arr[i] == 0){   // 最多只有第一位是0
                continue;
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
