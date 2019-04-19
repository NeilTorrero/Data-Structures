package Graphs;

public class Graph {
    private List<Vertex> adjacencyList;

    public Graph() {
        adjacencyList = new List<Vertex>();
    }

    public void insertVertex (Vertex newvertex) {
        adjacencyList.add(newvertex);
    }

    public void insertEdge (Vertex v1, Vertex v2) {
        adjacencyList.get(v1).relations.add(v2);
    }

    public void removeVertex (Vertex vertex) {
        adjacencyList.remove(vertex); // TODO: 2019-04-19 revisar que tots el edges que es comunicaven amb aquest siguin eliminats
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (int j = 0; j < adjacencyList.get(i).relations.size(); j++) {
                if (adjacencyList.get(i).relations.get(j).equals(vertex)){
                    adjacencyList.get(i).relations.remove(vertex);
                }
            }
        }
    }

    public void removeEdge (Vertex v1, Vertex v2) {
        adjacencyList.get(v1).relations.remove(v2);
    }

    public void visualize() {

    }
    //List<List<Vertex>> graph;
    //directed graph implemented via Adjacency list
}