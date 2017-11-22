public enum Direction {
    NORTH("N",1,0), EAST("E",0,-1), SOUTH("S",-1,0), WEST("W",0,1);

    private final String value;
    private final int x;
    private final int y;


    Direction(String value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}