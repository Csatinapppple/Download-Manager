import java.util.Date;
import java.io.InputStream;
import java.nio.file.*;
import java.net.URL;


public class Downloader {
  
  String path, filename;
  URL source;
  Date time_started_downloading;
  boolean successful;
  
  public Downloader(String path,String url_source) throws Exception{
    this.path=path;
    source=new URL(url_source);
    filename=getFilename(url_source);
    time_started_downloading = new Date();
    successful=false;
  }

  public Downloader(String path,String url_source,String customFilename) throws Exception{
    this.path=path;
    source= new URL(url_source);
    filename=customFilename;
    time_started_downloading = new Date();
    successful=false;
  }

  void downloadFile() throws Exception{
    try (InputStream in = source.openStream()){
      Files.copy(in, Paths.get(filename));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      successful=true;
    }
  }

  String getFilename(String url){
    String ret = "";
    for(int i = url.length()-1; i>=0;i--){
      if(url.charAt(i)=='/'){
        for(int j = i+1; url.length()>j;j++){
          ret+=url.charAt(j);
        }
        break;
      }
    }
    return ret;
  }

  
}
