public class copyTreeWithRandom {
    public static void main(String[] args) {
        
    }

    class Tree{
        int data;
        Tree left,right,random;
        Tree(int d){
            data=d;
            left=null;
            right=null;
            random=null;
        }
    }

    //first method 
    //using hashmap
    //try it

    //DAMN THIS CODE WORKED 
    //THAT LEFT CLONING IS BEAUTIFUL FOR SURE
    //Baki everything is ease for sure

    //second method
    //without extra space baby
    public Tree cloneTree(Tree tree){
        //main function
          Tree mix = leftCloning(tree);
          setRandom(mix);
          Tree ans = extractClone(tree);
          return ans;
      }
      
      //simple code for left cloning bois
      public Tree leftCloning(Tree tree){
  
          if(tree == null) return null;
  
          Tree left = leftCloning(tree.left);
          Tree right = leftCloning(tree.right);
   
          //some rather later updations after having faith
          Tree node = new Tree(tree.data);
          tree.left = node;
          node.left = left;
          tree.right = right;
  
          return tree;
      }
  
      //try to write code settting random on your own
      //this part should be done now
      public void setRandom(Tree tree){
          if(tree == null) return;
  
          //otherwise find the random
          if(tree.random != null){
              tree.left.random = tree.random.left;
          }
  
          //now traverse it through
          setRandom(tree.left.left);
          setRandom(tree.right);
      }
  
      //now third function 
      //extract function, the golden one of them all
      //my version of code pretty lame for
      public Tree extractClone(Tree tree){
          if(tree == null) return null;
  
          Tree cloneTree = tree.left;
          
          Tree cloneLeft = extractClone(tree.left.left);
          Tree cloneRight = extractClone(tree.right);
   
          tree.left = tree.left.left;
      
          cloneTree.left = cloneLeft;
          cloneTree.right = cloneRight;
          
          return cloneTree;
      }

    
    
}
