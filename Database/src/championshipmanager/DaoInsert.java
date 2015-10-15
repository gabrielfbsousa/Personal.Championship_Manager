/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager;



import createplayerplugin.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tableandmatches.Match;
import tableandmatches.PlayerPerformance;
//import tableandmatches.Match;
//import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabrielferreira
 */
public class DaoInsert {

    public Connection conn;
    public Conexao conexao;

    public DaoInsert() {
        try {
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        conexao = new Conexao();
        conn = conexao.fabricar();
    }

    public void createPlayer(Player player) throws SQLException {
        Statement pstm = conn.createStatement();
        pstm.executeUpdate("insert into player(playername, rankingpoints, profilephoto_directory) values ('" + player.getName() + "'," + player.getRankingPoints() + ",'" + player.getPhotoPath() + "')");
        pstm.close();
    }

    public ArrayList<Player> selectAllPlayers() throws SQLException {
        ArrayList<Player> allPlayers = new ArrayList();
        PreparedStatement pstm = conn.prepareStatement("select playername from player");
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            allPlayers.add(new Player(resultSet.getString("playername")));
        }
        pstm.close();
        return allPlayers;
    }
  
    public void finishGroup(int groupPosition, PlayerPerformance player, int IDGroup, int IDChampionship, int kind_of_championship) throws SQLException {
        PreparedStatement pstmOne = conn.prepareStatement("insert into championship(ID_Championship, playername, kind_of_championship) values (?,?,?)");
        pstmOne.setInt(1, IDChampionship);
        pstmOne.setString(2, player.getPlayerName());
        pstmOne.setInt(3, kind_of_championship);
        pstmOne.executeUpdate();
        pstmOne.close();

        PreparedStatement pstmTwo = conn.prepareStatement("insert into playerperformance(playername, ID_Championship, photoTeamPath, points,\n"
                + "wins,\n"
                + "draws,\n"
                + "loses,\n"
                + "goalsMade,\n"
                + "goalsConceded,\n"
                + "goalDifference,\n"
                + "ID_Phase,\n"
                + "groupID, finalpositionOnGroup) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        pstmTwo.setString(1, player.getPlayerName());
        pstmTwo.setInt(2, IDChampionship);
        pstmTwo.setString(3, player.getTeamIconPath());
        pstmTwo.setInt(4, player.getPoints());
        pstmTwo.setInt(5, player.getWins());
        pstmTwo.setInt(6, player.getDraws());
        pstmTwo.setInt(7, player.getLoses());
        pstmTwo.setInt(8, player.getGoalsMade());
        pstmTwo.setInt(9, player.getGoalsConceded());
        pstmTwo.setInt(10, player.getGoalDifference());
        pstmTwo.setInt(11, 1); //fase de grupos
        pstmTwo.setInt(12, IDGroup);
        pstmTwo.setInt(13, groupPosition);
        pstmTwo.executeUpdate();
        pstmTwo.close();
    }

    public void createGroup(int GroupID, int groupType) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement("insert into championshipgroup(groupid, kind_of_championship) values (?,?)");
        pstm.setInt(1, GroupID);
        pstm.setInt(2, groupType);
        pstm.executeUpdate();
        pstm.close();
    }
    
    public void createPlayoffsChampionship(int IDChampionship, PlayerPerformance player, int kind_of_championship) throws SQLException{
        PreparedStatement pstmOne = conn.prepareStatement("insert into championship(ID_Championship, playername, kind_of_championship) values (?,?,?)");
        pstmOne.setInt(1, IDChampionship);
        pstmOne.setString(2, player.getPlayerName());
        pstmOne.setInt(3, kind_of_championship);
        pstmOne.executeUpdate();
        pstmOne.close();
    }

    public void updateRankingPoints(int pointsDue, PlayerPerformance player) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement("update playerperformance set pointsearnedfromchampionship = ? where playername = ? and ID_Championship = ?");
        pstm.setInt(1, pointsDue);
        pstm.setString(2, player.getPlayerName());
        pstm.setInt(3, player.getChampionshipWhichIsDue());
        pstm.executeUpdate();
        pstm.close();
    }

    public void eliminatedFromPlayoffs(int championshipID, PlayerPerformance player, int pointsEarned) throws SQLException{
        PreparedStatement pstmTwo = conn.prepareStatement("insert into playerperformance(playername, ID_Championship, photoTeamPath,\n"
                + "wins,\n"
                + "draws,\n"
                + "loses,\n"
                + "goalsMade,\n"
                + "goalsConceded,\n"
                + "goalDifference,\n"
                + "ID_Phase,\n"
                + "pointsearnedfromchampionship) values (?,?,?,?,?,?,?,?,?,?,?)");
        pstmTwo.setString(1, player.getPlayerName());
        pstmTwo.setInt(2, championshipID);
        pstmTwo.setString(3, player.getTeamIconPath());
        pstmTwo.setInt(4, player.getWins());
        pstmTwo.setInt(5, player.getDraws());
        pstmTwo.setInt(6, player.getLoses());
        pstmTwo.setInt(7, player.getGoalsMade());
        pstmTwo.setInt(8, player.getGoalsConceded());
        pstmTwo.setInt(9, player.getGoalDifference());
        pstmTwo.setInt(10, 2); //mata-mata
        pstmTwo.setInt(11, pointsEarned);
        pstmTwo.executeUpdate();
        pstmTwo.close();
    }
  
    public void insertMatch(Match match){
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement("insert into championshipmatch(scoreone, scoretwo, id_phase, id_championship, playernameone, playernametwo, tourn, penaltieshome, penaltisaway) values(?,?,?,?,?,?,?,?,?)");
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(1, match.getHomeScore());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(2, match.getAwayScore());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(3, match.getGroupID());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(4, match.getChampionshipID());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setString(5, match.getHomePlayer().getPlayerName());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setString(6, match.getAwayPlayer().getPlayerName());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(7, match.getTourn());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(8, match.getHomePenalties());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.setInt(9, match.getAwayPenalties());
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
