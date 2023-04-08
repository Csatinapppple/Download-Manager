import java.io.InputStream;
import java.lang.StringBuilder;
import java.net.URL;
import java.nio.file.*;

class Main
{

  public static void downloadFile(URL url, String filename) throws Exception
  {
    try (InputStream in = url.openStream()){
      Files.copy(in, Paths.get(filename));
    }
  }

  static String getFilenameReverse(String url){
    String ret = "";
    for(int i = url.length()-1; i>=0;i--){
      if(url.charAt(i)!='/')
        ret+=url.charAt(i);
      else
        break;
    }
    return ret;
  }

  //nexuiz in brazil https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[]args) throws Exception{
    if(args.length != 1){
      printUsage();
      return;
    }
    URL url = new URL(args[0]);
    StringBuilder filename = new StringBuilder(
      getFilenameReverse(args[0])).reverse();
    downloadFile(url, filename.toString());
  }

  static void printUsage(){
    System.out.printf("Usage: program url\n");
  }
}