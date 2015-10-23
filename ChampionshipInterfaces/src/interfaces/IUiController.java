/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import windowPlugin.MainWindow;

/**
 *
 * @author GabrielFerreira
 */
public interface IUiController {
    public abstract boolean addMenu(String menuName);
    public abstract javax.swing.JMenuItem addMenuItem(String menuName, String itemName);
    public abstract MainWindow getMainWindow();
    public abstract void clearPanel();
}
