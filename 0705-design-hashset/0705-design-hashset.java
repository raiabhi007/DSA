class MyHashSet {
		int[] set;
	public MyHashSet() {
		set = new int[50];
	}

	public void add(int key) {
			if (key >= set.length){
				set = Arrays.copyOf(set, key+1);
			}
			set[key] = 1;
	}

	public void remove(int key) {
		if (key < set.length){
			set[key]=0;
		}
	}

	public boolean contains(int key) {
		if (key >= set.length){
			return false;
		}
		return set[key] == 1;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */