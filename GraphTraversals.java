import java.util.*;

public class GraphTraversals {

    public static Map<String, Integer> calculateDegreesUndirected(Map<String, List<String>> graph) {
        Map<String, Integer> degrees = new HashMap<>();
        
        for (String node : graph.keySet()) {
            degrees.put(node, graph.get(node).size());
        }
        return degrees;
    }

    public static List<String> bfsDirected(Map<String, List<String>> graph, String start) {
        List<String> bfsOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                bfsOrder.add(node);
                queue.addAll(graph.getOrDefault(node, Collections.emptyList()));
            }
        }
        return bfsOrder;
    }

    public static List<String> dfsDirected(Map<String, List<String>> graph, String start) {
        List<String> dfsOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        dfsHelper(graph, start, visited, dfsOrder);

        return dfsOrder;
    }

    private static void dfsHelper(Map<String, List<String>> graph, String node, Set<String> visited, List<String> dfsOrder) {
        if (!visited.contains(node)) {
            visited.add(node);
            dfsOrder.add(node);
            for (String neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                dfsHelper(graph, neighbor, visited, dfsOrder);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> undirectedGraph = new HashMap<>();
        undirectedGraph.put("A", Arrays.asList("B", "C"));
        undirectedGraph.put("B", Arrays.asList("A", "D"));
        undirectedGraph.put("C", Arrays.asList("A", "D"));
        undirectedGraph.put("D", Arrays.asList("B", "C"));

        System.out.println("Degrees of nodes (Undirected): " + calculateDegreesUndirected(undirectedGraph));

        Map<String, List<String>> directedGraph = new HashMap<>();
        directedGraph.put("A", Arrays.asList("B", "C"));
        directedGraph.put("B", Arrays.asList("D"));
        directedGraph.put("C", Arrays.asList("D"));
        directedGraph.put("D", new ArrayList<>());

        System.out.println("BFS (Directed): " + bfsDirected(directedGraph, "A"));
        System.out.println("DFS (Directed): " + dfsDirected(directedGraph, "A"));
    }
}
