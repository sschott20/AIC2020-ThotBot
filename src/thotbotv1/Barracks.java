package thotbotv1;

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
        Integer round = uc.getRound();
        if (round < 250) {
            spawn(UnitType.SOLDIER);
        } else {
            if (uc.canDonate(3000)){
                uc.donate(3000);
            }
        }
    }

}
