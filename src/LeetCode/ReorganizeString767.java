package LeetCode;

import java.util.PriorityQueue;

/**
 * LeetCode 767
 * 题意：
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 思路：比较难想，统计字母出现的次数，如果大于(n+1)/2，说明不存在，返回""
 *      定义类Multi,(count.letter)表示统计次数为count 的 字母 letter,
 *      定义最大堆，按照count降序，相同的count，按照letter升序，
 *      只要堆中有大于等于2个元素，弹出，加入到StringBuffer中，
 *      --次数大于0，继续加入堆中，如果堆中元素为1个，单独加入到堆中
 *      52.00% , 50.25%
 */
public class ReorganizeString767 {
    public static void main(String[] args) {
        String s = "aaabb";
        String res = reorganizeString(s);
        System.out.println(res);
    }

    public static String reorganizeString(String S) {
        int n = S.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[S.charAt(i) - 'a']++;
        }
        PriorityQueue<Multi> maxHeap = new PriorityQueue<Multi>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > (n + 1) / 2) {
                    return "";
                }
                maxHeap.add(new Multi(count[i], (char) ('a' + i)));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (maxHeap.size() >= 2) {
            Multi m1 = maxHeap.poll();
            Multi m2 = maxHeap.poll();
            sb.append(m1.letter);
            sb.append(m2.letter);
            if (--m1.count > 0) {
                maxHeap.add(m1);
            }
            if (--m2.count > 0) {
                maxHeap.add(m2);
            }
        }
        if (maxHeap.size() > 0) {
            sb.append(maxHeap.poll().letter);
        }
        return sb.toString();
    }
}
    class Multi {
        int count;
        char letter;

        public Multi(int count, char letter) {
            this.count = count;
            this.letter = letter;
        }
    }

