import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AdjacencyMatrixGraph implements Graph {
    private Map<String, Integer> vertexIndices;
    private int[][] weightMatrix;
    private boolean isDirected;
    private static final int INITIAL_CAPACITY = 10;
    private static int indexCount = 0;

    public AdjacencyMatrixGraph(boolean isDirected) {
        // Initialize the graph with proper data structures
        this.isDirected = isDirected;
        vertexIndices = new HashMap<>();
        weightMatrix = new int[INITIAL_CAPACITY][INITIAL_CAPACITY];
    }

    @Override
    public void addVertex(String vertex) {
        // Add vertex to the graph
        // Don't forget to resize matrices if necessary
        vertexIndices.put(vertex, indexCount);
        indexCount++;
        if(weightMatrix.length == indexCount-1) {
            resizeMatrix();
        }

    }

    private void resizeMatrix() {
        // Implement matrix resizing when capacity is reached
        int[][] newMatrix = new int[weightMatrix.length*2][weightMatrix.length*2];
        for(int i = 0; i < weightMatrix.length; i++){
            for(int j = 0; j < weightMatrix.length; j++) {
                newMatrix[i][j] = weightMatrix[i][j];
            }
        }
        weightMatrix = newMatrix;
    }

    @Override
    public void addEdge(String source, String destination) {
        // Add unweighted edge (default weight of 1)
        if(!vertexIndices.containsKey(source)){
            addVertex(source);
        }
        if(!vertexIndices.containsKey(destination)){
            addVertex(destination);
        }
        int sourceIndex = vertexIndices.get(source);
        int destinationIndex = vertexIndices.get(destination);
        weightMatrix[sourceIndex][destinationIndex] = 1;
        if(!isDirected) {
            weightMatrix[destinationIndex][sourceIndex] = 1;
        }

    }

    @Override
    public void addWeightedEdge(String source, String destination, int weight) {
        // TODO: Add edge with specified weight
        if(!vertexIndices.containsKey(source)){
            addVertex(source);
        }
        if(!vertexIndices.containsKey(destination)){
            addVertex(destination);
        }
        int sourceIndex = vertexIndices.get(source);
        int destinationIndex = vertexIndices.get(destination);
        weightMatrix[sourceIndex][destinationIndex] = weight;
        if(!isDirected) {
            weightMatrix[destinationIndex][sourceIndex] = weight;
        }

    }

    @Override
    public int getWeight(String source, String destination) {
        // Return weight of edge between source and destination
        if(!vertexIndices.containsKey(source)){
            return -1;
        }
        if(!vertexIndices.containsKey(destination)){
            return -1;
        }
        return weightMatrix[vertexIndices.get(source)][vertexIndices.get(destination)];
    }

    @Override
    public boolean hasEdge(String source, String destination) {
        // Check if edge exists between source and destination
        if(!vertexIndices.containsKey(source)){
            return false;
        }
        if(!vertexIndices.containsKey(destination)){
            return false;
        }
        if(weightMatrix[vertexIndices.get(source)][vertexIndices.get(destination)] > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> getNeighbors(String vertex) {
        // Return list of all vertices connected to given vertex
        int index = vertexIndices.get(vertex);
        List<String> list = new ArrayList<>();
        for(int i = 0; i<weightMatrix.length; i++){
            if(weightMatrix[index][i] > 0){
                for(String key : vertexIndices.keySet()) {
                    if(vertexIndices.get(key) == i) {
                        list.add(key);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public int getVertexCount() {
        // TODO: Return number of vertices in graph
        return vertexIndices.size();
    }

    @Override
    public boolean isDirected() {
        // TODO: Return whether graph is directed
        return isDirected;
    }
}