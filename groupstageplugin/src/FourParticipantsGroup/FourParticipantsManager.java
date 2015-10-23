package FourParticipantsGroup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import ThreeParticipantsGroup.ThreeParticipantsManager;
import championshipmanager.DaoInsert;
import createplayerplugin.Player;
import groupstageplugin.IGroupsManager;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import tableandmatches.MatchManager;
import tableandmatches.PlayerPerformance;
import windowPlugin.MainWindow;

/**
 *
 * @author gabrielferreira
 */
public class FourParticipantsManager implements IGroupsManager {

    private FourParticipantsPanel groupPanel;
    private MainWindow mainWindow;
    private ArrayList<PlayerPerformance> participants;
    private int groupID;
    private int championshipID;
    private String photoTeamPathOne;
    private String photoTeamPathTwo;
    private String photoTeamPathThree;
    private String photoTeamPathFour;
    private DaoInsert dao;
    private int tourns;

    public FourParticipantsManager(int championshipID, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        groupPanel = new FourParticipantsPanel();
        participants = new ArrayList();
        this.tourns = 0;
        this.championshipID = championshipID;
        dao = new DaoInsert();
        this.groupID = 1 + (int) (Math.random()*5000); 
        
        try {
            dao.createGroup(groupID, 4);
        } catch (SQLException ex) {
            Logger.getLogger(FourParticipantsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fillBoxWithAllPlayers(groupPanel.getjComboBox1());
        fillBoxWithAllPlayers(groupPanel.getjComboBox2());
        fillBoxWithAllPlayers(groupPanel.getjComboBox3());
        fillBoxWithAllPlayers(groupPanel.getjComboBox4());
        configureSelectPhotoButtons();
        configureConfirmationButton();
        configureCreateTable();
    }

    @Override
    public JTabbedPane getGroupPanel() {
        return groupPanel.getjTabbedPane1();
    }

    @Override
    public void fillBoxWithAllPlayers(JComboBox comboBox) {
        ArrayList<Player> allPlayers = new ArrayList();

       try {
           allPlayers = dao.selectAllPlayers();
        } catch (SQLException ex) {
            Logger.getLogger(ThreeParticipantsManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < allPlayers.size(); i++) {
            comboBox.addItem(allPlayers.get(i).getName());
       }

    }

    @Override
    public void configureConfirmationButton() {
        javax.swing.JButton button = groupPanel.getjButton5();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                
                String selectedOne = groupPanel.getjComboBox1().getSelectedItem() + "";
                String selectedTwo = groupPanel.getjComboBox2().getSelectedItem() + "";
                String selectedThree = groupPanel.getjComboBox3().getSelectedItem() + "";
                String selectedFour = groupPanel.getjComboBox4().getSelectedItem() + "";

                participants.add(new PlayerPerformance(selectedOne, championshipID, groupID, photoTeamPathOne));
                participants.add(new PlayerPerformance(selectedTwo, championshipID, groupID, photoTeamPathTwo));
                participants.add(new PlayerPerformance(selectedThree, championshipID, groupID, photoTeamPathThree));
                participants.add(new PlayerPerformance(selectedFour, championshipID, groupID, photoTeamPathFour));

                fillMatchesWithSpecificPlayers();
                            }
        });
    }

    @Override
    public void fillMatchesWithSpecificPlayers() {
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox5().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox6().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox7().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox8().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox9().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox10().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox11().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox12().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox13().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox14().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox15().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 4; i++) {
            groupPanel.getjComboBox16().addItem(participants.get(i).getPlayerName());
        }
    }
    
    public void configureCreateTable(){
        javax.swing.JButton button = groupPanel.getjButton6();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Termina fase de grupos. Aqui, a ideia é calcular partida por partida, mandar elas pro banco, 
                //criar uma tabela temporária, e por fim, gerar a tabela final, que será mandada ao banco
                tourns++;
                if(groupPanel.getjCheckBox1().isSelected()){ // Tem mais um turno
                    MatchManager create = new MatchManager(groupPanel, participants, championshipID, groupID, tourns, true);
                    groupPanel.getjTextField1().setText("");
                    groupPanel.getjTextField2().setText("");
                    groupPanel.getjTextField3().setText("");
                    groupPanel.getjTextField4().setText("");
                    groupPanel.getjTextField5().setText("");
                    groupPanel.getjTextField6().setText("");
                    groupPanel.getjTextField7().setText("");
                    groupPanel.getjTextField8().setText("");
                    groupPanel.getjTextField9().setText("");
                    groupPanel.getjTextField10().setText("");
                    groupPanel.getjTextField11().setText("");
                    groupPanel.getjTextField12().setText("");
                } else { // Não tem outro turno
                   MatchManager create = new MatchManager(groupPanel, participants, championshipID, groupID, tourns, false);
                }

            }
        });
    }

    @Override
    public ArrayList<PlayerPerformance> getPlayersPerformance() {
        return participants;
    }
    
     private void configureSelectPhotoButtons() {
        javax.swing.JButton button1 = groupPanel.getjButton1();
        button1.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathOne = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel1(), photoTeamPathOne);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
        
        javax.swing.JButton button2 = groupPanel.getjButton2();
        button2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathTwo = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel2(), photoTeamPathTwo);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
        
        javax.swing.JButton button3 = groupPanel.getjButton3();
        button3.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathThree = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel3(), photoTeamPathThree);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
        
        javax.swing.JButton button4 = groupPanel.getjButton4();
        button4.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathFour = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel4(), photoTeamPathFour);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
    }
    
    public void addIcon(JPanel panel, String address){
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address);

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
        panel.revalidate();
        panel.repaint();
    }



}
