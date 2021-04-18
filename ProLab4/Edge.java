package ProLab4;

public class Edge implements Comparable<Edge> {

    Node source;
    Node destination;
    double weight;

    Edge(Node s, Node d, double w) {
        source = s;
        destination = d;
        weight = w;
    }

    public String toString() {
        return String.format("(%s -> %s, %f)", source.getName(), destination.getName(), weight);
    }

    @Override
    public int compareTo(Edge o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

