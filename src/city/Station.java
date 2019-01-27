package city;

import java.util.ArrayList;

public class Station {
	private ArrayList<SubwayLine> subwayLines;
	private int level;
	private int maxCapacity;
	private String name;
	
	public Station(ArrayList<SubwayLine> subwayLines, int level, int maxCapacity, String name) {
		this.subwayLines = subwayLines;
		this.level = level;
		this.maxCapacity = maxCapacity;
		this.name=name;
	}
	
	public ArrayList<SubwayLine> getSubwayLines() {
		return subwayLines;
	}
	
	public void setSubwayLines(ArrayList<SubwayLine> subwayLines) {
		this.subwayLines = subwayLines;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}
