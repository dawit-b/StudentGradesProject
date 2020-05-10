package studentRecord;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		List<StudentRecord> records = new ArrayList<StudentRecord>();
		Path path = Paths.get("Data", "Student Grade Record.txt");
		
		records = DataLoader.parallelLoader(path);
		
		
		

	}

}
