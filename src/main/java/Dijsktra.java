import java.util.ArrayList;
import java.util.List;

public class Dijsktra {
    //on considère que toutes les arrêtes sont de poids 1
    public static List<Integer> solver (Graph graph, Integer firstVertex){
        List<Integer> priorityList = new ArrayList<>();
        priorityList.addAll(graph.getVertices());
        List<Integer> shortestPaths = new ArrayList<>();

        for (int vertex : graph.getVertices()){
            shortestPaths.add(Integer.MAX_VALUE/100);
        }
        shortestPaths.set(firstVertex, 0);

        while (!priorityList.isEmpty()){
            int currentVertex = extractMin(priorityList, shortestPaths);
            for (int neighbor : graph.getGraph().get(currentVertex)){
                if (shortestPaths.get(neighbor) > shortestPaths.get(currentVertex) + 1){
                    shortestPaths.set(neighbor, shortestPaths.get(currentVertex) + 1);
                }
            }
        }


        return shortestPaths;
    }

    public static Integer extractMin(List<Integer> priorityList, List<Integer> shortestPaths){
        Integer min = priorityList.get(0);
        for (int vertex : priorityList){
            if (shortestPaths.get(min) > shortestPaths.get(vertex)){
                min = vertex;
            }
        }
        priorityList.remove(min);
        return min;
    }

    public static String toString(List<Integer> shortestPaths, int firstVertex){
        String printShortestPaths = firstVertex + " : [ ";
        for (int i = 0 ; i < shortestPaths.size(); i++){
            printShortestPaths += shortestPaths.get(i) + " ";
        }
        printShortestPaths += "]";
        return printShortestPaths;
    }
}
