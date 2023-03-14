import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Graph {
	HashMap<Integer, Vertex> _vertices = new HashMap<>();
	
	public void addVertex(Vertex vertex)
	{
		_vertices.put(vertex.getId(), vertex);
	}
	
	//MA #8 TODO: IMPLEMENT!
	public HashMap<Vertex, Integer> computeShortestPath(Vertex start)
	{
		//holds known distances
		HashMap<Vertex, Integer> distances = new HashMap<>();
		
		
		//underlying heap
		PriorityQueue<Vertex> dijkstra_queue = new PriorityQueue<>(new PathWeightComparator());
		
		//reset start's path weight
		
		
		int V=_vertices.size();
		HashSet<Vertex> vis= new HashSet<>();
		
		for (int a:_vertices.keySet()) {
			distances.put(_vertices.get(a),Integer.MAX_VALUE);
		}
		//make sure that the starting vertex is in the graph
	
	
			//push on starting vertex
		start.setPathWeight(0);
			
		dijkstra_queue.add(start);
		distances.put(start,0);
		
		
	
			//while queue not empty
		
		while (vis.size()!=V) {
			if (dijkstra_queue.isEmpty())
				return distances;
			
			Vertex vi=dijkstra_queue.remove();
			if (vis.contains(vi))
				continue;
			
				vis.add(vi);
			childeren(dijkstra_queue,distances,vis,vi);
		}
		
		
				//push on outgoing edges that haven't been discovered
				
				
				//Top of heap not known (in distances)?
				
					//make known
					
					
					//push on outgoing edges
					
						
						//not known? add to heap
						
		
		return distances;
	}
	void childeren (PriorityQueue<Vertex> dijkstra_queue, HashMap<Vertex, Integer> distances, 
			HashSet<Vertex> vis, Vertex vi) {

				int ed = -1;
		        int n = -1;

				for(Vertex v: vi.getEdges().keySet()) {
				if(!vis.contains(v)) {
						ed = vi.getEdgeWeight(v);
		                n = distances.get(vi) + ed;

				if (n < distances.get(v)) {
							distances.put(v, n);}

						v.getEdges().put(vi, distances.get(v));

						dijkstra_queue.add(v);
					}
				}
}
}
