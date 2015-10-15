/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielferreira
 */
public class DaoSelect {
    public Connection conn;
    public Conexao conexao;

    public DaoSelect() {
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
    
    public ArrayList<Integer> selectAllChampionships() throws SQLException{
        ArrayList<Integer> list = new ArrayList();
        PreparedStatement pstm = conn.prepareStatement("select distinct id_championship from championship");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            list.add(rs.getInt("ID_Championship"));
        }
        return list;
    }
    
    public int getKindOfChampionship(int ID_Championship) throws SQLException{
        int selected = 0;
        PreparedStatement pstm = conn.prepareStatement("select distinct id_championship from championship");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            selected = rs.getInt("kind_of_championship");
        }
        return selected;
    }
}
