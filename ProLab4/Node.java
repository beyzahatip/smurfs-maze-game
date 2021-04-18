package ProLab4;

import java.util.LinkedList;


public class Node {

    private String name;
    private boolean visited;
    LinkedList<Edge> edges;

    Node(String name) {
        this.name = name;
        visited = false;
        edges = new LinkedList<>();
    }

    boolean isVisited() {
        return visited;
    }
    void visit() {
        visited = true;
    }
    void unvisit() {
        visited = false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

