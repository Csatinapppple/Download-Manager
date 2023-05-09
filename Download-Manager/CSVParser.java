import java.util.ArrayList;
import java.util.List;

class CSVParser {
  char separator;
  List<List<String>> csv_file;
  static int HEADER = 0;

  CSVParser(String raw_file, char separator){
    csv_file = parseCSV(raw_file);
    this.separator = separator;
  }

  List<List<String>> parseCSV(String raw_file){
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> line = new ArrayList<String>();
    String part="";

    for(int x = 0;x<raw_file.length();x++){
      if(raw_file.charAt(x)==separator){
        line.add(part);
        part="";
      }else if(raw_file.charAt(x)=='\n'){
        line.add(part);
        part="";
        ret.add(line);
        line.clear();
      }else{
        part+=raw_file.charAt(x);  
      }
    }

    return ret;
  }



  void printCSV(int[] headers,int start, int end){
    
    /*
      int[0<n<=header.length] Define the order and what headers to print
      Pick when to start printing, for example, at the last ten recent
      CSV lines ex: printCSV(csv_file.length()-10,csv_file.length())
     */

  }
}
