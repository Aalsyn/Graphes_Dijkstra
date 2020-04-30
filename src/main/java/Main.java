public class Main {

    public static void main(String[] args) {

        /*
        Graph graph1 = new Graph(1000, 0.01f);
        //System.out.println(graph1.toString());

        long fullDijsktraTimer = System.nanoTime();
        //String fullDijsktraResults = Dijsktra.fullDijsktraString(graph1);
        Dijsktra.fullDijsktra(graph1);
        double fullDijsktraElapsedTime = (System.nanoTime() - fullDijsktraTimer)/1000000.0;
        System.out.println("full Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
       // System.out.println(fullDijsktraResults);

        long floydTimer = System.nanoTime();
        int[][] shortestPathsFloyd = Floyd.solver(graph1);
        double floydElapsedTime = (System.nanoTime() - floydTimer)/1000000.0;
        //String floydResults = Floyd.toString(shortestPathsFloyd);
        System.out.println("floyd timer : " + floydElapsedTime + " ms");
        //System.out.println(floydResults);


         */


        bestSolverByDensity(500, 0.1f, 0.1f);
        //bestSolverByGraphSize(1000, 10, 0.05f);
    }



    public static void bestSolverByGraphSize(int maxSize, int sizeStep, float density){
        boolean dijsktraIsFaster = false;
        long fullDijsktraTimer;
        double fullDijsktraElapsedTime = 0;
        long floydTimer;
        double floydElapsedTime= 0;
        for (int graphSize = sizeStep ; graphSize < maxSize; graphSize += sizeStep){
            Graph graph = new Graph(graphSize, density);

            fullDijsktraTimer = System.nanoTime();
            Dijsktra.fullDijsktra(graph);
            fullDijsktraElapsedTime = (System.nanoTime() - fullDijsktraTimer)/1000000.0;

            floydTimer = System.nanoTime();
            Floyd.solver(graph);
            floydElapsedTime = (System.nanoTime() - floydTimer)/1000000.0;

            if (dijsktraIsFaster && fullDijsktraElapsedTime >= floydElapsedTime){
                dijsktraIsFaster = false;
            }

            else if (!dijsktraIsFaster && fullDijsktraElapsedTime < floydElapsedTime){
                System.out.println("For " + graphSize + "vertices, at density " + density + ", Dijsktra becomes faster :");
                System.out.println("Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
                System.out.println("Floyd timer : " + floydElapsedTime + " ms");
                dijsktraIsFaster = true;
            }

            if (2 * fullDijsktraElapsedTime < floydElapsedTime){
                System.out.println("For " + graphSize + "vertices, at density " + density + ", Dijsktra becomes at least 2 times faster :");
                System.out.println("Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
                System.out.println("Floyd timer : " + floydElapsedTime + " ms");
                break;
            }
        }
        System.out.println("Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
        System.out.println("Floyd timer : " + floydElapsedTime + " ms");
    }


    public static void bestSolverByDensity(int verticesNumber, float initialDensity, float densityStep){
        boolean dijsktraIsFaster = false;
        long fullDijsktraTimer;
        double fullDijsktraElapsedTime = 0;
        long floydTimer;
        double floydElapsedTime= 0;
        for (float density = initialDensity ; density < 1f; density += densityStep){
            Graph graph = new Graph(verticesNumber, density);

            fullDijsktraTimer = System.nanoTime();
            Dijsktra.fullDijsktra(graph);
            fullDijsktraElapsedTime = (System.nanoTime() - fullDijsktraTimer)/1000000.0;

            floydTimer = System.nanoTime();
            Floyd.solver(graph);
            floydElapsedTime = (System.nanoTime() - floydTimer)/1000000.0;

            if (dijsktraIsFaster && fullDijsktraElapsedTime >= floydElapsedTime){
                dijsktraIsFaster = false;
            }

            else if (!dijsktraIsFaster && fullDijsktraElapsedTime < floydElapsedTime){
                System.out.println("For " + verticesNumber + "vertices, at density " + density + ", Dijsktra becomes faster :");
                System.out.println("Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
                System.out.println("Floyd timer : " + floydElapsedTime + " ms");
                dijsktraIsFaster = true;
            }

            if (2 * fullDijsktraElapsedTime < floydElapsedTime){
                System.out.println("For " + verticesNumber + "vertices, at density " + density + ", Dijsktra becomes at least 2 times faster :");
                System.out.println("Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
                System.out.println("Floyd timer : " + floydElapsedTime + " ms");
                break;
            }
        }
        System.out.println("Dijsktra timer : " + fullDijsktraElapsedTime + " ms");
        System.out.println("Floyd timer : " + floydElapsedTime + " ms");
    }






}
