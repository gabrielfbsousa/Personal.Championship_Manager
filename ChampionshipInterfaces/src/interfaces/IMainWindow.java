/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author GabrielFerreira
 */
public interface IMainWindow {
    public abstract javax.swing.JButton getJButton1();

    public abstract void setJButton1(javax.swing.JButton button);

    public abstract JButton getjButton2();

    public abstract JButton getjButton1();

    public abstract JButton getjButton3();

    public abstract JButton getjButton4();

    public abstract JButton getjButton5();

    public abstract JButton getjButton6();

    public abstract JButton getjButton7();

    public abstract JButton getjButton9();

    public abstract JPanel getjPanel1();

    public abstract JPanel getjPanel2();

    public abstract JPanel getjPanel3();

    public abstract JPanel getjPanel4();

    public abstract JButton getjButton12();

    public abstract JButton getjButton13();

    public abstract JButton getjButton14();

    public abstract JToolBar getJToolBar1();

    public abstract JToolBar getJToolBar2();
    
    public abstract void revalidate();
    
    public abstract void repaint();
    
    public abstract void setVisible(Boolean bool);
    
    public abstract void setSize (int i, int j); 
}
