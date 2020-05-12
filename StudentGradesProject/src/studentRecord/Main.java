package studentRecord;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		List<StudentRecord> records = new ArrayList<StudentRecord>();
		Path path = Paths.get("Data", "Student Grade Record.txt");
		Date start_time , end_time, serial_start_time, serial_end_time;
		
		serial_start_time = new Date();
		records = DataLoader.serialLoader(path);
		
		SerialStudentGradesStatistics.allStudentsGPA(records);
		SerialStudentGradesStatistics.departmentAverageGPA(records);
		SerialStudentGradesStatistics.studentsGPAStatistics(records);
		SerialStudentGradesStatistics.courseAverageGPA(records);
		
		serial_end_time = new Date();
		
		start_time = new Date();
		records = DataLoader.parallelLoader(path);
		
		ParallelStudentGradesStatistics.allStudentsGPA(records);
		ParallelStudentGradesStatistics.departmentAverageGPA(records);
		ParallelStudentGradesStatistics.studentsGPAStatistics(records);
		ParallelStudentGradesStatistics.courseAverageGPA(records);
		end_time  = new Date();
		System.out.println("Serial execution time: " + (serial_end_time.getTime() - serial_start_time.getTime()));

		System.out.println("Parallel execution time: " + (end_time.getTime() - start_time.getTime()));
		System.out.println("Speed up: " + (float)((serial_end_time.getTime() - serial_start_time.getTime())) / (end_time.getTime() - start_time.getTime()));
		
	

	}

}
