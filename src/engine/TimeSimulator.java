package engine;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimeSimulator
{	
	private static final int DAY_DURATION = 240;
	
	private Calendar calendar;
	private SimpleDateFormat formatter;
	
	private int secondCount = 0;
		
	public TimeSimulator() {
		calendar = Calendar.getInstance();
		formatter = new SimpleDateFormat("dd MMMM yyyy",Locale.ENGLISH);
		init();
	}
	
	private void init() {
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.HOUR,0);
	}	
	
	public int getSecond() {
		return calendar.get(Calendar.SECOND);
	}
	
	public int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}
	
	public int getHour() {
		return calendar.get(Calendar.HOUR);
	}
	
	public String getTime() {
		return getHour()+":"+getMinute()+":"+getSecond();
	}
	
	public String getDay() {
		return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
	}
	
	public String getDate() {
		return formatter.format(calendar.getTime());
	}
	
	public int getSecondCount() {
		return secondCount;
	}
	
	public boolean isWeekEnd() {
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
	}
	
	public void update() {
		calendar.add(Calendar.SECOND,1);
		if((secondCount % DAY_DURATION)==0 && secondCount!=0) {
			calendar.add(Calendar.DAY_OF_WEEK,1);
			init();
		}
		secondCount++;
	}
	
}
