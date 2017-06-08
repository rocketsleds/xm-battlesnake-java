package com.battlesnake;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

public class SnakeUtil {

    public static List<Move> getAllowableMoves(int[] position, MoveRequest moveRequest) {
        List<Move> moves = new ArrayList<Move>();

        // what's our current location ?
        int x = position[0];
        int y = position[1];


        // create board of allowable moves, all true
        boolean [][] board = new boolean[moveRequest.getWidth()][moveRequest.getHeight()];
        for (int i=0; i < moveRequest.getWidth(); i++) {
            for (int j=0; j < moveRequest.getHeight(); i++) {
                board[i][j] = true;
            }
        }

        // update board for a snake
        for (Snake snake : moveRequest.getSnakes()) {
            updateAllowableBoard(board, snake);
        }
        for (Snake snake : moveRequest.getDeadSnakes()) {
            updateAllowableBoard(board, snake);
        }

        // check left
        int leftX = x -1;
        // if (int down


        return moves;
    }

    public static void updateAllowableBoard(boolean[][] board, Snake snake) {

        int[][] coords = snake.getCoords();
        for (int i=0; i < coords.length; i++) {
            int[] position = coords[i];
            board[position[0]] [position[1]] = false;
        }

    }

    public static int[] getMyHead(MoveRequest moveRequest) {
        List<Snake> snakes = moveRequest.getSnakes();

        for (Snake snake : snakes) {
            if (snake.getId() == moveRequest.getYou()) {
                return snake.getCoords()[0];
            }
        }
        throw new RuntimeException("Invalid setup");
    }

//    public static Move getMoveTowardsFood(MoveRequest moveRequest,List<Move> disallowedMove) {
    public static Move getMoveTowardsFood(MoveRequest moveRequest) {
        int[][] food = moveRequest.getFood();
        int[] foodPellet = food[0];

        int [] me = getMyHead(moveRequest);
        
        int diffx = foodPellet[0] - me[0];
        int diffy = foodPellet[1] - me[1];
        if (Math.abs(diffx) >= Math.abs(diffy)) {
            if (diffx >= 0) {
                return Move.RIGHT;
            } else {
                return Move.LEFT;
            }
        } else {
            if (diffy >= 0) {
                return Move.DOWN;
            } else {
                return Move.UP;
            }
        }
    }
}
