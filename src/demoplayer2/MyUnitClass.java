package demoplayer2;

import aic2020.user.*;

/**
 * Abstract unit class, it is implemented by every unit type.
 */
public abstract class MyUnitClass {

    /**
     * Our UnitController.
     */
    UnitController uc;

    /**
     * Direction values.
     */
    Direction[] directions = Direction.values();

    /**
     * My id.
     */
    int myID;

    /**
     * Constructor
     */
    MyUnitClass(UnitController uc){
        this.uc = uc;
        this.myID = uc.getInfo().getID();
    }

    /**
     * Play method. It is implemented by each unit type.
     */
    abstract void play();

    /**
     * Generic attack method.
     */
    void attack(){

        /*Sense all enemies*/
        UnitInfo[] units = uc.senseUnits(uc.getTeam(), true, false);

        /*Attack any of them*/
        for (UnitInfo unit : units){
            if (uc.canAttack(unit.getLocation())) uc.attack(unit.getLocation());
        }
    }

    /**
     * Checks if a given location is adjacent to a non-structure unit.
     */
    boolean isAdjacentToAnotherUnit(Location loc){

        for (Direction dir : directions) {

            /*Location adjacent to loc following the given direction*/
            Location newLoc = loc.add(dir);

            /*If we can't sense it we assume there is no unit*/
            if (!uc.canSenseLocation(newLoc) || uc.isOutOfMap(newLoc)) continue;

            /*Unit at the new location*/
            UnitInfo unit = uc.senseUnitAtLocation(newLoc);

            /*If there is no unit or this is the unit, continue*/
            if (unit == null || unit.getID() == myID) continue;

            /*If it is not a structure => return true*/
            if (!unit.getType().isStructure()) return true;
        }

        return false;
    }

    /**
     * Generic spawn method. It tries to spawn one unit of a given type in every direction (but only one in total).
     * Also, the new unit should not be adjacent to any other. It returns true iff it successfully creates the given type.
     */
    boolean spawn(UnitType type){
        for(Direction dir : directions){

            /*Check for adjacency with a unit*/
            if (isAdjacentToAnotherUnit(uc.getLocation().add(dir))) continue;

            /*try spawning*/
            if (uc.canSpawn(type, dir)){
                uc.spawn(type, dir);
                return true;
            }
        }
        return false;
    }

    /**
     * Moves to a random location avoiding being adjacent to anyone else.
     */
    void moveRandomly(){

        /*Nothing to do if the unit can't move this turn*/
        if (!uc.canMove()) return;

        /*We try to move in a random direction at most 10 times*/
        for (int i = 0; i < 10; ++i) {

            /*Generate a random number from 0 to 7, both included*/
            int randomNumber = (int) (Math.random() * 8);

            /*Get corresponding direction*/
            Direction dir = Direction.values()[randomNumber];

            /*Don't move in this direction if there is another unit adjacent*/
            if (isAdjacentToAnotherUnit(uc.getLocation().add(dir))) continue;

            /*Move in direction dir if possible*/
            if (uc.canMove(dir)) {
                uc.move(dir);
                return;
            }
        }
    }

}
