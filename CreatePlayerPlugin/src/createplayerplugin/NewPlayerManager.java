package createplayerplugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import championshipmanager.DaoInsert;
import championshipmanager.DaoInsert;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author gabrielferreira
 */
public class NewPlayerManager {

    public NewPlayerPanel newPlayerPanel;
    private Player newPlayer;

    public NewPlayerManager() {
        newPlayerPanel = new NewPlayerPanel();
        newPlayerPanel.setVisible(true);
        newPlayerPanel.setBackground(new Color(0, 0, 0, 64));
        newPlayerPanel.getjPanel1().setVisible(false);
        newPlayer = new Player();
        initialize();
    }

    public NewPlayerPanel getNewPlayerPanel() {
        return newPlayerPanel;
    }

    public void initialize() {
        javax.swing.JButton selectPhoto = newPlayerPanel.getjButton1();
        selectPhoto.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newPlayerPanel.getjPanel1().removeAll();

                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    newPlayerPanel.getjPanel1().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    newPlayer.setPhotoPath(documentFile.getAbsolutePath());
                    addPhoto(newPlayerPanel.getjPanel1(), newPlayer.getPhotoPath());
                    newPlayerPanel.revalidate();
                    newPlayerPanel.repaint();
                }
            }
        });

        javax.swing.JButton createPlayer = newPlayerPanel.getjButton2();
        createPlayer.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JTextField nameField = newPlayerPanel.getjTextField1();
                String name = nameField.getText();
                newPlayer.setName(name);

                try {
                    newPlayer.copyPhoto();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(NewPlayerManager.class.getName()).log(Level.SEVERE, null, ex);
                }

                DaoInsert dao = new DaoInsert();

                try {
                    dao.createPlayer(newPlayer);
                } catch (SQLException ex) {
                    Logger.getLogger(NewPlayerManager.class.getName()).log(Level.SEVERE, null, ex);
                    newPlayerPanel.getjLabel2().setText("O jogador não foi adicionado... refaça a operação");
                }

                newPlayerPanel = new NewPlayerPanel();
                newPlayerPanel.getjLabel2().setText("O jogador foi adicionado");

            }
        });

    }

    public void addPhoto(JPanel panel, String address) {
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address);

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
        panel.setPreferredSize(labelimg.getSize());
       
        panel.revalidate();
        panel.repaint();
    }

}
