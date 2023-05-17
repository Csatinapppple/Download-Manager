import java.io.*;

class FileTools {

	static String getFileContents(String filename){
		String ret = "";
		
		try{
			
			FileReader file_reader = new FileReader(filename);
			ret = file_reader.toString();
			file_reader.close();
		
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
			System.out.println("ERROR: File not found for reading");
		}catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("ERROR: An unexpected input/output error ocurred");
		}
		return ret;
	}

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
			
			}else{
				System.out.println("File already exists.");
			}

		}catch (NullPointerException npe){
			System.out.println("ERROR: Provided null to function when expected String");
			npe.printStackTrace();
		}catch (IOException e) {
			System.out.println("ERROR: Unexpected input/output error");
			e.printStackTrace();
		}
		return ret;
	}

	static boolean appendFile(String input, String filename) {
		boolean ret = false;
		
		try {
		
			FileWriter file_writer = new FileWriter(filename,true);
			file_writer.write(input);
			file_writer.close();
			ret = true;
		
		} catch (IOException ioe) {
			System.out.println("ERROR: Unexpected input/output error");
			ioe.printStackTrace();
		}
		return ret;
	}

}
