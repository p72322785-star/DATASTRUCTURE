import java.util.*;

public class p5 {

    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void dfs(String node, Set<String> visited) {
        visited.add(node);
        for (String nei : graph.get(node)) {
            if (!visited.contains(nei)) dfs(nei, visited);
        }
    }

    static boolean isConnected() {
        Set<String> visited = new HashSet<>();
        String start = graph.keySet().iterator().next();
        dfs(start, visited);
        return visited.size() == graph.size();
    }

    static int minHops(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);
        int hops = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(end)) return hops;

                for (String nei : graph.get(curr)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
            hops++;
        }
        return -1;
    }

    public static void main(String[] args) {
        addEdge("R1","R2");
        addEdge("R1","R3");
        addEdge("R2","R4");
        addEdge("R3","R4");
        addEdge("R4","R5");
        addEdge("R5","R6");

        System.out.println("Connected: " + isConnected());
        System.out.println("Min hops R1 → R6: " + minHops("R1","R6"));
    }
}