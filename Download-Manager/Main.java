import java.io.InputStream;
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
  //nexuiz in brazil https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip
  public static void main(String[]args) throws Exception{
    URL url = new URL("https://razaoinfo.dl.sourceforge.net/project/nexuiz/NexuizRelease/Nexuiz%202.5.2/nexuiz-252.zip");
    downloadFile(url, "nexuiz.zip");
  }
}
