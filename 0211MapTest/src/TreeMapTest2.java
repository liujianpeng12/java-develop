/**
 * 二叉树经典的中序遍历
 */
public class TreeMapTest2 {
    public static void main(String[] args){
        TreeNode<Integer> treeNode = new TreeNode<>(1, null);
        treeNode.insert(2);
        treeNode.insert(6);
        treeNode.insert(3);
        treeNode.insert(5);
        treeNode.insert(9);
        treeNode.insert(4);
        treeNode.insert(8);
        treeNode.insert(7);
        treeNode.insert(10);

        // 中序遍历，打印结果为1到10的顺序
        treeNode.root().inOrderTraverse();
    }
}


class TreeNode<T extends Comparable<T>> {
    T value;
    TreeNode<T> parent;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value, TreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    /**
     * 获取根节点
     * @return
     */
    TreeNode<T> root() {
        TreeNode<T> cur = this;
        if(cur.parent != null) {
            cur = cur.parent;
        }
        return cur;
    }

    void inOrderTraverse(){
        if(this.left != null) this.left.inOrderTraverse();
        System.out.println(this.value);
        if(this.right != null) this.right.inOrderTraverse();
    }

    TreeNode<T> insert(T value){
        //
        TreeNode<T> cur = root();

        TreeNode<T> p;
        int dir;


        // 寻找元素应该插入的位置
        do {
            p = cur;
            if((dir = value.compareTo(p.value)) < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }while(cur != null);

        if(dir < 0) {
            p.left = new TreeNode(value, p);
            return p.left;
        }else {
            p.right = new TreeNode<>(value, p);
            return p.right;
        }
    }
}

