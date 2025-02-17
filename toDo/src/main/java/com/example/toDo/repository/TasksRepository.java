package com.example.toDo.repository;

import com.example.toDo.model.TaskModel;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TaskModel, Long> {

  List<TaskModel> findAll(Sort sort);
}
