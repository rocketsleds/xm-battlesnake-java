package com.battlesnake.test;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.SnakeUtil;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;
import com.google.common.collect.Lists;
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
    public void testBestMove() {
    }

    @Test
    public void testGetMySnakeWorks() {
        Snake snake1 = new Snake();
        snake1.setName("Jim");
        Snake snake2 = new Snake();
        snake2.setName("Jen");

        List<Snake> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);

        assertEquals("Jim", SnakeUtil.getMySnake(snakes, "Jim").getName());
    }

    @Test
    public void testGetMySnakeNotFoundWorks() {
        Snake snake1 = new Snake();
        snake1.setName("Jim");
        Snake snake2 = new Snake();
        snake2.setName("Jen");

        List<Snake> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);

        assertEquals(null, SnakeUtil.getMySnake(snakes, "Jones"));
    }

}
