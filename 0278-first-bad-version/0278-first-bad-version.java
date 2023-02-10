/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;
	int firstBad = Integer.MAX_VALUE;
	while(s <= e) {
		int mid = s + (e-s)/2;
		if(!isBadVersion(mid)) {
			s = mid+1;
		} else {
			firstBad = Math.min(firstBad, mid);
			e = mid-1;
		}
	}
	return firstBad;
    }
}