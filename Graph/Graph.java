class Graph
{
    Vertex vertList[];
    int adjM[][];
    int vertices;
    public Graph(int size){
       vertList = new Vertex[size];
       adjM = new int[size][size];
       
   }
   void addVert(Vertex v){
       if(vertices < vertList.length){
           vertList[vertices] = v;
           vertices++;
       }
   }
   void addEdge(int from, int to){
       if(from < vertices && to < vertices){
           adjM[from][to] = 1;
           adjM[to][from] = 1; //undirected graph
       }
   }
   void displayAdjM(){
       //cols
       for(int i=0; i<vertices; i++){
           //rows
           for(int j=0; j<vertices; j++){
               System.out.print(" "+adjM[i][j]);
           }
           System.out.println(" ");
       }
       System.out.println();
   }

    public static void main(String args[]){
        Graph g = new Graph(10);
        g.addVert(new Vertex('A')); //0
        g.addVert(new Vertex('B')); //1
        g.addVert(new Vertex('C')); //2
        g.addVert(new Vertex('D')); //3
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(0, 3);
        g.addEdge(0, 2);
        g.displayAdjM();
        }   
} 