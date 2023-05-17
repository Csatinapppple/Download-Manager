import java.io.*;
import java.lang.StringBuilder;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

class Main {  
  static String default_directory = System.getProperty("user.home") + "/Downloads";

  //CSV Header enu
  static final int PATH = 0;
  static final int FILENAME = 1;
  static final int SOURCE = 2;
  static final int TIME_STARTED_DOWNLOADING = 3; 
  static final int SUCCESSFULL = 4;

  // nexuiz in brazil
  // https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[] args) throws IOException {

    if (FileTools.createFile("history.csv")){
      createCSV();
    }

    if (args.length == 0){
			printUsage();
    }else if(args[1]=="-p"){

      CSVParser csv_parser = new CSVParser(FileTools.getFileContents("history.csv"), ';');
      int[] headers = {PATH,FILENAME,TIME_STARTED_DOWNLOADING};
      csv_parser.printCSV(headers, 10);
    
    }else{
      staticDownload(args[args.length - 1]);
    }
  }

	static final void printUsage(){
		System.out.println("usage: java Main -DOWNLOADURL");
	}

  //0  +2 +3 -1 +11 -8 +23 -19
  //13,15,18,17, 28,20, 43, 24,x

  /*
    7 6 5 4 3 2 1
   */

  static void staticDownload(String url) throws IOException {
    Downloader d = new Downloader(default_directory, url);
    d.downloadFile();
    FileTools.appendFile(d.toString()+'\n', "history.csv");
  }

  

  static void createCSV(){
    String header = "path;filename;source;time_started_downloading;successful;\n";
    FileTools.appendFile(header, "history.csv");
  }
}

/*
 * Plans:
 * assign directory to file type(image,video,pdf)
 * checksum checker
 * automatic restart if fail
 */