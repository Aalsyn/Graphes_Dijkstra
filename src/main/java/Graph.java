import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph {
    private List<LinkedList<Integer>> graph;

    public Graph(int vertexNumber, float density){
        this.graph = new ArrayList<>(vertexNumber);

        generateEdges(vertexNumber, density);
    }

    private void generateEdges(int vertexNumber, float density){
        int edgesNumber = (int) (density/(vertexNumber * (vertexNumber - 1)));
        Random random = new Random();
        for (int i = 0; i < edgesNumber ; i++){
            int v1 = random.nextInt(vertexNumber);
            int v2 = random.nextInt(vertexNumber);

            if (v1 != v2 && !isEdgeExisting(v1, v2)){
                graph.get(v1).add(v2);
            }
        }
    }

    private boolean isEdgeExisting(int v1, int v2){
        return this.graph.get(v1).contains(v2);
    }

    public String toString(){
        StringBuilder graphString = new StringBuilder("Vertices :\n");
        for (int i = 0 ; i < graph.size() ; i++){
            graphString.append(graph.get(i) + " : neighbors : [");
            for (int j = 0 ; j < graph.get(i).size() -1; i++){
                graphString.append(graph.get(i).get(j)) + ", ");
            }
            graphString.append(graph.get(i).getLast() + "]\n");
        }
        return graphString.toString();
    }
}
