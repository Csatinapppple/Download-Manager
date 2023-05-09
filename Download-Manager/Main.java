import java.io.*;
import java.lang.StringBuilder;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

class Main {
  static String default_directory = System.getProperty("user.home"+"/Downloads");

  // nexuiz in brazil
  // https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[] args) throws IOException {
    
    if (FileTools.createFile("history.csv"))
      createCSV();

    if (args.length == 1)
      staticDownload(args[0]);
		else
			printUsage();
  }

	static final void printUsage();{
		System.out.println("usage: java Main -DOWNLOADURL");
	}

  //0  +2 +3 -1 +11 -8 +23 -19
  //13,15,18,17, 28,20, 43, 24,x

  /*
    7 6 5 4 3 2 1
   */

  static void staticDownload(String url) throws IOException {
    Downloader d = new Downloader("", url);
    d.downloadFile();
    FileTools.appendFile(d.toString(), "history.csv");    
    System.exit(0);
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