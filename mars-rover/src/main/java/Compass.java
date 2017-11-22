public class Compass {
    private Direction[] space = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    private int directionIndex = 0;

    public Compass(Direction initialDirection) {
        for (int i = 0; i < space.length; i++) {
            if (space[i]==initialDirection){
                directionIndex = i;
                break;
            }
        }
    }

    public void turn(char side){
        int factor = 1;
        if (side == 'L') {
            factor = -1;
        }
            directionIndex = (4+directionIndex + 1 *factor)%4;
    }

    public Direction getCurrentDirection(){
        return space[directionIndex];
    }
}