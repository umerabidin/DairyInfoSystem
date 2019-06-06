package com.example.dairyinfosystem.utils;

public class HomeButtons {

    private static HomeButtons instance = null;

    public synchronized static HomeButtons getInstance() {
        if (instance == null)
            instance = new HomeButtons();
        return instance;

    }

    public  String[] getAdminRoles() {

        return new String[]{"Farm Manager", "Salary", "Leave Request", "View Attendance", "Reports", "Pricing"};
    }

    public  String[] getUserRoles() {

        return new String[]{"Farm Manager", "Salary", "Leave Request", "View Attendance", "Reports"};
    }

}
