package demoplayer;


import aic2020.user.*;

public class UnitPlayer {

    public void run(UnitController uc) {
	/*Insert here the code that should be executed only at the beginning of the unit's lifespan*/

        while (true){
			/*Insert here the code that should be executed every round*/

			/*Generate a random number from 0 to 7, both included*/
			int randomNumber = (int)(Math.random()*8);

			/*Get corresponding direction*/
			Direction dir = Direction.values()[randomNumber];

			/*Move in direction dir if possible*/
			if (uc.canMove(dir)) {
				uc.move(dir);
			}

			/*Try to spawn a fumigator in any direction*/
			for (Direction d : Direction.values()){
			    if (uc.canSpawn(UnitType.FUMIGATOR, d)) uc.spawn(UnitType.FUMIGATOR,d);
            }

            /*Sense all units not from my team, which includes opponent and neutral units*/
            UnitInfo[] visibleEnemies = uc.senseUnits(uc.getTeam(), true, true);
            for (int i = 0; i < visibleEnemies.length; ++i) {
                if (uc.canAttack(visibleEnemies[i].getLocation())) uc.attack(visibleEnemies[i].getLocation());
            }

            uc.yield(); //End of turn
        }

    }
}
