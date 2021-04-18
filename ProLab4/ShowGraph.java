package ProLab4;

public class ShowGraph {

    public String enemyRoad(int ex, int ey, int cx, int cy) {
        Graph graph = new Graph(true);

        String[][] tablo = {
                {"d", "d", "d", "3,0", "d", "d", "d", "d", "d", "d", "10,0", "d", "d"},
                {"d", "1,1", "2,1", "3,1", "4,1", "d", "6,1", "7,1", "8,1", "9,1", "10,1", "11,1", "d"},
                {"d", "1,2", "d", "3,2", "4,2", "5,2", "6,2", "7,2", "8,2", "d", "d", "11,2", "d"},
                {"d", "1,3", "2,3", "3,3", "4,3", "d", "6,3", "d", "8,3", "9,3", "d", "11,3", "d"},
                {"d", "1,4", "d", "3,4", "d", "d", "6,4", "d", "8,4", "d", "d", "11,4", "d"},
                {"0,5", "1,5", "d", "3,5", "4,5", "5,5", "6,5", "d", "8,5", "d", "10,5", "11,5", "d"},
                {"d", "1,6", "d", "d", "4,6", "5,6", "6,6", "d", "8,6", "9,6", "10,6", "11,6", "d"},
                {"d", "1,7", "d", "3,7", "4,7", "5,7", "6,7", "7,7", "8,7", "9,7", "10,7", "11,7", "12,7"},
                {"d", "1,8", "d", "3,8", "d", "d", "d", "d", "d", "9,8", "10,8", "11,8", "d"},
                {"d", "1,9", "2,9", "3,9", "4,9", "5,9", "6,9", "7,9", "8,9", "9,9", "10,9", "11,9", "d"},
                {"d", "d", "d", "3,10", "d", "d", "d", "d", "d", "d", "d", "d", "d"},};

        Node[][] dugumler = new Node[11][13];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {

                try {
                    dugumler[i][j] = new Node(tablo[i][j]);
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException thrown!");
                }
            }

        }
        {
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                    if (i + 1 <= 10 && j + 1 <= 12) {

                        {   if (tablo[i][j] != "d" )
                        {   if (tablo [i+1][j] != "d")
                        {
                            graph.addEdge(dugumler[i][j], dugumler[i + 1][j], 1);
                            graph.addEdge(dugumler[i + 1][j], dugumler[i][j], 1);
                        }

                            if(tablo[i][j+1]!= "d")
                            {
                                graph.addEdge(dugumler[i][j], dugumler[i][j + 1], 1);
                                graph.addEdge(dugumler[i][j + 1], dugumler[i][j], 1);
                            }
                        }
                        }
                    }

                }
            }
        }
        String yol;
        yol = graph.DijkstraShortestPath(dugumler[ex][ey], dugumler[cx][cy]);
        return yol;

    }
}


