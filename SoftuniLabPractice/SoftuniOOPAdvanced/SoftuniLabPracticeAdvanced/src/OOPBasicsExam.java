import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import OrganismExam.Cell;
import OrganismExam.Organism;
import OrganismExam.RedBloodCell;

public class OOPBasicsExam {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	//organismTask();
	}
	
	
	
	static void nfsTask() {
		
	}
	
	
	
	
	
	
static void organismTask() {
	Map<String,Organism> organisms = new HashMap<String,Organism>();
	
	String enterCommand= "";
	do {
		enterCommand = scan.nextLine();
		if(enterCommand.equalsIgnoreCase("Beer is coming")) {
			break;
		}else {
			String[] commands = enterCommand.split("\\s+");
			executeCommandOrganism(commands,organisms);
		}
	}while(!enterCommand.equalsIgnoreCase("Beer is coming"));
}

static void executeCommandOrganism(String[] commands,Map<String,Organism> org) {
	switch(commands[0].toLowerCase()) {
	case "checkcondition":
		org.get(commands[1]).checkCondition();
		break;
	case "createorganism":
		org.putIfAbsent(commands[1], new Organism(commands[1]));
		break;
	case "addcluster":
	if(org.get(commands[1])==null) {
		
	}else {
		if(org.get(commands[1]).addCluster(commands[2], Integer.parseInt(commands[3]), Integer.parseInt(commands[4]))==true) {
			System.out.println("Organism: "+commands[1]+"created Cluster: "+commands[2]);
		}
		
	}
		break;
	case "addcell":
		if(org.get(commands[1]).addCell(commands[2], commands[3], commands[4], Integer.parseInt(commands[5]), Integer.parseInt(commands[6]), Integer.parseInt(commands[7]), Integer.parseInt(commands[8]))) {
			System.out.println("Organism: "+commands[1]+" Cluster: "+commands[2]+" added cell: "+commands[4]);
		}else {
			
		}
		break;
	case "activatecluster":
		org.get(commands[1]).activateCluster();
		
		break;
		
		
	}
}


}
