package OrganismExam;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cluster {
	private String id;
	private int rows;
	private  int cols;
	private Cell[][] currentCells;
	private Map<String,Integer> cellStats;
	
	
	public Cluster(String id, int rows, int columns) {
		cellStats = new LinkedHashMap<String,Integer>();
		currentCells = new Cell[rows][cols];
		setId(id);
		setRows(rows);
		setCols(cols);
		setClusterBody();
		
		
	}
	
	private void setClusterBody() {
		for(int i =0;i<this.rows;i++) {
			for(int j =0;j<this.cols;j++) {
				this.currentCells[i][j] = null;
			}
		}
	}
	
	private void setId(String id) {
		this.id = id;
	}
	
	private void setRows(int rows) {
		this.rows = rows;
	}
	
	private void setCols(int cols) {
		this.cols = cols;
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public void showClusterStats() {
		System.out.println();
		for(Map.Entry<String, Integer> entry:this.cellStats.entrySet()) {
			System.out.println(entry.getKey()+ " -> "+entry.getValue());
		}
		
	}
	
	

}
