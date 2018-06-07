import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.Math.max;

public MergeMeetingTimes{
	
	public static List<Meeting> mergeRanges(List<Meeting> meetings){
		//make a copy of meetings
		List<Meeting> sortedMeetings = new ArrayList<>();
		for(Meeting meeting: meetins){
			Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
			//the sortedMeetings are not sorted yet
			sortedMeetings.add(meetingCopy);
		}
		//sort the sortedMeetings by start time
		Collections.sort(sortedMeetings, new Comparator<Meeting>(){
			public int compare(Meeting m1, Meeting m2){
				return m1.getStartTime() - m2.getStartTime();
			}
		});
		//initialize mergedMeetings with the earliest meeting
		List<Meeting> mergedMeetings = new ArrayList<>();
		mergedMeetings.add(sortedMeetings.get(0));
		//merge meetings in one pass
		for(Meeting currentMeeting: sortedMeetings){
			Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size()-1);
			//if currentMeeting overlaps with lastMergedMeeting, use the later endTime of the two
			if(currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()){
				lastMergedMeeting.setEndTime(max.(lastMergedMeeting.getEndTime(), 
					currentMeeting.getEndTime()));
			} else {
				//if lastMergedMeeting does not overlap with currentMeeting, then add
				//currentMeeting, since meetings are sorted.
				mergedMeetings.add(currentMeeting);
			}
		}
		return mergedMeetings;
	}
	
}