 
public class Pair{
    TreeNode node = null;
    int idx = 0;
    Pair(TreeNode node,int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int max = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int rm = q.peek().idx;
            int lm = q.peek().idx;
            while(size-->0){
                Pair rp = q.poll();
                rm = rp.idx;
                if(rp.node.left!=null)
                    q.add(new Pair(rp.node.left,rp.idx*2+1));
                if(rp.node.right!=null)
                    q.add(new Pair(rp.node.right,rp.idx*2+2));
            }
            max = Math.max(max,rm-lm+1);
        }
        return max;
    }
}