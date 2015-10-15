/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.findchampionship;

import championshipmanager.DaoSelect;
import javax.swing.JPanel;

/**
 *
 * @author gabrielferreira
 */
public class QuarterFinalsPanelManager {
    private JPanel panel;
    private int ID_Championship;
    private DaoSelect dao;

    QuarterFinalsPanelManager(JPanel panel, int ID_Championship) {
        this.panel = panel;
        this.ID_Championship = ID_Championship;
        dao = new DaoSelect();
        fillChampionship();
    }
    
    public void fillChampionship(){
        
    }
    
    
}
