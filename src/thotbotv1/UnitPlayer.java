package thotbotv1;

import aic2020.user.*;

public class UnitPlayer {

    public void run(UnitController uc) {
	/*Insert here the code that should be executed only at the beginning of the unit's lifespan*/

        /*We instantiate MyUnitClass to whatever type we are - note that we only create units of these types*/
        MyUnitClass myUnitClass;
        if (uc.getType() == UnitType.BASE) myUnitClass = new Base(uc);
        else if (uc.getType() == UnitType.ESSENTIAL_WORKER) myUnitClass = new Worker(uc);
        else if (uc.getType() == UnitType.BARRACKS) myUnitClass = new Barracks(uc);
        else if (uc.getType() == UnitType.FUMIGATOR) myUnitClass = new Fumigator(uc);
        else myUnitClass = new Soldier(uc);

        while (true){
			/*Insert here the code that should be executed every round*/

            /*play one turn*/
            myUnitClass.play();

            uc.yield(); //End of turn
        }

    }
}
