import java.util.HashSet;
import java.util.Set;

public InflightEntertainment{
	
	public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength){
		Set<Integer> movieLengthsSeen = new HashSet<>();
		//every movieLenth could be the firstMovieLength
		for(int firstMovieLength: movieLengths){
			//according to firstMovieLength 
			int matchingSecondMovieLength = flightLength - firstMovieLength;
			//if the matching second movie is seen already
			if(movieLengthsSeen.contains(matchingSecondMovieLength)){
				return true;
			}
			//if the matching second movie is not seen yet, add the first movie in the "seen list"
			movieLengthSeen.add(firstMovieLength);
		}
		//not found a match
		return false;
	}
	
}