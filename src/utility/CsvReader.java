package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

	public static List<String[]> readCsv(String filePath) {
		InputStream in = CsvReader.class.getResourceAsStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<String[]> data = new LinkedList<>();
		String rowData;
		try {
			while ((rowData = br.readLine()) != null) {
				String[] dataRecords = rowData.split(",");
				data.add(dataRecords);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
