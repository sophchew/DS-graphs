import java.util.List;
import java.util.Map;

class AdjacencyMatrixGraph implements Graph {
    private Map<String, Integer> vertexIndices;
    private List<String> vertices;
    private boolean[][] adjacencyMatrix;
    private boolean isDirected;

    public AdjacencyMatrixGraph(boolean isDirected) {
        // TODO: Initialize the graph with proper data structures
    }

    @Override
    public void addVertex(String vertex) {
        // TODO: Add vertex to the graph
        // Don't forget to resize matrix if necessary
    }

    private void resizeMatrix() {
        // TODO: Implement matrix resizing when capacity is reached
    }

    @Override
    public void addEdge(String source, String destination) {
        // TODO: Add edge between source and destination
        // Remember to handle both directed and undirected cases
    }

    @Override
    public boolean hasEdge(String source, String destination) {
        // TODO: Check if edge exists between source and destination
        return false;
    }

    @Override
    public List<String> getNeighbors(String vertex) {
        // TODO: Return list of all vertices connected to given vertex
        return null;
    }

    @Override
    public int getVertexCount() {
        // TODO: Return number of vertices in graph
        return 0;
    }

    @Override
    public boolean isDirected() {
        // TODO: Return whether graph is directed
        return false;
    }
}