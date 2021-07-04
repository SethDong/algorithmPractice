/**
 * 思路: 通过hashmap实现查找时为O(1)的时间复杂度
 *       通过 双向链表实现 优先队列以实现在 “记录”出队次序
 * 细节：通过维护头结点实现快速定位队首，
 *       通过维护保护(尾)结点 1、在队列为空的时候保证双链表插入到队头  2、删除溢出元素时可以直接由尾结点定位
 *       不用单链表做队列，而用双链表？ 删除溢出元素时可以直接由尾结点定位
 * 效果： 不论是 查找 删除 插入 都是O(1)
 */

class LRUCache {
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node protect;
    private int capacity;
    
    class Node{
        private Node preNode;
        private Node nextNode;
        private Integer key;
        private int value;

        private Node(){};
    };


    public LRUCache(int capacity) {
        this.head = new Node();
        this.protect = new Node();
        this.head.nextNode = protect;
        this.protect.preNode = head;
        this.capacity = capacity;
        this.cache = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
      
        if(!this.cache.containsKey(key)){
            return -1;
        }
        Node node = this.cache.get(key);
        removeFromList(node);
        insertNode2Head(key, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        
        // 存在则更新
        if (this.cache.containsKey(key)){    
            removeFromList(this.cache.get(key));
            insertNode2Head(key,value);
        }else{
            insertNode2Head(key, node.value);
        }
        // 满了腾出空间
        if(this.capacity < this.cache.size()){
            removeFromList(this.protect.preNode);
        }
       
    }

    private void removeFromList(Node node){
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
        this.cache.remove(node.key);
    }

    private Node insertNode2Head(int key, int value){
        Node node = new Node();
        node.key = key;
        node.value = value;
        // 头后一结点建立联系
        this.head.nextNode.preNode = node;
        node.nextNode = this.head.nextNode;

        // 与头建立联系
        this.head.nextNode = node;
        node.preNode = this.head;

        // 插入hash备查
        this.cache.put(key,node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */