package JianZhiOffer;

/**
 * 剑指offer 08
 * 题意：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路：先判断此节点是否有右孩子，如果存在，找右子树的最左节点，即向右走一步之后，一直向左走，
 *      如果不存在，找父节点，判断此节点是否是父节点的左孩子，如果是，父节点即为下一个节点，
 *      如果此节点不是父节点的左孩子，向向上找，直到不存在父，或者此节点是父的左孩子，
 *      不存在父，return null
 */
public class interview08 {
    public static void main(String[] args) {

    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else{
            while (pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
