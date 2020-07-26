package defence;

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
    boolean goApeShitWithSoldiers = false;
    void play(){
        Integer round = uc.getRound();

        if (round < 500 & uc.read(2) <= 6) {

            if (spawn(UnitType.SOLDIER)) {
                uc.write(2, uc.read(2) + 1);
            }
        }else if (goApeShitWithSoldiers){
            spawn(UnitType.SOLDIER);
        }
        else if (round % 50 == 0){
            spawn(UnitType.SOLDIER);
        } else {
            if (uc.canDonate(3000) & uc.toiletPaperDonated() < 3000){
                uc.donate(3000);
                goApeShitWithSoldiers = true;
                uc.write(3, 1);
            }
        }
    }

}
