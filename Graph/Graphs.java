import queue.*;

public class Graphs
{
	Vertex vertList [];
	int adjM [][];
	int vertices; 
	Stack stack ;
	Queue que;/////////
	
	//  constructor 
 public Graphs (int size)
 {
	 vertList = new Vertex[size];
	 adjM = new int [size][size];
	 stack = new Stack(size);
	 que = new Queue();
 }
 
 
 // insert methods 
 void addVertex (Vertex v )
 {
	 if(vertices < vertList.length)
	 {
	 vertList [vertices] = v;
	 vertices ++;
	 }
 }
 
 void addEdge(int from, int to)
 {
	 if (from < vertList.length && to < vertList.length)
	 {
	 adjM[from][to] = 1;
	  adjM[to][from] = 1; // this is for the undirected graphs 
	 }
 }
 
 // display method 
 void display() 
 {
	    for (int i = 0; i < vertices; i++) 
	    {
	        System.out.print(vertList[i].label);
	        for (int j = 0; j < vertices; j++) 
	        {
	            System.out.print(" " + adjM[i][j] );
	        }
	        System.out.println(' ');
	    }
	    System.out.println();
	}
 
 
 // dfs method 
 void dfs()
 {
	 vertList [0].visited = true;
	 displayVert(0);
	 stack.push(0);
	 while (!stack.isEmpty())
	 {
		 int v = stack.peek();
		 int v2 = getAdjVert(v);
		 if (v2==-1)
			 stack.pop();
		 else
		 {
			 vertList[v2].visited= true;
			 displayVert(v2);
			 stack.push(v2);
		 }
	 }
	 System.out.println();
	 for (int i=0; i<vertices;i++)
	 {
		 vertList[i].visited = false;
	 }
 }
 
int getAdjVert(int index)
 {
	 for (int i=0; i< vertices; i++)
	 {
		 if (adjM[index][i] ==1 && vertList[i].visited==false)
			 return i;
	 }
	return -1;
 }
 
 void displayVert(int index)
 {
	 System.out.println(" " + vertList[index].label);
 }
 
 
 
 // bfs method 
 void bfs()
 {
	 vertList [0].visited = true;
	 displayVert(0);
	 que.enqueue(0);
	 while (!que.isEmpty())
	 {
		 int v = que.dequeue();
		 int v2 = getAdjVert(v);
		 while (v2!=-1)
		 {
			 vertList[v2].visited= true;
			 displayVert(v2);
			 que.enqueue(v2);
			 v2= getAdjVert(v);
		 }
	 }
	 System.out.println();
	 for (int i=0; i<vertices;i++)
	 {
		 vertList[i].visited = false;
	 }
 }
 
 
 // mst method 
 
 void MST()
 {
	 vertList[0].visited = true;
	 stack.push(0);
	 while (!stack.isEmpty())
	 {
		 int v = stack.peek();
		 int v2 = getAdjVert(v);
		 
		 if (v2==-1)
			 stack.pop();
		 else 
		 {
			 vertList[v2].visited=true;
			 stack.push(v2);
			 displayVert(v);
			 System.out.println("...>");
			 displayVert(v2); 
		 }
	 }
	 System.out.println();
	 for (int i=0; i<vertices;i++)
	 {
		 vertList[i].visited = false;
	 }
 }
 public static void main (String args[])
 {
	 Graphs g = new Graphs (10);
	 g.addVertex(new Vertex ('A'));//0
	 g.addVertex(new Vertex ('B'));
	 g.addVertex(new Vertex ('C'));
	 g.addVertex(new Vertex ('D'));
	 g.addEdge(0, 1); //a-b
	 g.addEdge(3, 1); // d-b
	 g.addEdge(0, 3); // a-d
	 g.addEdge(0, 2); // a-c
	 g.addEdge(2, 4); // c-e
	 g.addEdge(3, 2); // d-c
	 g.addEdge(3, 4); // d-e
	 
	 g.display();
	 
	 System.out.println("DFS:" );
	 g.dfs();
	 
	  System.out.println("BFS:" );
	  g.bfs();
	  
	  System.out.println("MST:" );
	  g.MST();
		
	  
 }
}
