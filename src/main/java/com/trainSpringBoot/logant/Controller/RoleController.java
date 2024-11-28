package com.trainSpringBoot.logant.Controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainSpringBoot.logant.Service.MenuService;
import com.trainSpringBoot.logant.dto.AddMenuDto;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private final MenuService menuService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMenuByRole(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(menuService.getMenuHierarchyByRoleId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllMenuHierarchies() {
        try {
            return ResponseEntity.ok(menuService.getAllMenuHierarchies());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> addMenuOnRole(@RequestBody AddMenuDto body) {
        try {
            return ResponseEntity.ok(menuService.addMenuOnRole(body.getRoleId(), body.getMenuIds()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

}
