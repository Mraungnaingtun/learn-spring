package com.trainSpringBoot.logant.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainSpringBoot.logant.Repo.MenuRepo;
import com.trainSpringBoot.logant.Repo.RoleRepo;
import com.trainSpringBoot.logant.RoleMenu.Menu;
import com.trainSpringBoot.logant.RoleMenu.Role;
import com.trainSpringBoot.logant.dto.MenuDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

    private final MenuRepo menuRepo;
    private final RoleRepo roleRepo;

    @Transactional
    public List<MenuDTO> getMenuHierarchyByRoleId(UUID roleId) {
        List<Menu> menus = menuRepo.findMenusByRoleId(roleId);

        Map<UUID, MenuDTO> menuMap = menus.stream()
                .collect(Collectors.toMap(
                        Menu::getId,
                        menu -> new MenuDTO(menu.getId(), menu.getName().toString(), menu.getRoute(),
                                new ArrayList<>())));

        List<MenuDTO> rootMenus = new ArrayList<>();

        for (Menu menu : menus) {
            if (menu.getParentID() == null) {
                rootMenus.add(menuMap.get(menu.getId()));
            } else {
                MenuDTO parentMenu = menuMap.get(menu.getParentID());
                if (parentMenu != null) {
                    parentMenu.getChildRoutes().add(menuMap.get(menu.getId()));
                }
            }
        }

        return rootMenus;
    }

    @Transactional
    public List<MenuDTO> getAllMenuHierarchies() {
        List<Menu> menus = menuRepo.findAll();

        Map<UUID, MenuDTO> menuMap = menus.stream()
                .collect(Collectors.toMap(
                        Menu::getId,
                        menu -> new MenuDTO(menu.getId(), menu.getName().toString(), menu.getRoute(),
                                new ArrayList<>())));

        List<MenuDTO> rootMenus = new ArrayList<>();

        for (Menu menu : menus) {
            if (menu.getParentID() == null) {
                rootMenus.add(menuMap.get(menu.getId()));
            } else {
                MenuDTO parentMenu = menuMap.get(menu.getParentID());
                if (parentMenu != null) {
                    parentMenu.getChildRoutes().add(menuMap.get(menu.getId()));
                }
            }
        }

        return rootMenus;
    }

    @Transactional
    public String addMenuOnRole(UUID roleId, List<UUID> menus) throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Role role = roleRepo.findById(roleId)
                .orElseThrow(() -> new Exception("Role not found"));

        for (UUID menuId : menus) {
            Menu menu = menuRepo.findById(menuId)
                    .orElseThrow(() -> new Exception("Menu not found"));
            menuList.add(menu);
        }
        
        role.setMenus(menuList);
        roleRepo.save(role);

        return "success";
    }

}
