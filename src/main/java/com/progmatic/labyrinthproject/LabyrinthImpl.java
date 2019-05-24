package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {

    RandomPlayer rp;
    Labyrinth l;
    Coordinate cor;

    private int col;
    private int row;
    public String W;
    public String E;
    public String S;
    
    
    public LabyrinthImpl() {

    }
          
                          
    @Override
    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());

            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    switch (line.charAt(ww)) {
                        case 'W':
                            this.W = CellType.WALL.toString();
                            break;
                        case 'E':
                            this.E = CellType.END.toString();
                            break;
                        case 'S':
                            this.S = CellType.START.toString();
                            break;
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public int getWidth() {        
        return l.getWidth();        
    }

    @Override
    public int getHeight() {
        return l.getHeight();
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        if  (W.equals(c.getCol()) && W.equals(c.getRow()) )  {
            return CellType.WALL;
        } else if (E.equals(c.getCol()) && E.equals(c.getRow()) )  {
            return CellType.END;
        } else if (S.equals(c.getCol()) && S.equals(c.getRow()) )  {
            return CellType.START;
        } else {
        return CellType.EMPTY;
        }
    }
    
    

    @Override
    public void setSize(int width, int height) {
        if (width != l.getWidth() || height != l.getHeight()) {
            width = l.getWidth();
            height = l.getHeight();
        }
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {
        
        if (!type.equals(l.getCellType(c))) {
            CellType temp = l.getCellType(c);
            temp = type;
            if (type.equals(type.START)) {
            setPlayerPosition(0, 0);
            }
        }
    }
    

    @Override
    public Coordinate getPlayerPosition() {
        return new Coordinate(col, row);
        
    }
    public void setPlayerPosition(int x, int y) {
       x = cor.getCol();
       y = cor.getRow();
    }

    @Override
    public boolean hasPlayerFinished() {
        CellType finish = CellType.END;
        try {
            if (l.getCellType(l.getPlayerPosition()) == CellType.END) {
                return true;
            } 
        } catch (CellException ex) {
            System.out.println("CellExcepiton!!!");
        }
        return false;  
    }

    @Override
    public List<Direction> possibleMoves() {
        rp.getPlayerPosition();
        List<Direction> directionList = new ArrayList<>();
        if (!rp.nextMove(l).EAST.equals(rp.W)) {
            rp.nextMove(l);
            directionList.add(Direction.EAST);
        } else if (!rp.nextMove(l).WEST.equals(rp.W)) {
            rp.nextMove(l);
            directionList.add(Direction.WEST);
        } else if (!rp.nextMove(l).NORTH.equals(rp.W)) {
            rp.nextMove(l);
            directionList.add(Direction.NORTH);
        } else if (!rp.nextMove(l).SOUTH.equals(rp.W)) {
            rp.nextMove(l);
            directionList.add(Direction.SOUTH);
        }
        return directionList;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {
        
    }

}
