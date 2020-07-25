package demoplayer2;

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
        moveRandomly();
        if (!barracksBuilt) {
            if (spawn(UnitType.BARRACKS)) barracksBuilt = true;
        }
    }


}
