package LeetCode;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        print(nums);
    }
    public static void print(int[][] nums){
        if(nums == null || nums.length == 0 || nums[0].length == 0){
            return ;
        }
        int up = 0 , down = nums.length - 1;
        int left = 0 , right = nums[0].length - 1;
        int k = 0 , sum = (down + 1) * (right + 1);
        while(k < sum){
            for(int i = left ; i <= right ; i ++){
                System.out.print(nums[up][i] + ", ");
                k ++;
            }
            for(int j = up + 1 ; j <= down; j ++){
                System.out.print(nums[j][right] + ", ");
                k ++;
            }
            if(up < down){
                for(int i = right - 1; i >= left ; i --){
                    System.out.print(nums[down][i] + ", ");
                    k ++;
                }
                if(left < right){
                    for(int j = down - 1; j > up ; j --){
                        System.out.print(nums[j][left] + ", ");
                        k ++;
                    }
                }

            }
            up ++;
            down --;
            left ++ ;
            right --;
//            竟然智障把k++ 写到了这里！！
        }
    }
}
