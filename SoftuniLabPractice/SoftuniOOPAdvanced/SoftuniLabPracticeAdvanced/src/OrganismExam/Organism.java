package OrganismExam;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Organism {
private String name;
private Map<String,Cluster> clusterCollection;
private LinkedList<Cluster> currentClustersInOrder;
private int clusterCount;
private int cellCount;


public Organism(String name) {
	setName(name);
	this.cellCount=0;
	this.clusterCount=0;
	clusterCollection = new LinkedHashMap<String,Cluster>();
	
}

public void addCluster(String id, int rows, int cols) {
	if(!this.clusterCollection.containsKey(id)) {
		this.clusterCount+=1;
	}
	Cluster currentCluster = new Cluster(id,rows,cols);
	this.clusterCollection.putIfAbsent(currentCluster.getId(), currentCluster);
}

public boolean  addCell(String clusterId,String cellType,String cellid,
		int health,int row, int cols, int additional) {
	Cell currentCell = null;
	if(this.clusterCollection.containsKey(clusterId)) {
		this.cellCount+=1;
					
				switch(cellType.toLowerCase()) {
				case "redbloodcell":
					  currentCell = new RedBloodCell(cellid,health,row,cols,additional);
					break;
				case "whitebloodcell":
					currentCell = new WhiteBloodCell(cellid,health,row,cols,additional);
					break;
					
				case "fungi":
					currentCell = new Fungi(cellid,health,row,cols,additional);
					break;
				case "bacteria":
					currentCell = new Bacteria(cellid,health,row,cols,additional);
					break;
				case "Virus":
					currentCell = new Virus(cellid,health,row,cols,additional);
					break;
					default:
						return false;
					
				}
				
				
		
				this.clusterCollection.get(clusterId).addCellToBody(row, cols,currentCell);
				return true;
	}else {
		return false;
	}
	
}

private void setName(String name) {
	this.name = name;
}

public String getName() {
	return this.name;
}

public void checkCondition() {
	System.out.println("Organism name: "+this.getName());
	System.out.println("Clusters: "+this.clusterCount);
	System.out.println("Cells: "+this.cellCount);
	
	for(Map.Entry<String, Cluster> entry:this.clusterCollection.entrySet()) {
		System.out.println(entry.getKey());
		entry.getValue().showAllCells();
	}
	
	
}



}
