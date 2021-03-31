package model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MonitoredData {
	private DateTime startTime;
	private DateTime endTime;
	private String activity;

	public MonitoredData(String startTime, String endTime, String activity) {
		super();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:ss");
		this.startTime = fmt.parseDateTime(startTime);
		this.endTime = fmt.parseDateTime(endTime);
		this.activity = activity;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "MonitoredData [startTime=" + startTime + ", endTime=" + endTime + ", activity=" + activity + "]";
	}

}
