package defence;

import aic2020.user.*;

public class Worker extends MyUnitClass{

    /**
     * Inherited constructor.
     */
    Worker(UnitController uc){
        super(uc);
    }

    /**
     * Tells if it has already built a barracks.
     */
    boolean barracksBuilt = false;

    Location base = uc.getInitialLocation(uc.getTeam());

    int state = 0;

    void play(){

        if (!barracksBuilt) {
            if (uc.read(0) == 0){
                for (Direction dir : directions) {
                    if (uc.canSpawn(UnitType.BARRACKS, dir)) {
                        uc.spawn(UnitType.BARRACKS, dir);
                        barracksBuilt = true;
                        uc.write(0, 1);
                    }
                }
            }
        }
//        for (Direction dir : directions) {
//            if (uc.canSpawn(UnitType.BARRICADE,dir )) {
//                spawn(UnitType.BARRICADE);
//            }
//        }
        if (uc.getLocation().distanceSquared(uc.getInitialLocation(uc.getTeam())) > 2) {
            search(uc.getInitialLocation(uc.getTeam()));
        } else if (state == 0) {
             if (uc.canGatherFood()){
                 uc.gatherFood();
                 state = 1;
                 uc.yield();
             }
             moveRandomlyAdjacent();

            for (Direction dir : directions){
                if (uc.canBuildFarm(dir)){
                    buildFarm();
                }
            }
        } else if (state == 1){
            if (uc.canDeposit()){
                uc.deposit();
                state = 0;
            }else {
                search(uc.getInitialLocation(uc.getTeam()));
            }
        }
    }
    boolean buildFarm(){
        for(Direction dir : directions){

            /*Check for adjacency with a unit*/
//            if (isAdjacentToAnotherUnit(uc.getLocation().add(dir))) continue;

            /*try spawning*/
            if (uc.canBuildFarm( dir)){
                uc.buildFarm(dir);
                return true;
            }
        }
        return false;
    }


}
