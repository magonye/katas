public class StatusPrinter {

    public static String printCurrentStatus(Position position, boolean collision, Direction direction) {
        return String.format("%s%s:%s:%s",collision?"O:":"",position.getX(), position.getY() , direction.getValue());
    }
}
