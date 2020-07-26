package defence;

import aic2020.user.*;


public class Soldier extends MyUnitClass {

    Soldier(UnitController uc){
        super(uc);
    }

    /**
     * Tells if the soldier should stop moving.
     */
    int baricadeSize = 15;
    boolean stop = false;
    boolean suicide = true;
    /**
     * It moves randomly until it is isolated. It attacks every enemy it sees.
     */
    void play(){
         if (uc.read(3) == 1){
            if (uc.getRound() % 100 == 0){
                baricadeSize += 5;
            }

        }
//        if (uc.getRound() % 10 == 0) {
//            if (uc.canPerformPCR()) {
//                if (uc.performPCR()) {
//                    search(uc.getInitialLocation(uc.getOpponent()));
//                }
//            }
//        }
        if (baricadeSize > 50){
            search(uc.getInitialLocation(uc.getOpponent()));
        } else {
            moveToBarricade(baricadeSize);
            attack();
        }

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
