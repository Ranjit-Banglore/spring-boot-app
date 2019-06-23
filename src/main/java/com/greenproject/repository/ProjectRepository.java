package com.greenproject.repository;

import com.greenproject.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer>{
}
