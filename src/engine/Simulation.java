package engine;

import grid.Grid;

public class Simulation {
	
	private Grid grid;
	private GridParameters parameters;
	private static int simulationNumberOfTurn;
	
	public Simulation(GridParameters parameters) {
		this.parameters=parameters;
		simulationNumberOfTurn=1;
	}
	
	//getters
	public static int getSimulationTurn() {
		return simulationNumberOfTurn;
	}
	
	public GridParameters getParameters() {
		return parameters;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	/**
	 * generer of grid and upload statistics
	 */
	
	public void generatGrid() {
		GridBuilder buildGrid = new GridBuilder(parameters);
		grid = buildGrid.getGrid();
	}
	
	public void simulationNextTurn() {
		// TODO the next turn of the simulation
		
		simulationNumberOfTurn++;
	}
}
