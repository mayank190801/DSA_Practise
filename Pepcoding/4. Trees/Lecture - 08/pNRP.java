public class pNRP{
    public static void main(String[] args) {
        
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //lol this bad boy really works tho
    //i could think of these logic , i am happy about it 
    //POPULATING NEXT RIGHT POINTER

    public Node connect(Node root) {
        if(root == null) return null;
        helper(root.left, root, true);
        helper(root.right, root, false);
        return root;
    }

    public void helper(Node root, Node parent, boolean left){

        if(root == null) return;

        if(left){   
            root.next = parent.right;
        }else{
            if(parent.next != null)
                root.next = parent.next.left;
        }

        helper(root.left, root, true);
        helper(root.right, root, false);
    }

    //POPULATING NEXT RIGHT POINTER II
    //Both of my code works lol
    public Node connect(Node root) {
        if(root == null) return null;
        helper(root.right, root, false);
        helper(root.left, root, true);
        return root;
    }

    public void helper(Node root, Node parent, boolean left){

        if(root == null) return;
        //there would be some advanced changes in here
        //that is right ka right ka right krte jao jbtak mile na

        if(left){   
            if(parent.right != null)
                root.next = parent.right;
            else{
                root.next = finder(root, parent);               
            }
        }else{
            root.next = finder(root,parent);

        }

        helper(root.right, root, false);
        helper(root.left, root, true);
        
    }

    public Node finder(Node root, Node parent){
        //only works when 
        //pretty dope function if you think about it vaise toh
        Node find = null;
        while(true){
            if(parent.next == null) return null;
            if(parent.next.left != null){
                find = parent.next.left;
                break;
            }

            if(parent.next.right != null){
                find = parent.next.right;
                break;
            }

            parent = parent.next;
        }

        return find;
    }

    ///------------------------------------------------------
    //HW Alert, try doing this approach without static
    //use Node[] array and shit, whatever you like
    //or simply finish that function forever

    //SIR VERSION OF CODE
    //Iterative methods are used
    //POPULATE NEXT RIGHT POINTER 2
    Node prev = null;
    Node nstart = null;

    //iterative version if kaafi tool too!!!
    //Tho recursive one work too tho, no issues in that
    //tho this is O(N)
    public Node connect(Node root) {
        Node curr= root;
    
        while(curr != null){
            prev = null;
            nstart = null;
            //next start pointer
            while(curr != null){
                set(curr.left);
                set(curr.right);
                curr = curr.next;
            } 

            curr = nstart;
        }
        return root;
    }

    public void set(Node node){
        if(node != null){
            if(prev == null){
                nstart = node;
            }else{
                prev.next = node;
            }
            prev = node;
        }
    }

}