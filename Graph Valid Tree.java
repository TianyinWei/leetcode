public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0)  {
            if (n == 1) return true;
            else return false;
        }
        HashMap<Integer, ArrayList<Integer>> build = new HashMap<>();
        Queue<Integer> nodes = new LinkedList<Integer>();
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            build.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < len; i++) {
            if (build.containsKey(edges[i][0])) {
                build.get(edges[i][0]).add(edges[i][1]);
            }   else {
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(edges[i][1]);
                build.put(edges[i][0], tempList);
            }
            
            if (build.containsKey(edges[i][1])) {
                build.get(edges[i][1]).add(edges[i][0]);
            }   else {
                ArrayList tempList = new ArrayList<Integer>();
                tempList.add(edges[i][0]);
                build.put(edges[i][1], tempList);
            }
        }
        
        boolean[] visited = new boolean[n];
        nodes.offer(0);
        while(!nodes.isEmpty()) {
            int cur = nodes.poll();
            if (visited[cur]) return false;
            else {
                visited[cur] = true;
                for (int neighbor : build.get(cur)) {
                    if (!visited[neighbor]) {
                        nodes.offer(neighbor);
                    }
                }
            }
        }
        for (boolean hasVisited : visited) {
            if (hasVisited == false)    return false;
        }
        
        return true;
    }
}
