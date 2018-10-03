package Graph;

import java.awt.Point;


public class pts {

    Point start = null, end = null;

    public pts(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start;   }

    public Point getEnd() {  return end;  }
}