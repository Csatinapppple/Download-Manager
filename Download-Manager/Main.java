import java.io.*;
import java.lang.StringBuilder;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

class Main {
  String defaultDirectory = "";

  // nexuiz in brazil
  // https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[] args) throws Exception {

    if (FileTools.createFile("history.csv"))
      ;

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

  static void handleChoices(int choice) throws Exception {
    Scanner s = new Scanner(System.in);
    switch (choice) {
      case 1:
        Downloader download = new Downloader("", s.next());
        download.downloadFile();
        appendCSV(download.toString());
        break;
      case 2:
        break;
      default:
        break;
    }
  }

  static boolean appendCSV(String input) {
    boolean ret = false;

    return ret;
  }

  static void printOptions() {
    System.out.println("1. Download from url");
    System.out.println("2. Print download history");
    System.out.println("3. Exit");
  }

  static void staticDownload(String url) throws Exception {
    Downloader d = new Downloader("", url);
    d.downloadFile();
    System.exit(0);
  }
}

/*
 * Plans:
 * assign directory to file type(image,video,pdf)
 * checksum checker
 * automatic restart if fail
 */
