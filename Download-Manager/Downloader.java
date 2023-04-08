import java.time.*;
import java.util.Date;

public class Downloader {
  
  String path,url_source;
  Date time_started_downloading;
  boolean successful;
  public Downloader(String path,String url_source){
    this.path=path;this.url_source=url_source;
    time_started_downloading = new Date();
    successful=false;
  }

  void tryToDownload(){
    
  }

}
