import java.io.*;

class FileTools {

  static String getFilenameURL(String url) {
    String ret = "";
    for (int i = url.length() - 1; i >= 0; i--) {
      if (url.charAt(i) == '/') {
        return url.substring(i+1);
      }
    }
    return ret;
  }

	static boolean createFile(String filename) {
		boolean ret = false;
		try {
			File new_file = new File(filename);
			if (new_file.createNewFile()) {
				System.out.println("File created: " + new_file.getName());
				ret = true;
			} else
				System.out.println("File already exists.");
				
		} catch (IOException e) {
			System.out.println("An error ocurred.");
			e.printStackTrace();
		}
		return ret;
	}

	static boolean appendFile(String input, String filename) {
		boolean ret = false;
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write(input);
			fw.close();
			ret = true;
		} catch (IOException e) {
			System.out.println("IOEXCEPTION: ");
			e.printStackTrace();
		}
		return ret;
	}

}
