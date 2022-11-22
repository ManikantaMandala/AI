

public class Alphabeta {

    static final int COUNT = 10;
   static final int start_utility = Integer.MIN_VALUE;
   static final int end_utility = Integer.MAX_VALUE;
   static  int min_val;
   static  int max_val;

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
    Node rootnode = new Node(num,start_utility);
     int res= max(rootnode , num, Integer.MIN_VALUE, Integer.MAX_VALUE);
     print2D(rootnode);
     int actionTaken;
     if(rootnode.left.utility==res){
        System.out.println(rootnode.left.utility+ " "+rootnode.right.utility);
        actionTaken=rootnode.right.value;}
    else{
        System.out.println(rootnode.left.utility+ " "+rootnode.right.utility);
        actionTaken=rootnode.left.value;}
    return actionTaken;
    }

    public static int max(Node rootnode , int p_node , int alpha , int beta){

        if(endcase1(p_node)){
            //utility
            return basecase1( p_node,true );
//            rootnode.utility = val;

        }
        int val = Integer.MIN_VALUE;
            for (int i = 1; i <= 2; ++i) {
                insert(rootnode , p_node,i,start_utility);
                if(i==1) {
                    min_val = min(rootnode.left, p_node + i, alpha, beta);
                    rootnode.left.utility = min_val;

                }
                else{
                   min_val = min(rootnode.right,p_node+i,alpha , beta);
                    rootnode.right.utility = min_val;
                }
                if(min_val>val){
                  val = min_val;
                }
                alpha=Math.max(alpha,val);
                if (beta <= alpha){
                break;
            }}
        return val ; }

    public static int min(Node rootnode , int p_node , int alpha , int beta){
        if(endcase1(p_node)){
            //utility
         return  basecase1( p_node,false );

        }
            int val = Integer.MAX_VALUE;
            for (int i = 1; i <= 2; ++i) {
                insert(rootnode , p_node,i ,end_utility);
                if(i==1){
               max_val =  max(rootnode.left,p_node+i , alpha , beta); //-1
                    rootnode.left.utility = max_val;
                }
                else{
                  max_val =   max(rootnode.right,p_node+i, alpha , beta);
                    rootnode.right.utility = max_val;
                }
                if(max_val<val){
                    val = max_val;
                }
                beta=Math.min(beta,val);
                if (beta <= alpha){
                    break;}
    }
//        System.out.println("value - "+ val);
          return val;}

    public static boolean endcase1(int sum){
        boolean end = true;
        if(sum<20){
            end = false;
        }
        return end;
    }
    // utility
    public static int basecase1( int node , boolean ismax){


        if (node>=20 && !ismax){
            return -1;
        }
        else {
            return 1;
        }



    }

    public static void insert(Node r_node, int node_val, int value,int utility){
           if(value==1){
               r_node.left = new Node(node_val+1,utility);

           }
           else{
               r_node.right = new Node(node_val+2,utility);
           }
    }

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
    static void print2D(Node root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

}
