package com.trainSpringBoot.logant.Projections;

public interface CompanySummary {

    String getCompanyName();
    String getPhoneNumber();
    ManagerSummary getManager();

    interface ManagerSummary {
        String getName();
        String getDepartment(); 
    }
    
}
