package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 207
 * 题意：
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 提示：
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * 思路：时隔七个月再刷，确实没什么印象了，
 *      需要注意的点：
 *      1. 如果二维数组为空等的判断，需要return true ,not false,这时候理解为没有先修课程
 *      2. 遍历edges，需要每数组中每个元素初始化，否则报空指针异常
 *      99.18% , 90.00%
 */
public class CourseSchedule207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        boolean res = canFinish(numCourses , prerequisites);
        System.out.println(res);
    }
    private static int[] visited;
    private static List[] edges;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return false ;
        }
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
            return true;
        }
        visited = new int[numCourses];
        edges = new List[numCourses];
        for(int i = 0;i < numCourses; i ++){
            edges[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites){
            edges[pre[1]].add(pre[0]);
        }
        for(int i = 0;i < numCourses; i ++){
            if(!dfs(i)){
                return false;
            }
        }
        return true ;
    }
    public static boolean dfs(int index){
        if(visited[index] == 1){
            return true ;
        }
        else if(visited[index] == -1){
            return false;
        }
        visited[index] = -1;
        List<Integer> list = edges[index];
        for(int li : list){
            if(!dfs(li)){
                return false;
            }
        }
        visited[index] = 1;
        return true;
    }
}
