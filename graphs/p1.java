import java.util.*;

public class p1 {
    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static List<String> getFriends(String user) {
        return graph.getOrDefault(user, new ArrayList<>());
    }

    static boolean isDirectFriend(String u, String v) {
        return graph.containsKey(u) && graph.get(u).contains(v);
    }

    static List<String> shortestPath(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(end)) break;

            for (String nei : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    parent.put(nei, curr);
                    q.add(nei);
                }
            }
        }

        List<String> path = new ArrayList<>();
        if (!parent.containsKey(end) && !start.equals(end)) return path;

        for (String at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        addEdge("Alice", "Bob");
        addEdge("Alice", "Charlie");
        addEdge("Bob", "David");
        addEdge("Charlie", "Eve");
        addEdge("David", "Eve");

        System.out.println("Friends of Alice: " + getFriends("Alice"));
        System.out.println("Bob & Eve connected? " + isDirectFriend("Bob", "Eve"));
        System.out.println("Shortest path Alice → Eve: " + shortestPath("Alice", "Eve"));
    }
}