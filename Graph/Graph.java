class Graph
{
private final int size = 20;
private Vertex vertexList[]; // array of vertices
private int adjMat[][]; // adjacency matrix
private int vertcies; // current number of vertices
public Graph(){
vertexList = new Vertex[size];
// adjacency matrix
adjMat = new int[size][size];
} 

public void addVertex(Vertex v) // argument is label
{
    if(vertcies < vertexList.length){
        vertexList[vertcies++] = v;
    }
}
public void addEdge(int from, int to)
{
adjMat[from][to] = 1;
adjMat[to][from] = 1;
}
public void displayVertex(int [][]aMat)
{
    for(int i=0; i<adjMat.length; i++){
        for(int j=0; j<adjMat[i].length; i++){
        System.out.print(adjMat[i][j] + " ");
    }
    }
    System.out.println();
}
} 