import java.io.*;

class FileTools {

	static boolean createFile(String filename) {
		boolean ret = false;
		try {
			File newFile = new File(filename);
			if (newFile.createNewFile()) {
				System.out.println("File created: " + newFile.getName());
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
			FileWriter fw = new FileWriter(filename);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return ret;
	}

}