package singleLinked;

public class MySingleLinked implements SingleLinked {
    /**
     * 用内部类进行节点的封装

     */
    class Node{
         int data;
         Node next = null;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    //定义一个head指针
    private Node head = null;


    //头插 分两种情况：链表为空，链表不为空
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }

    }
    //尾插
    public void addLast(int data) {
        Node cur = this.head;
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else {
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }

    }
    public Node getPreIndex(int index){
        if(index<0 || index>getLength()){
            System.out.println("插入位置不合法");
        }
        int count = 0 ;
        Node cur = this.head;
        while (cur.next!=null && count<index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //在指定位置插入数据
    public boolean addIndex(int index, int data) {
        Node preIndex = getPreIndex(index);
        Node node = new Node(data);
        node.next = preIndex.next;
        preIndex.next = node;
        return true;
    }

    public boolean contains(int key) {
        Node cur = this.head;
        while (cur!=null){
            if (cur.data==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int remove(int key) {
        //删除成功返回1，删除失败返回-1
        //先判断要删除的数字是不是第一个节点
        if(this.head.data == key){
            this.head = head.next;
            return 1;
        }
        //遍历剩余节点，删除key，删除成功返回1；删除失败返回-1
        Node cur = this.head;
        while (cur.next!=null){
            if(cur.next.data == key){
                cur.next = cur.next.next;
                return 1;
            }
            cur = cur.next;
        }
       return -1;
    }

    public void removeAll(int key) {
        //先删除除头结点以外的节点中的重复数字
        Node cur = this.head.next;
        Node pre = this.head;
        while (cur != null){
            if(cur.data == key){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }

    }

    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            count ++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();

    }

    public void clear() {
    //从头结点开始将每个节点的next置为null
        while (this.head != null){
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }
}
