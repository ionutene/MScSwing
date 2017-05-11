package project;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		try {
			long now = System.currentTimeMillis();
			Map<String, Set<String>> formulas = CSVParser.readCSV();
			Combinations combinations = new Combinations(formulas.keySet());
			combinations.doAllNonRepetitiveCombinationsBetweenIndices(5, 6);
			RouteVerification routeVerification = new RouteVerification(combinations.getFinalElements(), formulas);
			routeVerification.doRouteVerifications();
			System.out.println("Totul a durat: " + (System.currentTimeMillis() - now) + " ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
