import java.io.File;

public class CSVParser {
  File csvFile;
  char separator;
  String header;

  CSVParser(File csvFile, char separator){
    this.csvFile = csvFile;
    this.separator = separator;
  }


}
