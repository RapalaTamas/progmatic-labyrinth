package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

/**
 *
 * @author Pepe
 */
public class WallFollowerPlayer implements Player {

    @Override
    public Direction nextMove(Labyrinth l) {
       while (!l.hasPlayerFinished()) {
       
    }
    return (Direction.valueOf(""));
    }
    
    
}