public class Point {
    private long x = 0;
    private long y = 0;

    private final long ORIGIN_X = 0;
    private final long ORIGIN_Y = 0;

    public Point(long x, long y){
        this.x = x;
        this.y = y;
    }

    public long getX(){
        return x;
    }

    public long getY(){
        return y;
    }
    
    public double distanceFrom(Point p){
        long xDifference = p.getX() - x;
        long yDifference = p.getY() - y;

        double distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
        return distance;
    }
    public double distanceFrom(long x, long y){
        long xDifference = x - this.x;
        long yDifference = y - this.y;

        double distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
        return distance;
    }

    public double distanceFromOrigin(){
        return distanceFrom(ORIGIN_X, ORIGIN_Y);
    }
}
