class SmallestInfiniteSet {

    Set<Integer> setOfDeleted;
        int smallest;
        public SmallestInfiniteSet() {
            setOfDeleted = new HashSet<>();
            smallest = 1;
        }

        public int popSmallest() {
            if (!setOfDeleted.contains(smallest)) {
                setOfDeleted.add(smallest);
                return smallest++;
            } else {
                while (setOfDeleted.contains(smallest)) {
                    smallest++;
                }
                setOfDeleted.add(smallest);
                return smallest;
            }
        }

        public void addBack(int num) {
            if (smallest > num) {
                smallest = num;
            }
            setOfDeleted.remove(num);
        }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */