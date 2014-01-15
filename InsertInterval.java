/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int left = -1;
        int leftPos = 0;
        int right = -1;
        int rightPos = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if (left != -1 && right != -1)
                break;
            if (left == -1) {
                if (tmp.start >= newInterval.start) {
                    left = i;
                    leftPos = newInterval.start;
                } else if (tmp.end >= newInterval.start){
                    left = i;
                    leftPos = tmp.start;
                }
            }
            tmp = intervals.get(intervals.size() - 1 - i);
            if (right == -1) {
                if (tmp.end <= newInterval.end) {
                    right = intervals.size() - i - 1;
                    rightPos = newInterval.end;
                } else if (tmp.start <= newInterval.end) {
                    right = intervals.size() - i - 1;
                    rightPos = tmp.end;
                }
            }
        }
        if (left == -1) {
            intervals.add(newInterval);
        } else if (right == -1) {
            intervals.add(0, newInterval);
        } else {
            for (int i = 0; i <= right - left; i++) {
                intervals.remove(left);
            }
            intervals.add(left, new Interval(leftPos, rightPos));
        }
        return intervals;
    }
}
