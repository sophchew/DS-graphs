import java.util.List;

public interface Graph {

    void addVertex(String vertex);
    void addEdge(String source, String destination);
    boolean hasEdge(String source, String destination);
    List<String> getNeighbors(String vertex);
    int getVertexCount();
    boolean isDirected();

}
