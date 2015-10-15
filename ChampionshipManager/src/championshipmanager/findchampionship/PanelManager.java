/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.findchampionship;

import javax.swing.JPanel;

/**
 *
 * @author gabrielferreira
 */
public class PanelManager {
    public void configureSemis(){}
    public void configureQuarters(JPanel panel, int ID_Championship){
    QuarterFinalsPanelManager manager = new QuarterFinalsPanelManager(panel, ID_Championship);
    }
    public void configureQuartersWithBests(){}
    public void configureGroupThree(){}
    public void configureGroupFour(){}
    public void configureGroupFive(){}
}
