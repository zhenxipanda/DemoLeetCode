package LeetCode;

import java.util.*;

/**
 * LeetCode 218
 * 题意：
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
 * 现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，
 * 请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，
 * 其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。
 * 可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。
 * 您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，
 * 它们唯一地定义了天际线。关键点是水平线段的左端点。
 * 请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，
 * 并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 * 思路：比较难的一道题。
 *      首先定义Point点类，除了x坐标，高度，起始点还是终止点之外，还需要一个bi，记录这条线的编号，
 *      因为题目中已经说明了，给定的点的顺序都是按照x坐标升序的，也是就都是按照从左到右的顺序给出的
 *      将buildings数组信息转换为Point点，存储到points 的列表中。
 *      然后对points列表进行排序，排序规则是按照x坐标升序，因为在遍历building时，points中的点是无序的，
 *      如果有两个点的x坐标相等，那就按照bi，线段的序号升序
 *      然后定义TreeSet,存储线段编号，定义排序规则，按照高度降序排序，如果高度相同，就按照bi升序
 *      遍历已经有序的points列表，如果这个点是一条线段的起始点，就将其线段编号放入treeSet中，
 *      如果是终止点，就从treeSet中移除，定义newH 和 currH,新的高度和当前高度，当前高度初始为0，
 *      新的高度初始为0，如果treeSet不为空，那就得到treeSet.first()，当前最高的线段的编号，去buildings中，
 *      根据索引，取得新的高度值，当currH != newH 时，将结果放入res中
 *      64.26% ， 50.00%
 */
public class TheSkylineProblem218 {
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> res = getSkyline(buildings);
        System.out.println(res);
    }
    public static List<List<Integer>> getSkyline(int[][] buildings){
        List<List<Integer>> res = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0){
            return res;
        }
        List<Point> points = new ArrayList<Point>();
        for(int i = 0;i < buildings.length ; i ++){
            int[] build = buildings[i];
            points.add(new Point(build[0] , build[2] , i , true));
            points.add(new Point(build[1] , build[2] , i , false));
        }
        Collections.sort(points , new PointComparator());
        TreeSet<Integer> treeSet = new TreeSet<>(new BIComparator(buildings));
        int currH = 0;
        for(int i = 0; i < points.size(); i ++){
            Point p = points.get(i);
            if(p.start){
                treeSet.add(p.bi);
            }
            else{
                treeSet.remove(p.bi);
            }
            if(i + 1 < points.size() && points.get(i + 1).x == p.x){
                continue;
            }
            int newH = 0;
            if(!treeSet.isEmpty()){
                newH = buildings[treeSet.first()][2];
            }
            if(newH != currH){
                res.add(Arrays.asList(p.x , newH));
                currH = newH;
            }
        }
        return res;
    }
}
class BIComparator implements Comparator<Integer>{
    int[][] building ;
    public BIComparator(int[][] building){
        this.building = building;
    }
    //按照高度降序排序
    public int compare(Integer a , Integer b){
        int cmp = ((Integer)building[b][2]).compareTo((Integer)building[a][2]);
        if(cmp != 0){
            return cmp;
        }
        //如果高度相同，就按照bi升序排序
        return a.compareTo(b);
    }
}
class PointComparator implements Comparator<Point> {
    public int compare(Point a , Point b){
        // 按x坐标升序排序
        int cmp = ((Integer)a.x).compareTo((Integer)b.x);
        if(cmp != 0){
            return cmp;
        }
        // 如果x坐标相同，就按bi坐标升序排序，因为输入列表以按照x升序给出
        return ((Integer)a.bi).compareTo((Integer)b.bi);
    }
}
class Point{
    int x;
    int y;
    int bi;
    boolean start;
    public Point(int x , int y , int bi , boolean start){
        this.x = x;
        this.y = y;
        this.bi = bi;
        this.start = start;
    }
}
