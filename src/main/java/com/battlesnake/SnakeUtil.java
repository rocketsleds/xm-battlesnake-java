package com.battlesnake;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

public class SnakeUtil {
    public static Move currentMove = Move.DOWN;

    public static List<Move> getAllowableMoves(MoveRequest moveRequest) {
        List<Move> moves = new ArrayList<Move>();

        // what's our current location ?


        // make sure we don't hit the sides
        // make sure we don't hit another snake
        // moveRequest.get
        return moves;
    }

    public static Move getBestMove(MoveRequest moveRequest, Move currentDirection) {
        Snake mySnake = getMySnake(moveRequest.getSnakes(), moveRequest.getYou());

        switch(currentDirection) {
            case UP:
                if (willCollideInWall(Move.UP, moveRequest.getWidth(), moveRequest.getHeight(), mySnake)) {
                    return Move.LEFT;
                }
                break;

            case DOWN:
                if (willCollideInWall(Move.DOWN, moveRequest.getWidth(), moveRequest.getHeight(), mySnake)) {
                    return Move.RIGHT;
                }
                break;

            case LEFT:
                if (willCollideInWall(Move.LEFT, moveRequest.getWidth(), moveRequest.getHeight(), mySnake)) {
                    return Move.DOWN;
                }
                break;

            case RIGHT:
                if (willCollideInWall(Move.RIGHT, moveRequest.getWidth(), moveRequest.getHeight(), mySnake)) {
                    return Move.UP;
                }
                break;

        }

        return currentMove;
    }

    public static boolean willCollideInWall(Move direction, int width, int height, Snake mySnake) {
        int left = 0;
        int right = width - 1;
        int top = 0;
        int bottom = height - 1;

        int[] head = getHead(mySnake);

        switch(direction) {
            case UP:
                head = new int[]{head[0], head[1] - 1};
                if (head[1] <= top) {
                    return true;
                }

            case DOWN:
                head = new int[]{head[0], head[1] + 1};
                if (head[1] >= bottom) {
                    return true;
                }

            case LEFT:
                head = new int[]{head[0] - 1, head[1]};
                if (head[0] <= left) {
                    return true;
                }

            case RIGHT:
                if (head[0] >= right) {
                    return true;
                }
                break;

            default:
                throw new RuntimeException();
        }

        return false;
    }

    public static Snake getMySnake(List<Snake> snakes, String myName) {
        return snakes.stream().filter(s -> s.getName().equalsIgnoreCase(myName)).findFirst().orElse(null);
    }

    public static int[] getHead(Snake snake) {
        return snake.getCoords()[0];
    }
}
