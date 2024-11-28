package com.trainSpringBoot.logant.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;



@Data
public class AddMenuDto {
    
    private UUID roleId;
    private List<UUID> menuIds;
}
