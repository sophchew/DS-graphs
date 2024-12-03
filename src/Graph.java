import java.util.List;

public interface Graph {
    void addVertex(String vertex);
    void addEdge(String source, String destination);
    void addWeightedEdge(String source, String destination, int weight);
    boolean hasEdge(String source, String destination);
    List<String> getNeighbors(String vertex);
    int getWeight(String source, String destination);
    int getVertexCount();
    boolean isDirected();
}
