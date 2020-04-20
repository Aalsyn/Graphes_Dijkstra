public class Floyd {

    public static int[][] solver (Graph graph){
        int verticesNumber = graph.getVerticesNumber();
        int[][] shortestPaths = new int[verticesNumber][verticesNumber];
        //initialisation
        for (int u = 0; u < verticesNumber ; u++){
            for (int v = 0; v < verticesNumber; v++){
                if (u == v) shortestPaths[u][v] = 0;
                else if (graph.getGraph().get(u).contains(v)) shortestPaths[u][v] = 1; //tous les arcs sont de poids 1
                else shortestPaths[u][v] = Integer.MAX_VALUE/100; // /100 pour éviter les dépassements d'entiers
            }
        }

        for (int k = 0; k < verticesNumber; k++){
            for (int u = 0; u < verticesNumber; u++){
                for (int v = 0; v < verticesNumber; v++){
                    if (u == v) continue;
                    shortestPaths[u][v] = Math.min(shortestPaths[u][v], shortestPaths[u][k] + shortestPaths[k][v]);
                }
            }
        }
        return shortestPaths;
    }

    public static String toString(int[][] shortestPaths){
        String printShortestPaths = "shortest paths with Floyd : \n";
        for (int i = 0 ; i < shortestPaths.length; i++){
            printShortestPaths += i + " : [ ";
            for (int j = 0; j < shortestPaths[i].length; j++){
                printShortestPaths += shortestPaths[i][j] + " ";
            }
            printShortestPaths += "]\n";
        }
        return printShortestPaths;
    }
}
