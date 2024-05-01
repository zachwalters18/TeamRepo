package TermApp;

import javax.swing.SwingUtilities;

import TermApp.GUI.EmployeeGUI;
import TermApp.GUI.LoginGUI;
import TermApp.GUI.MainGUI;
import TermApp.GUI.ProfileGUI;
import TermApp.GUI.ProjectGUI;

public class Main{
    public static void main(String[] args) {
        TEMPARRAYS tmp = new TEMPARRAYS();
        //MAKE SURE TO ADD ALL FAKE ENTITIES
        tmp.createFakeUsers();
        tmp.setFakeLog();
        tmp.createFakeProjects();

        LoginGUI loginGUI = new LoginGUI(tmp);
        //ProfileGUI profileGUI = new ProfileGUI(tmp);
        //EmployeeGUI employeeGUI = new EmployeeGUI(tmp);
    }
}