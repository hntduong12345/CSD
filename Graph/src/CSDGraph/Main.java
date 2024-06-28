package CSDGraph;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[])
    {
        int vertices = 9;
        String label[]={"A","B","C","D","E","F","G","H","I"};
        int[][] inputGraph = {{0,4,0,0,0,0,0,8,0},
                              {4,0,8,0,0,0,0,11,0},
                              {0,8,0,7,0,4,0,0,2},
                              {0,0,7,0,9,14,0,0,0},
                              {0,0,0,9,0,10,0,0,0},
                              {0,0,4,14,10,0,2,0,0},
                              {0,0,0,0,0,2,0,1,6},
                              {8,11,0,0,0,0,1,0,7},
                              {0,0,2,0,0,0,6,7,0}};
        Graph graph = new Graph(inputGraph,label);
        graph.printGraph();
        
        int userChoice;
        boolean cont = true;
        do{
            System.out.println("---GRAPH PROGRAM---");
            System.out.println("1.Breadth-First Search.");
            System.out.println("2.Depth-First Search.");
            System.out.println("3.Find shortest path.");
            System.out.println("Other. Quit.");
            System.out.print("Choice:");
            userChoice = Integer.parseInt(sc.nextLine());
            
            switch(userChoice){
                case 1:
                    String startVertice;
                    System.out.print("Insert start vertice: ");
                    startVertice = sc.nextLine().trim();
                    System.out.print("Breadth-First Search: ");
                    graph.BFS(takeIndex(startVertice, label));
                    System.out.println("");
                    break;
                case 2:
                    String startVertice2;
                    System.out.print("Insert start vertice: ");
                    startVertice2 = sc.nextLine().trim();
                    System.out.print("Deapth-First Search: ");
                    graph.depth(takeIndex(startVertice2, label));
                    System.out.println("");
                    break;
                case 3:
                    String start, destination;
                    System.out.print("Insert start vertice: ");
                    start = sc.nextLine().trim();
                    System.out.print("Insert destination vertice: ");
                    destination = sc.nextLine().trim();
                    graph.dijkstra(takeIndex(start, label), takeIndex(destination, label));
                    break;
                default: System.out.println("Program end.");
            }
        }while(userChoice>0 && userChoice<4);
    }
    
    public static int takeIndex(String str, String[] label){
        for(int i=0; i<label.length; i++)
            if(str.equalsIgnoreCase(label[i]))
                return i;
        return -1;
    }
}
