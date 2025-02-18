package com.example.toDo.service;

import com.example.toDo.model.TaskModel;
import java.util.List;

public interface ServiceTask {

  //CRUD actions
  List<TaskModel> findAllTask();

  void addTask(TaskModel task);

  TaskModel updateTask(TaskModel task, Long id);

  void deleteTask(Long id);
}
