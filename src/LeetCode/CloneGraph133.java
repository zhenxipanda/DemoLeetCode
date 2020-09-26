package LeetCode;
/**
 * LeetCode 133
 * 题意：给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），
 * 第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * 思路：递归，设置递归结束条件，关键在于node - clone 直接的映射不好想，
 *      99.33% , 44.00%
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    public static void main(String[] args) {

    }
    public Graph cloneGraph(Graph node) {
        Map<Graph , Graph> lookup = new HashMap<>();
        return dfs(node , lookup);
    }
    public Graph dfs(Graph node , Map<Graph , Graph> lookup){
        if(node == null){
            return null ;
        }
//        设置递归结束的条件，避免死循环
        if(lookup.containsKey(node)){
            return lookup.get(node);
        }
        Graph clone = new Graph(node.val , new ArrayList<>());
        lookup.put(node , clone);
        for(Graph n : node.neighbors){
            clone.neighbors.add(dfs(n , lookup));
        }
        return clone;
    }
}
//因为Node 类在其他文件中存在同名，于是这里改了名
 class Graph {
    public static int val;
    public static List<Graph> neighbors;

    public Graph() {
        val = 0;
        neighbors = new ArrayList<Graph>();
    }

    public Graph(int _val) {
        val = _val;
        neighbors = new ArrayList<Graph>();
    }

    public Graph(int _val, ArrayList<Graph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
