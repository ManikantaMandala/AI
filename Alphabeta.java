

public class Alphabeta {
    static final int COUNT = 10;
    static final int start_utility = Integer.MIN_VALUE;
    static final int end_utility = Integer.MAX_VALUE;
    static  int min_val;
    static  int max_val;

   // we defined a class named node which has two child
    // one name left and other right
    // every node has two values :- one is the node number named as value
    //                  and other is utility which stores its utility value

    static class Node{
        Node left;
        Node right;
        int value;
        int utility;

        public Node(int value,int utility){
            this.value=value;
            this.utility=utility;
        }
    }
    public int run(int num) {
        // This is main method from where computer will start building search tree
        // to decide it's move
        Node rootnode = new Node(num,start_utility);
        int res= max(rootnode , num, Integer.MIN_VALUE, Integer.MAX_VALUE);
        print2D(rootnode);
        if(rootnode.left.utility==res){
            return rootnode.left.value;
        }
        else{
            return rootnode.right.value;
        }

    }
    public static int max(Node rootnode , int p_node , int alpha , int beta){
    // checking whether given node is the endcase or not
        if(endcase1(p_node)){
            // returning utility for end node
            return basecase1( p_node,true );
//            rootnode.utility = val;
        }
        // if the node is not the endcase
        // then it will expand itself further
        // for each node there are 2 possible cases :-
        // +1 or +2


        int val = Integer.MIN_VALUE;   // -infinity at initial stage
        for (int i = 1; i <= 2; ++i) {
                // adding current node value into the rootnode to create search tree
            insert(rootnode , p_node,i,start_utility);
            if(i==1) {
                min_val = min(rootnode.left, p_node + i, alpha, beta);  // +1 case
                rootnode.left.utility = min_val;
            }
            else{
                min_val = min(rootnode.right,p_node+i,alpha , beta);  //  +2 case
                rootnode.right.utility = min_val;
            }
                // if min_val i.e. utility is maximum than val -infinity it will change it's value
            if(min_val>val){
                val = min_val;
            }

   // to assign alpha the maximum value as max i.e. player in this try to maximize its utility
            alpha=Math.max(alpha,val);
                // pruning the edge condition according to aplha-beta pruning algorithm
            if (beta <= alpha){
                break;
            }}
        return val ;
    }

    public static int min(Node rootnode , int p_node , int alpha , int beta) {

        // checking whether given node is the endcase or not
        if (endcase1(p_node)) {// returning utility for end node
            return basecase1(p_node, false);
        }
        int val = Integer.MAX_VALUE;    //  +infinity at initial stage

        // if the node is not the endcase
        // then it will expand itself further
        // for each node there are 2 possible cases :-
        // +1 or +2
        for (int i = 1; i <= 2; ++i) {
            // adding current node value into the rootnode to create search tree
            insert(rootnode, p_node, i, end_utility);
            if (i == 1) {
                max_val = max(rootnode.left, p_node + i, alpha, beta);   // +1 case
                rootnode.left.utility = max_val;
            } else {
                max_val = max(rootnode.right, p_node + i, alpha, beta);  //  +2 case
                rootnode.right.utility = max_val;
            }

            // if max_val i.e. utility is minimum than val infinity val will change it's value
            if (max_val < val) {
                val = max_val;
   // to assign beta the minimum value as min i.e. computer in this try to minimize the player's utility
                beta = Math.min(beta, val);
                // pruning the edge condition according to aplha-beta pruning algorithm
                if (beta <= alpha) {
                    break;
                }
            }
//        System.out.println("value - "+ val);
        }
        return val;
    }

    // method to check whether the node reaches to end case or not
    // i.e. the value of sum is less than 20 or not
    public static boolean endcase1(int sum){
        boolean end = true;
        if(sum<20){
            end = false;
        }
        return end;
    }
    // to assign utilities to the terminal after which the search tree will bracktrack
    // to find the most optimised path for computer
    public static int basecase1(int node , boolean ismax){


        if (node>=20 && !ismax){
            return -1;
        }
        else {
            return 1;
        }

            }

            // to inset or add nodes to create search tree
    public static void insert(Node r_node, int node_val, int value,int utility){
           if(value==1){
               r_node.left = new Node(node_val+1,utility);

           }
           else{
               r_node.right = new Node(node_val+2,utility);
           }
    }

    // to print search tree
    public static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root==null) {
            return;
        }


/// Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + " utility: "+root.utility+"\n");

        // Process left child
        print2DUtil(root.left, space);


    }

    // start printing search tree by calling print2DUtil method
    static void print2D(Node root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

}
