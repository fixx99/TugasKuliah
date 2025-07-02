package graphsearch;
import java.util.*;

public class GraphSearch {
    //representasi graf menggunakan hasmap
    static Map <String, List<String>> graph = new HashMap<>();
    
    public static void main(String[] args) {
        //inisiasi graf
        graph.put("a1", Arrays.asList("a2", "a3"));
        graph.put("a2", Arrays.asList("a4", "a5"));
        graph.put("a3", Arrays.asList("a6", "a7"));
        graph.put("a4", Arrays.asList());
        graph.put("a5", Arrays.asList());
        graph.put("a6", Arrays.asList());
        graph.put("a7", Arrays.asList());
        
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukan node tujuan: ");
        String target = scanner.nextLine();
        
        System.out.println("\n=== Depth-Firsy Search ===");
        Set<String> visitedDFS = new HashSet<>();
        boolean foundDFS = dfs("a1", target, visitedDFS);
        System.out.println("Node ditemukan: " + foundDFS);
        
        System.out.println("\n=== Breadth-First Search ===");
        boolean foundBFS = bfs("a1", target);
        System.out.println("node ditemukan?: " + foundBFS);
    }
    //fungsi DFS (rekursif)
    public static boolean dfs(String current, String target, Set<String> visited) {
        System.out.println("Mengunjungi: " + current);
        if (current.equals(target)) return true;

        visited.add(current);

        for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //fungsi BFS(menggunakan queue)
    public static boolean bfs(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println("Mengunjungi: " + current);
            if (current.equals(target)) return true;

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }
    
}
