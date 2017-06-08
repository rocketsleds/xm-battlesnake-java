package com.battlesnake.test;

import java.util.ArrayList;
import com.battlesnake.SnakeUtil;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4ClassRunner.class)
public class SnakeUtilTest {

    @Test
    public void testGetAllowableMoves() {
        assertTrue(true);

    }


    @Test
    public void testGetMyHead() {
        String myId = "MY_ID";

        MoveRequest testMoveRequest = new MoveRequest();

        ArrayList<Snake> snakes = new ArrayList<Snake>();
        testMoveRequest.setSnakes(snakes);
        testMoveRequest.setYou(myId);
        Snake snake = new Snake();
        snakes.add(snake);

        snake.setId(myId);
        int[][] coords = {{5,6}, {3,4}, {5,6}};
        snake.setCoords(coords);

        int [] head = SnakeUtil.getMyHead(testMoveRequest);
        assertEquals(5, head[0]);
        assertEquals(6, head[1]);
    }
}
