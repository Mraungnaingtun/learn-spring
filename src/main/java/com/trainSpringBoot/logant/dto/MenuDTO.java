package com.trainSpringBoot.logant.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private UUID id;
    private String name;
    private String route;
    private List<MenuDTO> childRoutes;
}
