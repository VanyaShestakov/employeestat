package com.leverx.employeestat.rest.repository;

import com.leverx.employeestat.rest.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    Optional<Project> findProjectById(UUID uuid);

    Optional<Project> findProjectByName(String name);

    @Override
    List<Project> findAll();

    boolean existsByName(String name);
}