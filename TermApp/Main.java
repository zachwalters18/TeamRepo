package TermApp;

import javax.swing.SwingUtilities;

import TermApp.GUI.LoginGUI;

public class Main{
    public static void main(String[] args) {
        TEMPARRAYS tmp = new TEMPARRAYS();
        //MAKE SURE TO ADD ALL FAKE ENTITIES
        tmp.createFakeUsers();
        tmp.setFakeLog();
        //tmp.makeFakeEvals();
        tmp.createSkillInfo();
        tmp.createJobInfo();
        tmp.createFakeEmployees();
        tmp.createFakeProjects();

        LoginGUI loginGUI = new LoginGUI(tmp);
    }
}