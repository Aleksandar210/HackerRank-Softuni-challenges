import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import OrganismExam.Cell;
import OrganismExam.Organism;
import OrganismExam.RedBloodCell;

public class OOPBasicsExam {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	
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
		
		break;
	}
}


}
