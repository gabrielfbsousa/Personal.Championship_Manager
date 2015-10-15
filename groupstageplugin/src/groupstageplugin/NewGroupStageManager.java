package groupstageplugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import DefaultQuarterFinals.DefaultQuarterFinalsManager;
import DefaultQuarterFinals.GroupstageQuarterFinals;
import FiveParticipantsGroup.FiveParticipantsManager;
import FourParticipantsGroup.FourParticipantsManager;
import QuarterFinalsWithSecondsBest.GroupstageQuarterFinalsWithSecondsBest;
import QuarterFinalsWithSecondsBest.QuarterFinalsWithBestSecondsManager;
import SemiFinals.GroupstageSemiFinals;
import SemiFinals.SemiFinalsManager;
import ThreeParticipantsGroup.ThreeParticipantsManager;
import windowPlugin.MainWindow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author gabrielferreira
 */
public class NewGroupStageManager {

    private NewGroupStagePanel pontosPanel;
    private MainWindow mainWindow;
    private int championshipID;
    private ArrayList<IGroupsManager> allGroups;
    private int groupsQuantity;
    private int playersQuantity;

    public NewGroupStageManager(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        pontosPanel = new NewGroupStagePanel();
        pontosPanel.setVisible(true);
        championshipID = 1 + (int) (Math.random()*5000); 
        initialize();
    }

    public NewGroupStagePanel getPontosPanel() {
        return pontosPanel;
    }  
    

    public void initialize() {
        String[] groupQuantity = {
            "2",
            "3"
        };

        String[] groupParticipants = {
            "3",
            "4",
            "5"
        };

        final javax.swing.JComboBox comboBoxGroups = createComboBoxes(groupQuantity, pontosPanel.getjComboBox1());
        final javax.swing.JComboBox comboBoxPlayers = createComboBoxes(groupParticipants, pontosPanel.getjComboBox2());
        createGroupsButton(comboBoxPlayers, comboBoxGroups);
        QuarterFinalButton();
        QuarterWithBestSecondButton();
        SemiFinalButton();

    }
    
    public void createGroupsButton(final javax.swing.JComboBox comboBoxPlayers, final javax.swing.JComboBox comboBoxGroups){
        allGroups = new ArrayList();
        javax.swing.JButton buttonCreateGroups = pontosPanel.getjButton1();
        buttonCreateGroups.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JButton buttonQuarters = pontosPanel.getjButton2();
                javax.swing.JButton buttonQuartersWithBests = pontosPanel.getjButton3();
                javax.swing.JButton buttonSemis = pontosPanel.getjButton4();
                buttonQuarters.setEnabled(true);
                buttonQuartersWithBests.setEnabled(true);
                buttonSemis.setEnabled(true);
                
                String selectedPlayersQuantity = comboBoxPlayers.getSelectedItem() + "";
                String selectedGroupsQuantity = comboBoxGroups.getSelectedItem() + "";
                groupsQuantity = Integer.parseInt(selectedGroupsQuantity);
                playersQuantity = Integer.parseInt(selectedPlayersQuantity);

                javax.swing.JTabbedPane panel = pontosPanel.getjTabbedPane1();
                panel.removeAll();

                IGroupsManager newGroup = null;

                for (int i = 0; i < groupsQuantity; i++) {

                    switch (playersQuantity) {
                        case 3:            
                            newGroup = new ThreeParticipantsManager(championshipID);
                            JScrollPane scrollThree = new JScrollPane(newGroup.getGroupPanel());
                            panel.add(scrollThree);
                            allGroups.add(newGroup);
                            break;

                        case 4:
                            newGroup = new FourParticipantsManager(championshipID);
                            JScrollPane scrollFour = new JScrollPane(newGroup.getGroupPanel());
                            panel.add(scrollFour);
                            allGroups.add(newGroup);
                            break;
                        case 5:
                            newGroup = new FiveParticipantsManager(championshipID);
                            JScrollPane scrollFive = new JScrollPane(newGroup.getGroupPanel());
                            panel.add(scrollFive);
                            allGroups.add(newGroup);
                            break;
                    }

                }
                            
                if(groupsQuantity == 2){
                    if(playersQuantity == 3){
                        buttonQuarters.setEnabled(false);
                        buttonQuartersWithBests.setEnabled(false);
                    } else {
                        buttonQuarters.setEnabled(false);
                    }
                    
                }
                if(groupsQuantity == 3){
                    if(playersQuantity == 3){
                        buttonQuarters.setEnabled(false);
                    } 
                }
            }
        });
    }
    
    public void QuarterFinalButton(){
        javax.swing.JButton button = pontosPanel.getjButton2();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GroupstageQuarterFinals quarterFinals = new GroupstageQuarterFinals(championshipID, allGroups);
                mainWindow.getjPanel2().removeAll();
                mainWindow.getjPanel2().setLayout(new BorderLayout());
                mainWindow.getjPanel2().add(quarterFinals.getPanel(), BorderLayout.CENTER);
                mainWindow.revalidate();
                mainWindow.repaint();
                mainWindow.setSize(1300, 1000);
            }
        });
    }
    //Por fazer
    public void QuarterWithBestSecondButton(){
        javax.swing.JButton button = pontosPanel.getjButton3();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GroupstageQuarterFinalsWithSecondsBest quarter = new GroupstageQuarterFinalsWithSecondsBest(championshipID, allGroups);
                //Se eu não tirar o ponto de terceiro lugar de grupo, ele pode acumular esses 5 caso seja campeão.
                mainWindow.getjPanel2().removeAll();
                mainWindow.getjPanel2().setLayout(new BorderLayout());
                mainWindow.getjPanel2().add(quarter.getPanel(), BorderLayout.CENTER);
                mainWindow.revalidate();
                mainWindow.repaint();
                mainWindow.setSize(1400, 1000);
            }
        });
    }
    
    public void SemiFinalButton(){
        javax.swing.JButton button = pontosPanel.getjButton4();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GroupstageSemiFinals semis = new GroupstageSemiFinals(championshipID, allGroups);
                mainWindow.getjPanel2().removeAll();
                mainWindow.getjPanel2().setLayout(new BorderLayout());
                mainWindow.getjPanel2().add(semis.getPanel(), BorderLayout.CENTER);
                mainWindow.revalidate();
                mainWindow.repaint();
                mainWindow.setSize(1200, 1000);
            }
        });
    }
    
    public javax.swing.JComboBox createComboBoxes(String[] itemsNames, javax.swing.JComboBox comboBox){
        for (int i = 0; i < itemsNames.length; i++) {
            comboBox.addItem(itemsNames[i]);
        }
        return comboBox;
    }
    
}
