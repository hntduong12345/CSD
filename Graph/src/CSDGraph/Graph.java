package CSDGraph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    int vertices;
    int graphList[][];
    String label[];
    
    public Graph(int vertices, String[] label) {
        this.vertices = vertices;
        graphList = new int[vertices][vertices];
        this.label = label;
    }

    public Graph(int[][] graphList, String[] label) {
        this.graphList = graphList;
        this.vertices = graphList.length;
        this.label = label;
    }

    public void addEdge(int source, int destination, int weight) {
        graphList[source][destination] = weight;
        graphList[destination][source] = weight;
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graphList[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[vertices];
        int n, a = 0;
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            n = queue.poll();
            System.out.print(label[n] + " ");

            for (int i = 0; i < vertices; i++) {
                if (graphList[n][i] != 0) {
                    if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    }
                }
            }
        }
    }
    
    void dijkstra(int startVertex, int destination){
        int nVertices = vertices;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = -1;

        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++) {

            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] &&
                    shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as
            // processed
            if(nearestVertex != -1){
                added[nearestVertex] = true;

                // Update dist value of the
                // adjacent vertices of the
                // picked vertex.
                for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                    int edgeDistance = graphList[nearestVertex][vertexIndex];

                    if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                        parents[vertexIndex] = nearestVertex;
                        shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                    }
                }
            }
        }
        //Print result to file.
        System.out.println("Shortest Path from "+startVertex+" to "+destination+": "+shortestDistances[destination]);
        System.out.print("Path: ");
        Stack st = new Stack();
        int path = destination;
        
        do{
            st.push(path);
            path = parents[path];
        }while(path != -1);
        
        while(!st.isEmpty()){
            int index = st.pop();
            System.out.print(label[index]+" ");
        }
        System.out.println("");
    }
    
    
    
    void depth(boolean [] visited,int k){
        System.out.print(label[k]+" ");;visited[k]=true;
    for(int i=0;i<vertices;i++) {
      if(!visited[i] && graphList[k][i]>0) depth(visited,i);
     }
   }
  void depth(int k) {
    boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<vertices;i++) visited[i]=false;
    depth(visited,k);
    for(i=0;i<vertices;i++) 
       if(!visited[i]) depth(visited,i);
   }
}
