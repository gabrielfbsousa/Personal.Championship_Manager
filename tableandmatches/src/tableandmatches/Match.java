/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableandmatches;

/**
 *
 * @author gabrielferreira
 */
public class Match {

    private int championshipID;
    private int groupID;
    private PlayerPerformance homePlayer;
    private PlayerPerformance awayPlayer;
    private int homeScore;
    private int awayScore;
    private boolean playoffs;
    private int homePenalties;
    private int awayPenalties;
    private int tourn;

    public Match(int championshipID, PlayerPerformance homePlayer, PlayerPerformance awayPlayer) {// válido pra mata-mata
        this.awayPlayer = awayPlayer;
        this.homePlayer = homePlayer;
        this.championshipID = championshipID;
        playoffs = true;
    }

    public Match(int championshipID, int groupID, int tourn) {// válido pra fase de grupo
        this.championshipID = championshipID;
        this.tourn = tourn;
        this.groupID = groupID;
        playoffs = false;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void getResultOfTheMatch() {
        homePlayer.setScore(homeScore, awayScore);
        awayPlayer.setScore(awayScore, homeScore);
        
        if(!playoffs){
        if (homeScore > awayScore) {
            homePlayer.win();
            awayPlayer.lose();
        }
        if (awayScore > homeScore) {
            awayPlayer.win();
            homePlayer.lose();
        }

        if (homeScore == awayScore) {
                homePlayer.draw();
                awayPlayer.draw();
        } 
        } else {
            if(homeScore > awayScore) {
                awayPlayer.lose();
                homePlayer.win();
                awayPlayer.setEliminated(true);
            }
            if(homeScore < awayScore) {
                awayPlayer.win();
                homePlayer.lose();
                homePlayer.setEliminated(true);
            }
            if(homeScore == awayScore){
                homePlayer.draw();
                awayPlayer.draw();
                if(homePenalties > awayPenalties){
                    awayPlayer.setEliminated(true);
                } else {
                    homePlayer.setEliminated(true);
                }
            }
        }        
                
            
        
    }

    public PlayerPerformance getHomePlayer() {
        return homePlayer;
    }

    public void setHomePlayer(PlayerPerformance homePlayer) {
        this.homePlayer = homePlayer;
    }

    public PlayerPerformance getAwayPlayer() {
        return awayPlayer;
    }

    public void setAwayPlayer(PlayerPerformance awayPlayer) {
        this.awayPlayer = awayPlayer;
    }

    public void setHomePenalties(int homePenalties) {
        this.homePenalties = homePenalties;
    }

    public void setAwayPenalties(int awayPenalties) {
        this.awayPenalties = awayPenalties;
    }

    public void setPlayoffs(boolean playoffs) {
        this.playoffs = playoffs;
    }

    public int getChampionshipID() {
        return championshipID;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public boolean isPlayoffs() {
        return playoffs;
    }

    public int getHomePenalties() {
        return homePenalties;
    }

    public int getAwayPenalties() {
        return awayPenalties;
    }

    public int getTourn() {
        return tourn;
    }
    
    

}
