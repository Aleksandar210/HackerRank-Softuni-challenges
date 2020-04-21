package OrganismExam;

import java.util.LinkedHashMap;
import java.util.Map;

public class Organism {
private String name;
private Map<String,Cluster> clusterCollection;

public Organism(String name) {
	setName(name);
	clusterCollection = new LinkedHashMap<String,Cluster>();
	
}

public void addCluster(String id, int rows, int cols) {
	Cluster currentCluster = new Cluster(id,rows,cols);
	this.clusterCollection.putIfAbsent(currentCluster.getId(), currentCluster);
}

public void addCell(String clusterId,String cellType,String cellid,
		int health,int row, int cols, int additional) {
	
	if(this.clusterCollection.containsKey(clusterId)) {
		Cell currentCell;
				switch(cellType.toLowerCase()) {
				case "redbloodcell":
					currentCell = new RedBloodCell(cellid,health,row,cols,additional);
					break;
				case 
				}
				
		this.clusterCollection.get(clusterId).addCellToBody(row, cols,);
	}
}

private void setName(String name) {
	this.name = name;
}

public String getName() {
	return this.name;
}


}
