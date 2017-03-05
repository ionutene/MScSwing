package project;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RouteVerification {

    private Set<Set<String>> finalCombinations;
    private Map<String, Set<String>> routePossibilities;

    public RouteVerification(Set<Set<String>> finalCombinations, Map<String, Set<String>> routePossibilities) {
        this.finalCombinations = finalCombinations;
        this.routePossibilities = routePossibilities;
    }

    public void doRouteVerifications() {
        for (Set<String> combination : finalCombinations) {
            Set<String> containerSet = new LinkedHashSet<>();
            Set<String> combinationClone = new LinkedHashSet<>(combination);
            for (String key : combination) {
                containerSet.addAll(routePossibilities.get(key));
            }
            Set<String> containerSetClone = new LinkedHashSet<>(containerSet);
            if (!containerSetClone.retainAll(combinationClone)) {
                System.out.println(combination + " is possible!");
            } else {
                System.out.println("Combinations: " + combination);
                System.out.println("Possibilities: " + containerSet);
            }
        }
    }
}
