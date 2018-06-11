/*
We maintain the maxTemp, minTemp, mean, and mode as temperatures are inserted, 
so that each getter method simply returns an instance variable.

To maintain the mean at each insert, we track the numberOfReadings 
and the totalSum of numbers inserted so far.

To maintain the mode at each insert, we track the total occurrences of each number, 
as well as the maxOccurrences we've seen so far.
*/

public TemperatureTracker{
	private static class TempTracker {

	    // for mode
	    private int[] occurrences = new int[111];  // array of 0s at indices 0..110
	    private int maxOccurrences;
	    private int mode;

	    // for mean
	    private int numberOfReadings;
	    private long totalSum;
	    private double mean;

	    // for min and max
	    private int minTemp = Integer.MAX_VALUE;
	    private int maxTemp = Integer.MIN_VALUE;

	    public void insert(int temperature) {

	        // for mode
	        occurrences[temperature]++;
	        if (occurrences[temperature] > maxOccurrences) {
	            mode = temperature;
	            maxOccurrences = occurrences[temperature];
	        }

	        // for mean
	        numberOfReadings++;
	        totalSum += temperature;
	        mean = (double) totalSum / numberOfReadings;

	        // for min and max
	        minTemp = Math.min(minTemp, temperature);
	        maxTemp = Math.max(maxTemp, temperature);
	    }

	    public int getMax() {
	        return maxTemp;
	    }

	    public int getMin() {
	        return minTemp;
	    }

	    public double getMean() {
	        return mean;
	    }

	    public int getMode() {
	        return mode;
	    }
	}
}