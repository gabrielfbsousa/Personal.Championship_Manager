/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.findchampionship;

import championshipmanager.DaoSelect;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielferreira
 */
public class ChoseChampionshipManager {
    private ChoseChampionshipPanel panel;
    
    public ChoseChampionshipManager(){
        panel = new ChoseChampionshipPanel();
        fillWithChampionships();
    }

    public ChoseChampionshipPanel getPanel() {
        return panel;
    }

    private void fillWithChampionships() {
        DaoSelect dao = new DaoSelect();
        ArrayList<Integer> list = new ArrayList();
        
        try {
            list = dao.selectAllChampionships();
        } catch (SQLException ex) {
            Logger.getLogger(ChoseChampionshipManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GridLayout experimentLayout = new GridLayout(0,2);
        panel.setLayout(experimentLayout);
        
        for(int i = 0; i < list.size(); i++){
           javax.swing.JButton button = new javax.swing.JButton("Campeonato de número "+ list.get(i).toString());
           int selected = 0;
            try {
                selected = dao.getKindOfChampionship(list.get(i).intValue());
            } catch (SQLException ex) {
                Logger.getLogger(ChoseChampionshipManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            configureButton(button, selected, list.get(i).intValue());
            panel.add(button);
        }
        panel.revalidate();
        panel.repaint();
    }
    
    private void configureButton(javax.swing.JButton button, int kind_of_championship, int ID_Championship){
        PanelManager manager = new PanelManager();
        switch(kind_of_championship){
            case 3: ; break;
            case 4: ; break;
            case 5: ; break;
            case 6: ; break;
            case 7: manager.configureQuarters(panel, ID_Championship); break;
            case 8: ; break;
            default: break;
        }
        
    }
    
    
}
