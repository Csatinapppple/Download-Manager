import java.io.InputStream;
import java.lang.StringBuilder;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

class Main
{
  String defaultDirectory;
  //nexuiz in brazil https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[]args) throws Exception{
    int input=0;
    Scanner s = new Scanner(System.in);
    while(input!=3){
      printOptions();
      input = s.nextInt();
      handleChoices(input);
    }
  }
  
  static void handleChoices(int choice) throws Exception{
    Scanner s = new Scanner(System.in);
    switch(choice){
      case 1:
        Downloader download = new Downloader("",s.next());
        download.downloadFile();
        if(download.successful) System.out.println("Download Successful");
        else                    System.out.println("Download failed");
        break;
      default:
        break;
    }
  }

  static void printOptions(){
    System.out.println("1. Download from url");
    System.out.println("2. Print download history");
    System.out.println("3. Exit");
  }
}

/*
  Plans:
    assign directory to file type(image,video,pdf)
    checksum checker
    automatic restart if fail
*/