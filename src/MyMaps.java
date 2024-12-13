public class MyMaps {
    //  Create a map of your campus or city
    // Requirements:
    // 1. Minimum of 10 locations (vertices)
    // 2. Connect locations with appropriate paths/roads (edges)
    // 3. Add weights representing distances or travel times
    // 4. Implement the map using both graph representations
    // 5. Demonstrate that both implementations produce identical results (Check main for that)

    private String[] locations;
    private Graph graph;
     enum AdjacencyType {
        MATRIX, LIST
    }

    public MyMaps(AdjacencyType adjacencyType, boolean weighted) {
        locations = new String[]{"Drawbridge", "Moat", "Ballroom", "Dungeons", "Dining Room", "Kitchen", "Garden",
                "Winding Staircase", "Bedroom 1", "Bedroom 2", "Library", "Bathroom"};

        switch (adjacencyType) {
            case LIST:
                graph = new AdjacencyListGraph(false);
                break;
            case MATRIX:
                graph = new AdjacencyMatrixGraph(false);
                break;
        }

        for(String location: locations) {
            graph.addVertex(location);
        }
        if(weighted){
            addWeightedLocations();
        } else {
            addUnweightedLocations();
        }


    }

    private void addUnweightedLocations() {
         graph.addEdge("Moat", "Drawbridge");
         graph.addEdge("Drawbridge", "Ballroom");
         graph.addEdge("Moat", "Garden");
         graph.addEdge("Ballroom", "Dining Room");
         graph.addEdge("Dining Room", "Kitchen");
         graph.addEdge("Ballroom", "Winding Staircase");
         graph.addEdge("Dining Room", "Winding Staircase");
         graph.addEdge("Winding Staircase", "Dungeons");
         graph.addEdge("Winding Staircase", "Library");
         graph.addEdge("Library", "Bedroom 1");
         graph.addEdge("Library", "Bedroom 2");
         graph.addEdge("Bedroom 1", "Bathroom");
         graph.addEdge("Bedroom 2", "Bathroom");
    }

    private void addWeightedLocations() {
        graph.addWeightedEdge("Moat", "Drawbridge", 5);
        graph.addWeightedEdge("Drawbridge", "Ballroom", 3);
        graph.addWeightedEdge("Moat", "Garden", 8);
        graph.addWeightedEdge("Ballroom", "Dining Room", 2);
        graph.addWeightedEdge("Dining Room", "Kitchen", 2);
        graph.addWeightedEdge("Ballroom", "Winding Staircase", 3);
        graph.addWeightedEdge("Dining Room", "Winding Staircase", 4);
        graph.addWeightedEdge("Winding Staircase", "Dungeons", 7);
        graph.addWeightedEdge("Winding Staircase", "Library", 6);
        graph.addWeightedEdge("Library", "Bedroom 1", 5);
        graph.addWeightedEdge("Library", "Bedroom 2", 5);
        graph.addWeightedEdge("Bedroom 1", "Bathroom", 2);
        graph.addWeightedEdge("Bedroom 2", "Bathroom", 3);

    }

    public void printLocations() {
         for(String location : locations) {
             for(String vertex : graph.getNeighbors(location)) {
                 System.out.println(location + ": " + vertex + " : " + graph.getWeight(location, vertex));
             }

         }
    }










}
