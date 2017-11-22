import java.util.List;

public class Navigation {
    int size;
    Compass compass;
    Position position;
    CollisionDetection collisionDetection;

    public Navigation(int x, int y, int size, Direction direction) {
        this.position = new Position(x,y);
        this.size = size;
        compass = new Compass(direction);
        collisionDetection = new CollisionDetection();
    }

    public void move(char command){
        if (isTurningMovement(command)) {
            compass.turn(command);
        } else {

            Position newPosition = calculateNewPosition(this.position,compass.getCurrentDirection(), command);
            collisionDetection.checkCollision(newPosition);

            if (!collisionDetection.isCollision()){
                this.position = newPosition;
            }
        }
    }

    private Position calculateNewPosition(Position position,Direction direction, char command){
        int factor = 1;
        if (command == 'B') {
            factor = -1;
        }
        int newX = calculateNewPositionValue(position.getX(),direction.getX(),factor);
        int newY = calculateNewPositionValue(position.getY(),direction.getY(),factor);

        return new Position(newX, newY);

    }
    private int calculateNewPositionValue(int position, int acumulation, int factor){
        return (this.size + (position + factor * acumulation)) % this.size;
    }

    public String printCurrentStatus(){
        return StatusPrinter.printCurrentStatus(position, collisionDetection.isCollision(), compass.getCurrentDirection());
    }

    private boolean isTurningMovement(char movement){
        return movement== 'L' || movement== 'R';
    }

    public boolean isCollision() {
        return collisionDetection.isCollision();
    }

    public void setObstacles(List<Position> obstacles) {
        collisionDetection.setObstacles(obstacles);
    }
}
