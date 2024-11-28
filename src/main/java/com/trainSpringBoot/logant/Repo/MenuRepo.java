package com.trainSpringBoot.logant.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainSpringBoot.logant.RoleMenu.Menu;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {
    List<Menu> findMenusByRoleId(UUID roleId);
}
