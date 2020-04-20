import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph {
    //on considère que toutes les arrêtes sont de poids 1
    private List<LinkedList<Integer>> graph;
    private List<Integer> vertices;
    private int verticesNumber;

    public Graph(int verticesNumber, float density){
        this.verticesNumber = verticesNumber;
        this.graph = new ArrayList<>(verticesNumber);
        this.vertices = new ArrayList<>(verticesNumber);
        for (int i = 0; i < verticesNumber ; i++){
            this.vertices.add(i);
            this.graph.add(new LinkedList<>());
        }
        generateEdges(density);
    }

    public List<LinkedList<Integer>> getGraph() {
        return graph;
    }

    public int getVerticesNumber() {
        return verticesNumber;
    }

    public List<Integer> getVertices() {
        return vertices;
    }


    private void generateEdges(float density){
        int edgesNumber = (int) ((verticesNumber * (verticesNumber - 1)) * density);
        Random random = new Random();
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < edgesNumber ; i++){
            while (v1 == v2 || isEdgeExisting(v1, v2)) {
                v1 = random.nextInt(verticesNumber);
                v2 = random.nextInt(verticesNumber);
            }
            graph.get(v1).addLast(v2);
        }
    }

    private boolean isEdgeExisting(int v1, int v2){

        return this.graph.get(v1).contains(v2);
    }

    public String toString(){
        StringBuilder graphString = new StringBuilder("Vertices :\n");
        for (int i = 0 ; i < this.verticesNumber; i++){
            graphString.append(i + " : neighbors : [");
            for (int j = 0 ; j < graph.get(i).size() - 1;  j++){
                graphString.append(graph.get(i).get(j) + ", ");
            }
            if (graph.get(i).isEmpty()) {
                graphString.append("]\n");
            }
            else{
                graphString.append(graph.get(i).getLast() + "]\n");
            }
        }
        return graphString.toString();
    }
}
