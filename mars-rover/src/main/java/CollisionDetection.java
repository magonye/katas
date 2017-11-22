import java.util.ArrayList;
import java.util.List;

public class CollisionDetection {
    private List<Position> obstacles;
    private boolean collision;

    public CollisionDetection() {
        this.obstacles = new ArrayList<>();
    }

    public void setObstacles(List<Position> obstacles) {
        this.obstacles = obstacles;
    }

    public void checkCollision(Position position){
        if (obstacles.contains(position)) {
            collision = true;
        }
    }

    public boolean isCollision(){
        return collision;
    }
}
