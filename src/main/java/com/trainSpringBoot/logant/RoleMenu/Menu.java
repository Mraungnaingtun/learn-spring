package com.trainSpringBoot.logant.RoleMenu;

import java.util.List;
import java.util.UUID;

import com.trainSpringBoot.logant.Enums.MenuName;
import com.trainSpringBoot.logant.Enums.MenuType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MenuName name;

    private UUID parentID;

    private String route;

    @Enumerated(EnumType.STRING)
    private MenuType type;

    @ManyToMany(mappedBy = "menus",fetch = FetchType.EAGER)
    private List<Role> role;

}
