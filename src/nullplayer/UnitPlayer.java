package nullplayer;

import aic2020.user.*;

public class UnitPlayer {

    public void run(UnitController uc) {
	/*Insert here the code that should be executed only at the beginning of the unit's lifespan*/

        while (true){
			/*Insert here the code that should be executed every round*/

            uc.yield(); //End of turn
        }

    }
}
