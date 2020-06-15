package LeetCode;

/**
 * LeetCode 165
 * 题意：比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
 * 版本字符串不以点开始或结束，并且其中不会有两个连续的点。
 * 思路：1. 对两个字符串进行以.的分割，.split("\\.")
 *      2. 遍历两个数组，循环的条件是只要有一方没达到数组尾就行
 *      3. 对于已经到达数组尾部的，利用三目运算符判断，补"0"
 *      4. 然后调用res = compare(s1,s2)比较两个字符串，
 *      5. 如果res == 0,i ++, j++
 *      6. 否则，return res，结果出来了
 *      96.42% , 20.00%
 */
public class CompareVersionNumbers165 {
    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1.0.1.2";
        int res = compareVersion(version1 , version2);
        System.out.println(res);
    }
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < s1.length || j < s2.length){
            String n1 = i < s1.length ? s1[i] : "0";
            String n2 = j < s2.length ? s2[j] : "0";
            int res = compare(n1 , n2);
            if(res == 0){
                i ++;
                j ++;
            }
            else{
                return res;
            }
        }
        return 0;
    }
    public static int compare(String s1 , String s2){
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        if(n1 == n2){
            return 0;
        }
        else if(n1 > n2){
            return 1;
        }
        else{
            return -1;
        }
    }
}
