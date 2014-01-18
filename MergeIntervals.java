/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {

    public class helperComparator implements Comparator<Interval> {
        public int compare(int a, int b) {
            if (a == b)
                return 0;
            else if (a < b)
                return -1;
            else
                return 1;
        }
        public int compare(Interval in1, Interval in2) {
            if (in1.start != in2.start)
                return compare(in1.start, in2.start);
            else
                return compare(in2.end, in2.end);
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new helperComparator());
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0)
            return result;
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            while (i < intervals.size() && intervals.get(i).start <= result.get(result.size() - 1).end) {
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, intervals.get(i).end);
                i++;
            }
            if (i < intervals.size())
                result.add(intervals.get(i));
        }
        return result;
    }
}
