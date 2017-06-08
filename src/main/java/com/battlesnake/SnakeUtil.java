package com.battlesnake;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

public class SnakeUtil {
    public static List<Move> getAllowableMoves(MoveRequest moveRequest) {
        List<Move> moves = new ArrayList<Move>();

        // what's our current location ?


        // make sure we don't hit the sides
        // make sure we don't hit another snake
        // moveRequest.get
        return moves;
    }

    public static Move getBestMove(MoveRequest moveRequest) {
        Move move = Move.DOWN;

        Snake mySnake = getMySnake(moveRequest.getSnakes(), moveRequest.getYou());

        return move;
    }

    public static Snake getMySnake(List<Snake> snakes, String myName) {
        return snakes.stream().filter(s -> s.getName().equalsIgnoreCase(myName)).findFirst().orElse(null);
    }
}
