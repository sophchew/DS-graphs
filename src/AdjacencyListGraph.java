import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AdjacencyListGraph implements Graph {
    private Map<String, List<Edge>> adjacencyList;  // Vertex -> List of Edges
    private boolean isDirected;

    public AdjacencyListGraph(boolean isDirected) {
        //  Initialize the graph with proper data structures
        this.isDirected = isDirected;
        adjacencyList = new HashMap<>();

    }

    @Override
    public void addVertex(String vertex) {
        // Add vertex to the graph
        adjacencyList.put(vertex, new ArrayList<>());

    }

    @Override
    public void addEdge(String source, String destination) {
        // Add unweighted edge (default weight of 1)
        if(!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if(!adjacencyList.containsKey(destination)){
            addVertex(destination);
        }
        adjacencyList.get(source).add(new Edge(destination, 1));
        if(!isDirected) {
            adjacencyList.get(destination).add(new Edge(source, 1));
        }
    }

    @Override
    public void addWeightedEdge(String source, String destination, int weight) {
        // Add edge with specified weight
        if(!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if(!adjacencyList.containsKey(destination)){
            addVertex(destination);
        }
        adjacencyList.get(source).add(new Edge(destination, weight));
        if(!isDirected) {
            adjacencyList.get(destination).add(new Edge(source, weight));
        }
    }

    @Override
    public int getWeight(String source, String destination) {
        // Return weight of edge between source and destination
        if(!adjacencyList.containsKey(source)) {
            return -1;
        }
        List<Edge> destinations = adjacencyList.get(source);
        for(Edge edge: destinations) {
            if(edge.destination.equals(destination)){
                return edge.weight;
            }
        }
        return -1;
    }

    @Override
    public boolean hasEdge(String source, String destination) {
        // Check if edge exists between source and destination
        if(!adjacencyList.containsKey(source)) {
            return false;
        }

        List<Edge> destinations = adjacencyList.get(source);
        for(Edge edge: destinations) {
            if(edge.destination.equals(destination)){
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> getNeighbors(String vertex) {
        // Return list of all vertices connected to given vertex
        if(!adjacencyList.containsKey(vertex)) {
            return null;
        }
        ArrayList<String> neighbors = new ArrayList<>();
        for(Edge edge : adjacencyList.get(vertex)) {
            neighbors.add(edge.destination);
        }

        return neighbors;
    }

    @Override
    public int getVertexCount() {
        // Return number of vertices in graph
        return adjacencyList.size();
    }

    @Override
    public boolean isDirected() {
        // Return whether graph is directed
        return isDirected;
    }
}