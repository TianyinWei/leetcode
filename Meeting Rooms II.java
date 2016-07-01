/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
 /*****method 1 greedy*****/
public class Solution { 
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1)  return 1;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int room = 0;
        int merge = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[merge])    room++;
            else merge++;
        }
        return room;
    }
}

/*****method 2 heap*****/
public class Solution { // reference:   http://www.importnew.com/6932.html
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1)  return 1;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return (a.start - b.start);
            }
        });
        
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return (a.end - b.end);
            }
        });
        
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = heap.poll();
            
            if (intervals[i].start < cur.end) { // need a new room for intervals[i]
                heap.offer(intervals[i]);
            } 
            if (intervals[i].start >= cur.end) { // does not need a new room for intervals[i]
                cur.end = intervals[i].end; // merge the two time slots
            }
            
            heap.offer(cur);    // add the time slot back to the heap. it is a room.
        }
        
        return heap.size();
    }
}
