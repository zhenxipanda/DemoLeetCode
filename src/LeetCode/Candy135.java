package LeetCode;

/**
 * LeetCode 135
 * 题意：老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，
 * 老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 思路：统计紧邻下降的区间长度，利用等差数列的和，算出下降区间的糖果数，
 *      加入到res之后，统计位复原，
 *      99.84% , 19.28%
 */
public class Candy135 {
    public static void main(String[] args) {
        int[] ratings = {1,2,2,1,1};
        int res = candy(ratings);
        System.out.println(res);
    }
    public static int candy(int[] ratings){
        int pre = 1 , res = 1 , des = 0;
        for(int i = 1; i < ratings.length ; i ++){
            if(ratings[i] >= ratings[i - 1]){
                if(des > 0){
                    res += (1 + des) * des / 2;
                    if(des >= pre){
                        res += (des - pre + 1);
                    }
                    pre = 1;    // 重新标记
                    des = 0;
                }
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
            }
            else{              // 统计下降的区间长度
                des ++;
            }
        }
        if(des > 0){
            res += (1 + des) * des / 2;
            if(des >= pre){
                res += (des - pre + 1);
            }
        }
        return res;
    }
}
