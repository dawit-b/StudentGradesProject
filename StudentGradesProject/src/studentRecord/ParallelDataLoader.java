package studentRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelDataLoader {
	public static List<StudentRecord> load(Path path) throws IOException{
		System.out.println("Loading Data ... ");
		
		List<String> lines = Files.readAllLines(path);
		
		List<StudentRecord> record = lines
				.parallelStream()
				.skip(1)
				.map(line -> line.split(";"))
				.map(line ->  new StudentRecord(line))
				.collect(Collectors.toList());
		return record;
	}
}
