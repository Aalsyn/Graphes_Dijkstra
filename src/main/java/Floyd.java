public class Floyd {

    public static int[][] solver (Graph graph){
        int[][] shortestPaths = new int[graph.getVerticesNumber()][graph.getVerticesNumber()];
        //initialisation
        for (int u = 0; u < graph.getVerticesNumber() ; u++){
            for (int v = 0; v < graph.getVerticesNumber(); v++){
                if (u == v) shortestPaths[u][v] = 0;
                else if (graph.getGraph().get(u).contains(v)) shortestPaths[u][v] = 1; //tous les arcs sont de poids 1
                else shortestPaths[u][v] = Integer.MAX_VALUE - 10; // - 10 pour éviter les dépassements d'entiers
            }
        }

        for (int k = 0; k < graph.getVerticesNumber(); k++){
            for (int u = 0; u < graph.getVerticesNumber(); u++){
                for (int v = 0; v < graph.getVerticesNumber(); v++){
                    shortestPaths[u][v] = Math.min(shortestPaths[u][v], shortestPaths[u][k] + shortestPaths[k][v]);
                }
            }
        }



        return shortestPaths;
    }
}
