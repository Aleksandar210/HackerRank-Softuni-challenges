package advanced_Softuni;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdvancedExperiments {

public static void main(String[] args) {
	
	Map<String,Integer> map = new HashMap<String,Integer>();
	
	map.put("A", 1);
	map.put("B", 2);
	map.put("C", 3);
	
	Map<String,Integer> newMap = sortMap(map);
	for(Map.Entry<String, Integer>mapster:newMap.entrySet()) {
		System.out.println(mapster.getKey()+" "+mapster.getValue());
	}
	
}



static LinkedHashMap<String,Integer> sortMap(Map<String,Integer> singerRevenue) {
	
	
	LinkedHashMap<String, Integer> newMap=
	singerRevenue.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));
	return newMap;
}

}
