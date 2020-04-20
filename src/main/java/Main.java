import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph1 = new Graph(10, 0.2f);
        System.out.println(graph1.toString());
        System.out.println(fullDijsktra(graph1));

        int[][] shortestPathsFloyd = Floyd.solver(graph1);
        System.out.println(Floyd.toString(shortestPathsFloyd));
    }

    public static String fullDijsktra(Graph graph){
        String fullDijsktraString = "shortest paths with Dijsktra :\n";
        for (int i = 0; i < graph.getVerticesNumber(); i++){
            fullDijsktraString += Dijsktra.toString(Dijsktra.solver(graph, i), i) + "\n";
        }
        return fullDijsktraString;
    }






}
