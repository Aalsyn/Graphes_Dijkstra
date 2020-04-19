import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph1 = new Graph(10, 0.1f);
        System.out.println(graph1.toString());
        List<Integer> shortestPaths= Dijsktra.solver(graph1, 0);
        System.out.println("shortestPaths :");
        for (int i = 0 ; i < shortestPaths.size(); i++){
            System.out.println("[ " + i + " : " + shortestPaths.get(i) + " ]");
        }
    }
}
