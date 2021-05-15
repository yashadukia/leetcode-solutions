class LRUCache {

    class DLL
    {
        int key;
        int val;
        DLL next;
        DLL prev;
    }
    
    public int capacity;
    public int size;
    DLL head;
    DLL tail;
    public Map<Integer, DLL> cache = new HashMap<>();
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        this.size = 0;
        
        head = new DLL();
        tail = new DLL();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void removeNode(DLL node)
    {
        DLL prev = node.prev;
        DLL next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    public void addNode(DLL node)
    {
        // Always add node right after head
        node.prev = head;
        node.next = head.next;
        
        head.next = node;
        node.next.prev = node;
    }
    
    public DLL removeLast()
    {
        DLL node = tail.prev;
        removeNode(node);
        return node;
    }
    
    public void moveToHead(DLL node)
    {
        removeNode(node);
        addNode(node);
    }
    
    public int get(int key) {
        DLL node = cache.get(key);
        
        if (node == null)
            return -1;
        
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLL node = cache.get(key);
        
        if (node == null)
        {
            DLL newNode = new DLL();
            newNode.key = key;
            newNode.val = value;
            
            addNode(newNode);
            cache.put(key, newNode);
            
            ++size;
            
            // Remove the last element
            if (size > capacity)
            {
                DLL last = removeLast();
                cache.remove(last.key);
                size--;
            }
        }
        // Update the value of current node
        else
        {
            node.val = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */