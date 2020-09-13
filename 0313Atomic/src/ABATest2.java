import java.util.concurrent.atomic.AtomicReference;

public class ABATest2 {

    public static void main(String[] args) {
        testStack();
    }

    private static void testStack() {
        // 初始化栈为 top->1->2->3
        Stack stack = new Stack();
        stack.push(new Stack.Node(3));
        stack.push(new Stack.Node(2));
        stack.push(new Stack.Node(1));

        //线程1出栈1个元素
        new Thread(()->{
            stack.pop();
        }).start();

        //线程2出栈两个元素
        new Thread(()->{
            Stack.Node A = stack.pop();
            Stack.Node B = stack.pop();
            // 线程2又把A入栈了
            stack.push(A);
        }).start();
    }

    static class Stack {
        //将top放在原子类中
        AtomicReference<Node> top = new AtomicReference<>();

        //栈中节点信息
        static class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        //出栈
        public Node pop() {
            for(;;) {
                //获取栈顶节点
                Node t = top.get();
                if(t == null) {
                    return null;
                }
                //栈顶下一个节点
                Node next = t.next;
                //CAS更新top指向next节点
                if(top.compareAndSet(t, next)) {
                    // 把栈顶元素弹出，应该把next清空防止外面直接操作栈
                    t.next = null;
                    return t;
                }
            }
        }

        //入栈
        public void push(Node node) {
            for(;;) {
                //获取栈顶节点
                Node next = top.get();
                node.next = next;
                //CAS更新top指向新节点
                if(top.compareAndSet(next, node)) {
                    return;
                }
            }
        }
    }
}
