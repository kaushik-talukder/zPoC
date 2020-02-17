package csvutil;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParseBopisBudget {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Reader reader = Files.newBufferedReader(Paths.get("C:\\talka001\\FY20BOPIS.csv"));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			String[] fisWk = { "wk", "2020-02-08", "2020-02-15", "2020-02-22", "2020-02-29", "2020-03-07", "2020-03-14",
					"2020-03-21", "2020-03-28", "2020-04-04", "2020-04-11", "2020-04-18", "2020-04-25", "2020-05-02",
					"2020-05-09", "2020-05-16", "2020-05-23", "2020-05-30", "2020-06-06", "2020-06-13", "2020-06-20",
					"2020-06-27", "2020-07-04", "2020-07-11", "2020-07-18", "2020-07-25", "2020-08-01", "2020-08-08",
					"2020-08-15", "2020-08-22", "2020-08-29", "2020-09-05", "2020-09-12", "2020-09-19", "2020-09-26",
					"2020-10-03", "2020-10-10", "2020-10-17", "2020-10-24", "2020-10-31", "2020-11-07", "2020-11-14",
					"2020-11-21", "2020-11-28", "2020-12-05", "2020-12-12", "2020-12-19", "2020-12-26", "2021-01-02",
					"2021-01-09", "2021-01-16", "2021-01-23", "2021-01-30" };
			List<CSVRecord> csvList = csvParser.getRecords();
			for (int i = 0; i < csvList.size(); i++) {
				CSVRecord csvRecord = csvList.get(i);
				if (i == 0)
					continue;
				for (int j = 0; j < csvRecord.size(); j++) {
					if (j == 0)
						continue;
					BopisBudget bb = new BopisBudget(Integer.parseInt(csvRecord.get(0)), fisWk[j],
							Integer.parseInt(csvRecord.get(j)));
					System.out.println(bb.getStoreId() + "," + bb.getFiscalWeek() + "," + bb.getBudget());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}