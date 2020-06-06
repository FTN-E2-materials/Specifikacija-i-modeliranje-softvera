package observers;

import java.util.ArrayList;

import observable.DataFeed;

public class History implements Observer {

	private ArrayList<Double>historicalData = new ArrayList<Double>();

	
	
	@Override
	public void update(Object o) {
		if (o instanceof DataFeed) {
			DataFeed df = (DataFeed) o;
			historicalData.add(df.getLastTemperature());
			printHistoricalData();
		}
	}
	
	public void printHistoricalData() {
		System.out.println("~~~ Historical Data ~~~");
		for(int i = 0; i < historicalData.size(); i++) {
			System.out.println("\t" + (i+1) + " -> " + historicalData.get(i) + "*C");
		}
	}


	// Getters and Setters
	public ArrayList<Double> getHistoricalData() {
		return historicalData;
	}
	public void setHistoricalData(ArrayList<Double> historicalData) {
		this.historicalData = historicalData;
	}
}
