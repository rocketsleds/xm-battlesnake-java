/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.battlesnake;

import java.util.HashMap;
import java.util.Map;
import com.battlesnake.data.HeadType;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.MoveResponse;
import com.battlesnake.data.StartRequest;
import com.battlesnake.data.StartResponse;
import com.battlesnake.data.TailType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    private static Move lastMove = Move.DOWN;

  @RequestMapping(value="/start", method=RequestMethod.POST, produces="application/json")
  public StartResponse start(@RequestBody StartRequest request) {
    return new StartResponse()
      .setName("Rocket Snakes")
      .setColor("#3335FF")
      .setHeadUrl("http://vignette1.wikia.nocookie.net/nintendo/images/6/61/Bowser_Icon.png/revision/latest?cb=20120820000805&path-prefix=en")
      .setHeadType(HeadType.SHADES)
      .setTailType(TailType.FRECKLED)
      .setTaunt("Boom!");
  }

  @RequestMapping(value="/move", method=RequestMethod.POST, produces = "application/json")
  public MoveResponse move(@RequestBody MoveRequest request) {

    request.getDeadSnakes();
    request.getFood();
    request.getHeight();
    request.getWidth();
    request.getSnakes();
    request.getTurn();
    request.getYou();
    int [] head = SnakeUtil.getMyHead(request);
//    List<Move> moves = SnakeUtil.getAllowableMoves(head, request);
//      Move myMove = lastMove;
//      if (!moves.contains(lastMove)) {
//          myMove = moves.get(0);
//          lastMove = myMove; 
//      }

    Move myMove = SnakeUtil.getMoveTowardsFood(request, SnakeUtil.getAllowableMoves(head, request));
    return new MoveResponse()
      .setMove(myMove)
      .setTaunt("Eat my dust!");
  }
    
  @RequestMapping(value="/end", method=RequestMethod.POST)
  public Object end() {
      // No response required
      Map<String, Object> responseObject = new HashMap<String, Object>();
      return responseObject;
  }

}
