import java.util.Date;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.net.URL;

public class Downloader {

  String path, filename;
  URL source;
  Date time_started_downloading;
  boolean successful;

  public Downloader(String path, String url_source) throws IOException {
    this.path = path;
    source = new URL(url_source);
    filename = FileTools.getFilenameURL(url_source);
    time_started_downloading = new Date();
    successful = false;
  }

  public Downloader(String path, String url_source, String customFilename) throws IOException {
    this.path = path;
    source = new URL(url_source);
    filename = customFilename;
    time_started_downloading = new Date();
    successful = false;
  }

  void downloadFile() throws IOException {
    try (InputStream in = source.openStream()) {
      Files.copy(in, Paths.get(path, filename));
    }catch (IOException e){
      System.out.println("download failed");
      e.printStackTrace();
    } finally {
      System.out.println("download successful");
      successful = true;
    }
  }

  public String toString() {
    String string_path = (path == "") ? "default" : path;
    return string_path + ';'
        + filename + ';'
        + source.toString() + ';'
        + time_started_downloading.toString() + ';'
        + successful+'\n';
  }
}
