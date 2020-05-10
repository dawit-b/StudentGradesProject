package studentRecord;

import java.util.DoubleSummaryStatistics;
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
	
	public static void studentsGPAStatistics( List<StudentRecord> records ) {
		System.out.println("=========================================");
		System.out.println(" Student GPA statistics (highest and lowest GPA) ");
		Map<String, Double> studentsGradeMap = records
				.parallelStream()
				.collect(Collectors.groupingBy(StudentRecord::getStudentID, 
						Collectors.averagingDouble(StudentRecord::getStudentGrade)));
		
		List<StudentGPA> studentGPA = studentsGradeMap.entrySet().parallelStream()
				.map(entry -> new StudentGPA(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
		DoubleSummaryStatistics gpaStatistics = studentGPA
				.parallelStream()
				.collect(Collectors.summarizingDouble(StudentGPA::getGpa));
		System.out.println("Highest GPA student: "+ gpaStatistics.getMax());
		System.out.println("Lowest GPA student: "+ gpaStatistics.getMin());
		System.out.println("=========================================");
	}
	
	public static void departmentAverageGPA( List<StudentRecord> records) {
		System.out.println("=========================================");
		System.out.println("Average GPA by Department");
		
		Map<String, Double> departmentGPA = records
				.parallelStream()
				.collect(Collectors.groupingBy(StudentRecord::getDepartmentID, 
						Collectors.averagingDouble(StudentRecord::getStudentGrade)));
		
		departmentGPA.forEach((dept, gpa) -> System.out.println("Department: "+ dept + "GPA: " + gpa));
		System.out.println("=========================================");
		
	}
	
	public static void courseAverageGPA(List <StudentRecord> records) {
		System.out.println("=========================================");
		System.out.println("Average GPA by Course");
		Map<Integer, Double> courseGPA = records
				.parallelStream()
				.collect(Collectors.groupingBy(StudentRecord::getCourseNum, 
						Collectors.averagingDouble(StudentRecord::getStudentGrade)));
		courseGPA.forEach((course, gpa)-> System.out.println("Course: "+ course + "GPA"+ gpa));
		System.out.println("=========================================");

	}
	
	
}
