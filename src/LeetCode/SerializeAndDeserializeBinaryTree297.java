package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LeetCode 297
 * 题意：
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 示例: 
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：序列化二叉树时，使用中序遍历顺序，对空指针也要处理，
 *      反序列化时，仍然按照中序遍历的顺序还原，空指针额外处理
 *      93.49% , 28.57%
 */
public class SerializeAndDeserializeBinaryTree297 {
    public static void main(String[] args) {

    }
    // 序列化一棵二叉树
    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        buildString(root , sb);
        return sb.toString();
    }

    // 按照中序遍历的顺序，存储到StringBuffer中
    public static void buildString(TreeNode root , StringBuffer sb){
        // 空指针也要处理
        if(root == null){
            sb.append("#").append("!");
            return ;
        }
        sb.append(root.val).append("!");
        buildString(root.left , sb);
        buildString(root.right , sb);
    }
    // Decodes your encoded data to tree.
    // 反序列化，将String转换为一棵二叉树
    public static TreeNode deserialize(String data) {
        // 一定要使用Arrays.asList()
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split("!")));
        return buildTree(queue);
    }
    public static TreeNode buildTree(LinkedList<String> queue){
        String pre = queue.poll();
        // 单独处理空指针
        if(pre.equals("#")){
            return null;
        }
        // 也是按照中序遍历的顺序，将树的节点还原
        TreeNode root = new TreeNode(Integer.parseInt(pre));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
