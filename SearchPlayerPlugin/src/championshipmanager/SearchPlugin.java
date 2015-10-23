package championshipmanager;


import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUiController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GabrielFerreira
 */
public class SearchPlugin implements IPlugin{

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        /*
        //------------------------------------------Construir Botão Consultar campeonatos anteriores ------------------- ToolBar 1
        javax.swing.JButton newButton = uiController.addToolBar1Item("../ChampionshipManagerResources/src/res/icons/menusearch/searchpreviouschampionships/previous.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //
            }
        });
        }
        
        newButton = uiController.addToolBar1Item("../ChampionshipManagerResources/src/res/icons/menusearch/searchrankingbycompetition/competition.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //
            }
        });
        }*/
    }
    
}
