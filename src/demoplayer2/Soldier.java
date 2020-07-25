package demoplayer2;

import aic2020.user.*;

public class Soldier extends MyUnitClass {

    Soldier(UnitController uc){
        super(uc);
    }

    /**
     * Tells if the soldier should stop moving.
     */
    boolean stop = false;

    /**
     * It moves randomly until it is isolated. It attacks every enemy it sees.
     */
    void play(){
        if (!stop) moveRandomly();
        if (shouldStop()) stop = true;
        attack();
    }

    /**
     * If there is no other soldier at a distance of 18 or less it should stop forever.
     */
    boolean shouldStop(){

        /*Sense teammates*/
        UnitInfo[] units = uc.senseUnits(18, uc.getTeam());

        /*Check for nearby soldiers - note that global senses do not sense this unit*/
        for (UnitInfo unit : units){
            if (unit.getType() == UnitType.SOLDIER) return false;
        }

        return true;
    }


}
