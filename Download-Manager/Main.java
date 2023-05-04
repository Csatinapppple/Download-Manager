import java.io.*;
import java.lang.StringBuilder;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

class Main {
  String defaultDirectory = "";

  // nexuiz in brazil
  // https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[] args) throws IOException {
    
    if (FileTools.createFile("history.csv"))
      createCSV();

    if (args.length == 1)
      staticDownload(args[0]);

    int input = 0;
    Scanner s = new Scanner(System.in);
    while (input != 3) {
      printOptions();
      input = s.nextInt();
      handleChoices(input);
    }
  }

  static void handleChoices(int choice) throws IOException {
    Scanner s = new Scanner(System.in);
    switch (choice) {
      case 1:
        Downloader download = new Downloader("", s.next());
        download.downloadFile();
        FileTools.appendFile(download.toString(),"history.csv");
        break;
      case 2:
        break;
      default:
        break;
    }
  }
  //0  +2 +3 -1 +11 -8 +23 -19
  //13,15,18,17, 28,20, 43, 24,x

  /*
    7 6 5 4 3 2 1
   */
  static void printOptions() {
    System.out.println("1. Download from url");
    System.out.println("2. Print download history");
    System.out.println("3. Exit");
  }

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