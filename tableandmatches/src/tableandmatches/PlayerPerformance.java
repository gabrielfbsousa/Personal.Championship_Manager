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
public class PlayerPerformance implements Comparable<PlayerPerformance> {

    private String playerName;
    private String teamIconPath;
    private int points;
    private int wins;
    private int draws;
    private int loses;
    private int goalsMade;
    private int goalsConceded;
    private int goalDifference;
    private int championshipWhichIsDue;
    private int groupID;
    private boolean eliminated;

    public PlayerPerformance(String playerName, int championshipWhichIsDue) { //Pra mata-mata direto
        this.playerName = playerName;
        this.championshipWhichIsDue = championshipWhichIsDue;
        this.draws = 0;
        this.goalDifference = 0;
        this.goalsConceded = 0;
        this.goalsMade = 0;
        this.loses = 0;
        this.wins = 0;
        this.points = 0;
        this.eliminated = false;
    }

    public PlayerPerformance(String playerName, int championshipWhichIsDue, String photoTeamPath) { //Pra mata-mata direto
        this.playerName = playerName;
        this.championshipWhichIsDue = championshipWhichIsDue;
        this.draws = 0;
        this.goalDifference = 0;
        this.goalsConceded = 0;
        this.goalsMade = 0;
        this.loses = 0;
        this.wins = 0;
        this.points = 0;
        this.eliminated = false;
        this.teamIconPath = photoTeamPath;
    }

    public PlayerPerformance(String playerName, int championshipWhichIsDue, int groupID) {//Pra fase de grupos
        this.playerName = playerName;
        this.championshipWhichIsDue = championshipWhichIsDue;
        this.groupID = groupID;
        this.draws = 0;
        this.goalDifference = 0;
        this.goalsConceded = 0;
        this.goalsMade = 0;
        this.loses = 0;
        this.wins = 0;
        this.points = 0;
        this.eliminated = false;
    }

    public PlayerPerformance(String playerName, int championshipWhichIsDue, int groupID, String photoTeamPath) {//Pra fase de grupos
        this.playerName = playerName;
        this.championshipWhichIsDue = championshipWhichIsDue;
        this.groupID = groupID;
        this.draws = 0;
        this.goalDifference = 0;
        this.goalsConceded = 0;
        this.goalsMade = 0;
        this.loses = 0;
        this.wins = 0;
        this.points = 0;
        this.eliminated = false;
        this.teamIconPath = photoTeamPath;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getChampionshipWhichIsDue() {
        return championshipWhichIsDue;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLoses() {
        return loses;
    }

    public int getGoalsMade() {
        return goalsMade;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalDifference() {
        return goalsMade - goalsConceded;
    }

    public void setScore(int goalsMade, int goalsConceded) {
        this.goalsMade += goalsMade;
        this.goalsConceded += goalsConceded;
    }

    public void win() {
        wins++;
        points = points + 3;
    }

    public void draw() {
        draws++;
        points++;
    }

    public void lose() {
        loses++;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(PlayerPerformance o) {
        int comparePoints = ((PlayerPerformance) o).getPoints();

        return this.points - comparePoints;
    }

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public String getTeamIconPath() {
        return teamIconPath;
    }

}
