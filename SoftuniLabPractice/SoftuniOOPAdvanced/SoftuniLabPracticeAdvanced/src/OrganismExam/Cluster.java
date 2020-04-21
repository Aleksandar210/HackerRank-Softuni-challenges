package OrganismExam;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cluster {
	private int clusterPosition;
	private String id;
	private int rows;
	private  int cols;
	private Cell[][] currentCells;
	private Map<String,Integer> cellStats;
	private Map<String,LinkedList<Cell>> currentCellsInCluster;
	
	
	public Cluster(String id, int rows, int columns) {
		cellStats = new LinkedHashMap<String,Integer>();
		currentCells = new Cell[rows][cols];
		currentCellsInCluster = new LinkedHashMap<String,LinkedList<Cell>>();
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
	
	public void setPosition(int p) {
		this.clusterPosition = p;
	}
	
	public int getPosition() {
		return this.clusterPosition;
	}
	
	
	
	
	public void showClusterStats() {
		System.out.println();
		for(Map.Entry<String, Integer> entry:this.cellStats.entrySet()) {
			System.out.println(entry.getKey()+ " -> "+entry.getValue());
		}
		
	}
	
	public void showAllCells() {
		System.out.println();
		for(Map.Entry<String, LinkedList<Cell>> entry:this.currentCellsInCluster.entrySet()) {
			System.out.println(entry.getKey());
			for(Cell curr:entry.getValue()) {
				System.out.println(curr);
			}
			System.out.println("-----------------------------");
		}
	}
	
	
	
	
	public Cell getCell(int row, int col) {
		return this.currentCells[row][col];
	}
	
	
	
	public void addCellToBody(int row, int col, Cell currentCell) {
		this.currentCells[row][col] = currentCell;
		if(this.cellStats.containsKey(currentCell.getClass().getSimpleName())) {
			this.cellStats.put(currentCell.getClass().getSimpleName(), this.cellStats.get(currentCell.getClass().getSimpleName())+1);
			this.currentCellsInCluster.get(currentCell.getClass().getSimpleName()).add(currentCell);
		}else {
			this.cellStats.put(currentCell.getClass().getSimpleName(),0);
			this.currentCellsInCluster.put(currentCell.getClass().getSimpleName(), new LinkedList<Cell>());
		}
		
	}
	
	
	
	
	

}
