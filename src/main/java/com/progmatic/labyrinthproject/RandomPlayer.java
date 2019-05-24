package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;


/**
 *
 * @author Pepe
 */
public class RandomPlayer extends LabyrinthImpl implements Player {

    LabyrinthImpl li = new LabyrinthImpl();
    Coordinate c = new Coordinate(0, 0);
    
    
    @Override
    public Direction nextMove(Labyrinth l) {
        while (!l.hasPlayerFinished()) {
            
                
            }
        
    return Direction.valueOf("");
    }
    
}
