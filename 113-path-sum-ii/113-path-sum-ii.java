
class Solution {
     boolean isLeaf(TreeNode root){
        return root.left==null&&root.right==null;        
    }
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        pathSumHelper(root,targetSum,list);
        return ans;
        
    }
    public void pathSumHelper(TreeNode root,int targetSum,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        if(targetSum-root.val==0&&isLeaf(root)){
            ans.add(new ArrayList<>(list));
        }
        pathSumHelper(root.left,targetSum-root.val,list);
        pathSumHelper(root.right,targetSum-root.val,list);
        list.remove(list.size()-1);
    }
    
}