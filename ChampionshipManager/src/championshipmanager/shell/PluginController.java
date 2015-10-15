/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.shell;

import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IPluginController;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GabrielFerreira
 */
public class PluginController implements IPluginController {

    public PluginController()
    {
        loadedPlugins = new ArrayList<IPlugin>();
    }
    @Override
    public void initialize(ICore core) {
        File currentDir = new File("./plugins");
        String []plugins = currentDir.list();
        System.out.println("Found " + plugins.length + " plugins !");
        int i;
        URL []jars = new URL[plugins.length];
        for (i = 0; i < plugins.length; i++)
            try {
                jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        URLClassLoader ulc = new URLClassLoader(jars);

        for (i = 0; i < plugins.length; i++) {
            String []parts = jars[i].toString().split("/");
            String className = (parts[parts.length-1]).split("\\.")[0];
            IPlugin plugin = null;
            try {
                plugin = (IPlugin) Class.forName("championshipmanager.plugins." + className, true, ulc).newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (plugin != null) {
                System.out.println("Initializing plugin " + className);
                plugin.initialize(core);
                loadedPlugins.add(plugin);
            }
        }
    }

    @Override
    public ArrayList<IPlugin> getAllPlugins() {
        return loadedPlugins;
    }
    

    private ArrayList<IPlugin> loadedPlugins;
}

