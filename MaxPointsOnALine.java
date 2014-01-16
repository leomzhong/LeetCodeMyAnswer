/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length < 2)
            return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int same = 0;
            int roundResult = 1;
            for (int j = i + 1; j < points.length; j++) {
                int y = points[j].y - points[i].y;
                int x = points[j].x - points[i].x;
                String slop = null;
                if (x == 0 && y == 0) {
                    same++;
                    continue;
                } else if (y == 0) {
                    slop = "0";
                } else if (x == 0) {
                    slop = "";
                } else {
                    int xTmp = x;
                    int yTmp = y;
                    if (x < 0) {
                        x = x * -1;
                    }
                    if (y < 0) {
                        y = y * -1;
                    }
                    while (y > 0) {
                        int c = x % y;
                        x = y;
                        y = c;
                    }
                    xTmp /= x;
                    yTmp /= x;
                    if (xTmp < 0) {
                        xTmp *= -1;
                        yTmp *= -1;
                    }
                    slop = xTmp + "_" + yTmp;
                }
                if (map.get(slop) == null)
                    map.put(slop, 2);
                else
                    map.put(slop, map.get(slop) + 1);
                roundResult = Math.max(roundResult, map.get(slop));
            }
            roundResult += same;
            result = Math.max(result, roundResult);
        }
        return result;
    }
}
