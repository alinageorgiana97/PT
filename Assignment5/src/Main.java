package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	private static List<MonitoredData> data = new ArrayList<MonitoredData>();

	public static void main(String[] args) throws IOException {

		read();
		getNumbersOfDays();
		getMappingCountActivities();
		getMappingActivitiesForEachDay();
		getMapActivitiesDuration();
		//getMapActivitiesDurationLine();

	}
	
	/*Read the data from the file Activity.txt using streams and split each line in 3 parts:
	start_time, end_time and activity label and create a list of objects of type MonitoredData.*/
	
	public static void read() throws IOException {
		Stream<String> stream = Files.lines(Paths.get("Activities.txt"));
		data = stream
				.map(line -> new MonitoredData(line.substring(0, 19), line.substring(21, 40),
				line.substring(42, line.length() - 1).trim()))
				.collect(Collectors.toList());
		
		stream.close();
		data.stream()
		.forEach(System.out::println);

	};

	/*Count how many days of monitored data appears in the log.*/
	public static void getNumbersOfDays() {
		
		long days = data.stream()
				.map(a-> a.getStartTime().dayOfMonth().get())
				.distinct()
				.count();
		System.out.println(days);
	};
	/*Count how many times has appeared each activity over the entire monitoring period.
Return a map of type <String, Int> representing the mapping of activities to their count.
*/
	public static void getMappingCountActivities() {
		
		Map<String,Integer> mapActivities = new HashMap<>();
		mapActivities = data
				.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.summingInt(x->1)));
				
		mapActivities.entrySet().stream().forEach(System.out::println);
		
	};
	
	public static void getMappingActivitiesForEachDay() {
		
		Map<String,Map<Integer,Integer>> mapActivitiesForEachDay;
		mapActivitiesForEachDay = data
				.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity,Collectors.groupingBy(a-> a.getStartTime().getDayOfMonth(),Collectors.summingInt(x -> 1))));
		
		mapActivitiesForEachDay.entrySet().forEach(System.out::println);
	}
	
	
	public static void getMapActivitiesDuration() {
		Map<String,Integer> mapActivitesDuration;
		mapActivitesDuration = data
				.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.summingInt(a-> a.getEndTime().getMinuteOfDay() - a.getStartTime().getMinuteOfDay()) ));
		mapActivitesDuration.entrySet().forEach(System.out::println);
	}
	
	/*public static void getMapActivitiesDurationLine() {
		Map<String,Integer> mapActivitesDuration;
		mapActivitesDuration = data
				.stream()
				.collect(Collectors.groupingBy(lines, Seconds.secondsBetween(MonitoredDate::getStartTime,Monitored));
		mapActivitesDuration.entrySet().forEach(System.out::println);
		 Seconds seconds = Seconds.secondsBetween(a.getStartTinme, a. getEndTime);
	}*/
	
	
		

	}
	
	



