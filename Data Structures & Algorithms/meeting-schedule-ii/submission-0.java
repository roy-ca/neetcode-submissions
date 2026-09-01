/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        //When we want to find the minimum  no of rooms or platforms, we seperately sort both start and end times and then find the net values

        int noOfRooms = 0;
        int n = intervals.size();

        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for(int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        //Sort both arrays seperately
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPtr = 0;
        int endPtr = 0;
        //startTimes = [0, 5, 15]
        //endTimes = [10, 20, 40]

        while(startPtr < n) {
            if(startTimes[startPtr] < endTimes[endPtr]) {
                noOfRooms++;
            }
            else {
                endPtr++;
            }
            startPtr++;
        }
        return noOfRooms;
    }
}
