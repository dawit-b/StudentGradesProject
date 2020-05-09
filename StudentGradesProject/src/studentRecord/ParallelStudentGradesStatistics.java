package studentRecord;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStudentGradesStatistics {
	public static void allStudentsGPA(List<StudentRecord> records) {
		System.out.println("=========================================");
		System.out.println(" GPA of all Students ");
		Map<String, Double> studentsGradeMap = records
				.parallelStream()
				.collect(Collectors.groupingBy(StudentRecord::getStudentID, 
						Collectors.averagingDouble(StudentRecord::getStudentGrade)));
		
		studentsGradeMap.forEach((id, gpa) -> System.out.println(id + ":"+ gpa*(4/100)));
		System.out.println("=========================================");

	}
}
