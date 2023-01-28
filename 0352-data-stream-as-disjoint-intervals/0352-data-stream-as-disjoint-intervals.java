class SummaryRanges {
    private final Set<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }
    public void addNum(int num) {
        set.add(num);
    }

    public int[][] getIntervals() {
        if (set.isEmpty()) return new int[0][2];

        List<int[]> list = new ArrayList<>();
        var start = -1;
        var end = -1;

        for (int item: set) {
            if (start == -1) {
                start = item;
                end = item;
                continue;
            }

            if (item == end+1) {
                end = item;
            } else {
                list.add(getInterval(start, end));
                start = item;
                end = item;
            }
        }

        list.add(getInterval(start, end));

        return list.toArray(new int[0][2]);
    }

    private int[] getInterval(int start, int end) {
        return new int[]{start, end};
    }
}
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */