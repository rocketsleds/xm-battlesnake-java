package com.battlesnake.test;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.SnakeUtil;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4ClassRunner.class)
public class SnakeUtilTest {

    String myId = "MY_ID";

    @Test
    public void testGetAllowableMoves() {

        MoveRequest mr = new MoveRequest();
        mr.setYou(myId);
        mr.setWidth(6);
        mr.setHeight(5);

        ArrayList<Snake> snakes = new ArrayList<Snake>();

        Snake mySnake = new Snake();
        mySnake.setId(myId);
        int [][] coords = {{5,0}, {5,1}};
        mySnake.setCoords(coords);

        Snake theirSnake = new Snake();
        int [][] coords2 = {{0,1}, {0,2}, {0,3}};
        theirSnake.setCoords(coords2);

        snakes.add(mySnake);
        snakes.add(theirSnake);
        mr.setSnakes(snakes);

        int [] position = {0, 0};
        List<Move> moves = SnakeUtil.getAllowableMoves(position, mr);
        assertEquals(1, moves.size());
        assertTrue(moves.contains(Move.RIGHT));

        int [] position2 = {1, 0};
        moves = SnakeUtil.getAllowableMoves(position2, mr);
        assertEquals(2, moves.size());
        assertTrue(moves.contains(Move.RIGHT));
        assertTrue(moves.contains(Move.DOWN));

        int [] position3 = {1, 4};
        moves = SnakeUtil.getAllowableMoves(position3, mr);
        assertEquals(2, moves.size());
        assertTrue(moves.contains(Move.LEFT));
        assertTrue(moves.contains(Move.RIGHT));
        // assertTrue(moves.contains(Move.DOWN));


    }


    @Test
    public void testGetMyHead() {

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
