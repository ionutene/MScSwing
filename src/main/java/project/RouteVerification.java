package project;

import java.util.*;

public class RouteVerification {

	private Set<Set<String>> finalCombinations;
	private Map<String, Set<String>> routePossibilities;
	private static int index = 1;

	public RouteVerification(Set<Set<String>> finalCombinations, Map<String, Set<String>> routePossibilities) {
		this.finalCombinations = finalCombinations;
		this.routePossibilities = routePossibilities;
	}

	public ArrayList<String> doRouteVerifications() {
		ArrayList<String> returnValue= new ArrayList<>();
		for (Set<String> combination : finalCombinations) {
			Set<String> containerSet = new LinkedHashSet<>();
			Set<String> combinationClone = new LinkedHashSet<>(combination);
			for (String key : combination) {
				containerSet.addAll(routePossibilities.get(key));
			}
			Set<String> containerSetClone = new LinkedHashSet<>(containerSet);
			containerSetClone.retainAll(combinationClone);
//            System.out.println("=================================================");
			if (containerSetClone.size() == 0) {
				System.out.println(index++ + ". "+combination + " is possible!");
			returnValue.add(combination.toString());
			} else {
			   /* System.out.println("Combinations: " + combination);
                System.out.println("Possibilities: " + containerSet);
                System.out.println("Resulting intersection: " + containerSetClone);*/
			}
//            System.out.println("=================================================");
		}
		return returnValue;
	}
}
