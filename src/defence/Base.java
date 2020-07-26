package defence;

import aic2020.user.*;

public class Base extends MyUnitClass {

    /**
     * Inherited constructor.
     */
    Base(UnitController uc){
        super(uc);
    }

    /**
     * Tells if the base has already built a worker.
     */
    boolean workerBuilt = false;

    /**
     * Last turn in which we built a fumigator.
     */
    int fumigatorTurn = 0;

    /**
     * It creates a worker if it hasn't done that before. It also creates a fumigator every 100 turns.
     */
    int workersBuilt = 0;
    void play(){

        /*Create worker if it hasn't done so*/
//        if (workersBuilt < 5){
//            if (spawn(UnitType.ESSENTIAL_WORKER)) workersBuilt += 1;
//        }

        if (workersBuilt < 3){
            spawn(UnitType.ESSENTIAL_WORKER);
            workersBuilt += 1;
        }

        /*Create fumigator if it hasn't created one in 100 turns*/
//        if (uc.getRound() >= fumigatorTurn + 100){
//            if (spawn(UnitType.FUMIGATOR)) fumigatorTurn = uc.getRound();
//        }
    }
}
