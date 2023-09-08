public class SegmentTree {
     private int tree[];
     SegmentTree(int[] arr){
        tree = new int[4*arr.length];
        constructST(0, arr.length-1, 0, arr);
     }
     
     private int constructST(int ss,int se,int si,int arr[]){
        if(ss==se){
            tree[si] = arr[ss];
            return arr[ss];    
        }
        int mid = (ss+se)/2;
        tree[si] = constructST(ss, mid, 2*si+1, arr)+constructST(mid+1, se, 2*si+2, arr);
        return tree[si];
     }

    public int getSumRec(int qs,int qe,int ss,int se,int si){
        if(se<qs||ss>qe) return 0;
        if(qs<=ss&&qe>=se) return tree[si];
        int mid = (ss+se)/2;
        return getSumRec(qs, qe, ss, mid, 2*si+1)+getSumRec(qs, qe, mid+1, se, 2*si+2);
    }

    void updateRec(int ss,int se,int i,int si,int diff){
        if(i<ss||i>se) return;
        tree[si] = tree[si]+diff;
        if(ss<se){
            int mid = (ss+se)/2;
            updateRec(ss, mid, i, 2*si+1, diff);
            updateRec(mid+1, se, i, 2*si+2, diff);
        }
    } 
}
class NumArray {
    SegmentTree obj;
    int n;
    int diff;
    int arr[];
    public NumArray(int[] nums) {
        obj = new SegmentTree(nums);
        n = nums.length;
        diff = 0;
        arr = nums;
    }
    
    public void update(int index, int val) {
        diff = val-arr[index];
        arr[index] = val;
        obj.updateRec(0,n-1,index,0,diff);
    }
    
    public int sumRange(int left, int right) {
        if(right<left) return 0;
       return obj.getSumRec(left,right,0,n-1,0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */