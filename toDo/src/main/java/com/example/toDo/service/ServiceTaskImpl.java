package com.example.toDo.service;


import com.example.toDo.model.Priority;
import com.example.toDo.model.TaskModel;
import com.example.toDo.repository.TasksRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ServiceTaskImpl implements ServiceTask {

  @Autowired
  private final TasksRepository tasksRepository;

  public ServiceTaskImpl(TasksRepository tasksRepository) {
    this.tasksRepository = tasksRepository;
  }

  public List<TaskModel> getAllSortedTasks(String sortField, String sortDir) {
    Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending()
        : Sort.by(sortField).descending();
    return tasksRepository.findAll(sort);
  }

  @Override
  public List<TaskModel> findAllTask() {
    return tasksRepository.findAll();
  }

  @Override
  public void addTask(TaskModel task) {
    if (task.getPriority() != null) {
      task.setPriority(Priority.fromString(task.getPriority().getTitle()));
    }
    tasksRepository.save(task);
  }

  @Override
  public TaskModel updateTask(TaskModel task, Long id) {
    TaskModel taskModel = tasksRepository.findById(id).orElse(null);
    if (taskModel == null) {
      return null;
    }
    taskModel.setName(task.getName());
    taskModel.setComment(task.getComment());
    taskModel.setTeg(task.getTeg());
    if (task.getPriority() != null) {
      task.setPriority(Priority.fromString(task.getPriority().getTitle()));
    }
    taskModel.setDate(LocalDateTime.now());
    return tasksRepository.save(taskModel);
  }

  @Override
  public void deleteTask(Long id) {
    tasksRepository.deleteById(id);
  }

}
