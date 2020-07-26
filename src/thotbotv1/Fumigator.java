package thotbotv1;

import aic2020.user.*;

public class Fumigator extends MyUnitClass {

    Fumigator(UnitController uc){
        super(uc);
    }

    void play(){
        Integer round = uc.getRound();
        sweepPastBarricade(17);
    }


}
