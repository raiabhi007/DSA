class BrowserHistory {
    int currentIndex = 0;
    List<String> history = new ArrayList<>();

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }
    
    public void visit(String url) {
        // Clear the unwanted browser history
        history.subList(currentIndex + 1, history.size()).clear();
        history.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex=Math.max(currentIndex - steps, 0);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex=Math.min(currentIndex + steps, history.size() - 1);
        return history.get(currentIndex);
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */