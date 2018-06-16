import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.Math.max;

public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
		//  new Meeting(2, 3);  // meeting from 10:00 – 10:30 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}

//given a list of meeting timestamps, return the merged timestamps
//  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
//  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
public MergeMeetingTimes{
	
	public static List<Meeting> mergeRanges(List<Meeting> meetings){
		//make a copy for sortedMeetins
		List<Meeting> sortedMeetings = new ArrayList<>();
		for(Meeting meeting: meetings){
			//the sortedMeetings are not sorted yet
			sortedMeetings.add(new Meeting(meeting.getStartTime(), meeting.getEndTime()));
		}
		//sort the sortedMeetings by starTime
		Collections.sort(sortedMeetings, new Comparator<Meeting>(){
			public int compare(Meeting m1, Meeting m2){
				return m1.getStartTime() - m2.getStartTime();
			}
		});
		//initialize mergedMeetings with the 0 index meeting
		List<Meeting> mergedMeetings = new ArrayList<>();
		mergedMeetings.add(sortedMeetings.get(0));
		//merge meetings in one pass
		for(Meeting currentMeeting: sortedMeetings){
			Meeting lastMeeting = mergedMeetings.get(mergedMeetings.size()-1);
			//if currentMeeting overlaps with lastMeeting
			//there is an overlap
			if(lastMeeting.getEndTime() >= currentMeeting.getStartTime()){
				//use the later endTime of the two
				lastMeeting.setEndTime(max(lastMeeting.getEndTime(), currentMeeting.getEndTime()));
			} else {
				//if lastMeeting does not overlap with currentMeeting, then add
				//currentMeeting, since meetings are sorted.
				mergedMeetings.add(currentMeeting);
			}
		}
		return mergedMeetings;
	}
	
}

/*
		for(Meeting currentMeeting: sortedMeetings){
			Meeting lastMeeting = mergedMeetings.get(mergedMeetings.size()-1);
		
			if(lastMeeting.getEndTime() >= currentMeeting.getStartTime()){
				
				lastMeeting.setEndTime( max(lastMeeting.getEndTime(), 
					currentMeeting.getEndTime()) );
			} else {

				mergedMeetings.add(currentMeeting);
			}
		}
*/