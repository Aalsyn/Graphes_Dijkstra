import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph1 = new Graph(100, 0.05f);
        //System.out.println(graph1.toString());
        List<Integer> shortestPathsDijsktra= Dijsktra.solver(graph1, 0);
        printShortestPathsDijsktra(shortestPathsDijsktra);

        int[][] shortestPathsFloyd = Floyd.solver(graph1);

    }

    public static void printShortestPathsDijsktra(List<Integer> shortestPaths){
        System.out.println("shortest paths with Dijsktra:");
        for (int i = 0 ; i < shortestPaths.size(); i++){
            System.out.println("[ " + i + " : " + shortestPaths.get(i) + " ]");
        }
    }

    public static void printShortestPathsFloyd(int[][] shortestPaths){
        System.out.println("shortest paths with Floyd :");
    }
}
