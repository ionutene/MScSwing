package project;

import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class CSVParser {

	private static final String CSV_FILENAME = "/file.txt";
	static Map<String, String> row;
	static Map<String, Set<String>> formulas = new HashMap<>();
	static Map<String, Set<String>> result = new LinkedHashMap<>();
	static Map<String, Set<String>> resultTakeTwo = new LinkedHashMap<>();
	static String[] headers = null;

	public static Map<String, Set<String>> readWithCsvMapReader() throws IOException {
		ICsvMapReader mapReader = null;
		InputStream io = CSVParser.class.getResourceAsStream(CSV_FILENAME);
		Reader featIO = new InputStreamReader(io);
		try {
			mapReader = new CsvMapReader(featIO, CsvPreference.TAB_PREFERENCE);

			// the header columns are used as the keys to the Map

			headers = mapReader.getHeader(true);
//            final CellProcessor[] processors = getProcessors();

			while ((row = mapReader.read(headers)) != null) {
				System.out.println(String.format("lineNo=%s, rowNo=%s, row=%s",
						mapReader.getLineNumber(), mapReader.getRowNumber(), row));
				for (String header : headers) {
//                    System.out.println(header + " is " + row.get(header));
					if (formulas.get(header) != null) {
						Set<String> oldKeys = formulas.get(header);
						if (row.get(header).equalsIgnoreCase("x")) {
							oldKeys.add(headers[(mapReader.getRowNumber() - 2)]);
						}
						formulas.put(header, oldKeys);
					} else {
						Set<String> newKeys = new HashSet<>();
						if (row.get(header).equalsIgnoreCase("x")) {
							newKeys.add(headers[(mapReader.getRowNumber() - 2)]);
						}
						formulas.put(header, newKeys);
					}
				}
			}

		} finally {
			if (mapReader != null) {
				mapReader.close();
			}
			for (String header : headers) {
				Set<String> orderSet = new LinkedHashSet<>();
				Set<String> foundKeys = formulas.get(header);
				for (String key : headers) {
					if (foundKeys.contains(key)) {
						orderSet.add(key);
					}
				}
				result.put(header, orderSet);
			}

		}
		return result;
	}

	public static Map<String, Set<String>> readCSV() throws IOException {
		ICsvMapReader mapReader = null;
		InputStream io = CSVParser.class.getResourceAsStream(CSV_FILENAME);
		Reader featIO = new InputStreamReader(io);
		try {
			mapReader = new CsvMapReader(featIO, CsvPreference.TAB_PREFERENCE);

			// the header columns are used as the keys to the Map

			headers = mapReader.getHeader(true);
//            final CellProcessor[] processors = getProcessors();

			while ((row = mapReader.read(headers)) != null) {
				/*System.out.println(String.format("lineNo=%s, rowNo=%s, row=%s",
                        mapReader.getLineNumber(), mapReader.getRowNumber(), row));*/
				Set<String> allRowPossibilities = new LinkedHashSet<>();
				for (String header : headers) {
					if (row.get(header).equalsIgnoreCase("x")) {
						allRowPossibilities.add(header);
					}
				}
				resultTakeTwo.put(headers[mapReader.getRowNumber() - 2], allRowPossibilities);
			}
		} finally {
			if (mapReader != null) {
				mapReader.close();
			}
		}
		return resultTakeTwo;
	}

	public static void main(String[] args) {
		try {
//            System.out.println(readCSV());
			Map<String, Set<String>> bolex = readCSV();
			bolex.keySet().stream().forEach(e -> System.out.println(e + "=" + bolex.get(e)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
