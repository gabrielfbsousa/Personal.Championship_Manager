/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableandmatches;

import java.util.Comparator;

/**
 *
 * @author gabrielferreira
 */
public class PlayerPerformanceComparator implements Comparator<PlayerPerformance> {

    @Override
    public int compare(PlayerPerformance o1, PlayerPerformance o2) {
        if (o1.getPoints()< o2.getPoints()) {
            return 1;
        } 
        if(o1.getPoints() == o2.getPoints()) {
            if(o1.getGoalDifference() < o2.getGoalDifference()){
                return 1;
            } if(o1.getGoalDifference() > o2.getGoalDifference()){
                return -1;
            } else {
                if(o1.getGoalsMade() < o2.getGoalsMade()){
                    return 1;
                } else {
                    return -1;
                }
            }  
        }
        if(o1.getPoints() > o2.getPoints()) {
            return -1;
        }
        return 0;
    }

}
