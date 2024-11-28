package com.trainSpringBoot.logant.Projections;

import com.trainSpringBoot.logant.Enums.MenuName;
import com.trainSpringBoot.logant.Enums.MenuType;
import java.util.UUID;

public interface MenuSummary {

    UUID getId();              
    MenuName getName();        
    UUID getParentID();        
    String getRoute();         
    MenuType getType();       

}
