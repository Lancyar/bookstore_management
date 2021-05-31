/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;

/**
 * Web application lifecycle listener.
 *
 * @author PC
 */
public class MyServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc = sce.getServletContext();
        String fullPath = sc.getRealPath("/WEB-INF/route.txt");
        Map<String, String> servlets = new HashMap<>();
        try {
            File f = new File(fullPath);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String str = s.nextLine();
                String[] split = str.split("--");
                servlets.put(split[0].trim(), split[1].trim());
            }
            sc.setAttribute("SERVLET_MAPPING", servlets);
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(MyServletListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down!");//To change body of generated methods, choose Tools | Templates.
    }
}
