class Edge{
    public String from;
    public String to;
    public double value;
    public Edge(String f, String t, double v){
        this.from = f;
        this.to = t;
        this.value = v;
    }
}

class Solution {

    boolean isFound = false;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Edge>> hashMap = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            List<String> equa = equations.get(i);
            double c = values[i];

            if(!hashMap.containsKey(equa.get(0))){
                hashMap.put(equa.get(0), new ArrayList<>());
            }

            hashMap.get(equa.get(0)).add(new Edge(equa.get(0), equa.get(1), c));

            if(!hashMap.containsKey(equa.get(1))){
                hashMap.put(equa.get(1), new ArrayList<>());
            }

            hashMap.get(equa.get(1)).add(new Edge(equa.get(1), equa.get(0), 1 / c));
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);

            String start = query.get(0);
            String end = query.get(1);

            if(!hashMap.containsKey(start) || !hashMap.containsKey(end)){
                res[i] = -1;
                continue;
            }

            if(start == end){
                res[i] = 1;
                continue;
            }
            isFound = false;
            res[i] = dfs(start, end, hashMap, 1, new HashSet<>());
        }

        return res;
    }

    public double dfs(String from, String target, HashMap<String, List<Edge>> hashMap, double current, HashSet<String> visited){
        if(from.equals(target)){
            isFound = true;
            return current;
        }
        visited.add(from);
        List<Edge> thisList = hashMap.get(from);
        for(Edge edge : thisList){
            if(!visited.contains(edge.to)){
                double c = dfs(edge.to, target, hashMap, current * edge.value, visited);
                if(isFound){
                    return c;
                }
            }
        }
        return -1;

    }
}