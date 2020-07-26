package thotbotv1;

import aic2020.user.*;

public class Worker extends MyUnitClass{

    /**
     * Inherited constructor.
     */
    Worker(UnitController uc){
        super(uc);
    }

    /**
     * Tells if it has already built a barracks.
     */
    boolean barracksBuilt = false;

    /**
     * It moves randomly avoiding contact with other units and builds a barracks if it hasn't done that so far.
     */
    void play(){
        Direction dir = Direction.WEST;
        if (!barracksBuilt) {
            if (uc.canSpawn(UnitType.BARRACKS, dir)) {
                uc.spawn(UnitType.BARRACKS, dir);
                barracksBuilt = true;
            }
        } else {
            search();
        }
    }


}
