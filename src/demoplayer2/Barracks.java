package demoplayer2;

import aic2020.user.*;

public class Barracks extends MyUnitClass {

    /**
     * Inherited constructor.
     */
    Barracks(UnitController uc){
        super(uc);
    }

    /**
     * It tries to spawn a soldier every turn.
     */
    void play(){
        spawn(UnitType.SOLDIER);
    }

}
