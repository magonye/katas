import java.util.Arrays;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverShould {

    private MarsRover marsRover;

    @Before
    public void before(){
        marsRover = new MarsRover(0,0, Direction.NORTH, 10);
    }

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLLLLLLLLLL, 0:0:N",
    })
    public void turn_left(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }
    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRRRRRRRRRR, 0:0:N",
    })
    public void turn_right(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }
    @Test
    @Parameters({
            "LRL, 0:0:W",
            "RLRLRLRLRLRL, 0:0:N",

    })
    public void turn_left_and_right(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }

    @Test
    @Parameters({
            "F, 1:0:N",
            "FF, 2:0:N",
            "FFFFFFFFFF, 0:0:N",
    })
    public void move_forward(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }

    @Test
    @Parameters({
            "B, 9:0:N",
            "BB, 8:0:N",
            "BBBBBBBBBB, 0:0:N",
    })
    public void move_backward(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }

    @Test
    @Parameters({
            "LLF, 9:0:S",
            "LF, 0:1:W",
            "LLLF, 0:9:E",
    })
    public void move_turn_and_move_forward(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }

    @Test
    @Parameters({
            "FFF, O:2:0:N",
            "FFLFRFFRFRF, O:4:0:S",
    })
    public void detect_an_obstacle_and_stop_and_report(String commands, String finalPosition) {
        marsRover.addObstacles(Arrays.asList(new Position(3, 0)));
        Assert.assertThat(marsRover.move(commands), Is.is(finalPosition));
    }


    @Test
    @Parameters({
            "FFLFFFFRFFFFLFFFFFRFLFFFLFFFFFF, O:2:2:S",
    })
    public void travel_arround_the_planet(String commands, String finalPosition) {
        marsRover.addObstacles(Arrays.asList(new Position(3, 0),
                new Position(1 ,2),
                new Position(5, 3),
                new Position(2, 5),
                new Position(7, 5),
                new Position(5, 8),
                new Position(8, 9)
        ));
        Assert.assertThat(marsRover.move(commands), Is.is(finalPosition));
    }
}
