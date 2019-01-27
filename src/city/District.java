package city;

import used.Point;

public class District {
	private String name;
	private Station station;
	private int density;
	private float prosperity;
	private double maintenanceCost;
	private String type;
	private int level;
	private Point position;
	
	public District(String name, Station station, int density, float prosperity, double maintenanceCost, String type, int level, Point position) {
		this.name = name;
		this.station = station;
		this.density = density;
		this.prosperity = prosperity;
		this.maintenanceCost = maintenanceCost;
		this.type = type;
		this.level = level;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Station getStation() {
		return station;
	}
	
	public void setStation(Station station) {
		this.station = station;
	}
	
	public int getDensity() {
		return density;
	}
	
	public void setDensity(int density) {
		this.density = density;
	}
	
	public float getProsperity() {
		return prosperity;
	}
	
	public void setProsperity(float prosperity) {
		this.prosperity = prosperity;
	}
	
	public double getMaintenanceCost() {
		return maintenanceCost;
	}
	
	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
}