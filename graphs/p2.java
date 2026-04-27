import java.util.*;

public class p2 {
    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    static boolean dfsCycle(String node, Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (String nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (dfsCycle(nei, visited, recStack)) return true;
        }

        recStack.remove(node);
        return false;
    }

    static boolean hasCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        for (String node : graph.keySet()) {
            if (dfsCycle(node, visited, recStack)) return true;
        }
        return false;
    }

    static List<String> topoSort() {
        Map<String, Integer> indegree = new HashMap<>();

        for (String u : graph.keySet()) {
            indegree.putIfAbsent(u, 0);
            for (String v : graph.get(u)) {
                indegree.put(v, indegree.getOrDefault(v, 0) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (String node : indegree.keySet()) {
            if (indegree.get(node) == 0) q.add(node);
        }

        List<String> result = new ArrayList<>();

        while (!q.isEmpty()) {
            String curr = q.poll();
            result.add(curr);

            for (String nei : graph.getOrDefault(curr, new ArrayList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) q.add(nei);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        addEdge("CS101", "CS102");
        addEdge("CS101", "CS201");
        addEdge("CS102", "CS202");
        addEdge("MATH101", "CS201");

        System.out.println("Cycle exists: " + hasCycle());
        System.out.println("Topological Order: " + topoSort());
    }
}