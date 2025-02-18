package com.example.toDo.controller;

import com.example.toDo.model.Priority;
import com.example.toDo.model.TaskModel;
import com.example.toDo.service.ServiceTaskImpl;
import java.beans.PropertyEditorSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

  @Autowired
  private ServiceTaskImpl taskService;

  @GetMapping("/tasks")
  public String getAllTasks(@RequestParam(defaultValue = "name") String sortField,
      @RequestParam(defaultValue = "asc") String sortDir, Model model) {
    List<TaskModel> tasks = taskService.getAllSortedTasks(sortField, sortDir);
    model.addAttribute("tasks", tasks);
    model.addAttribute("sortField", sortField);
    model.addAttribute("sortDir", sortDir);
    return "tasks";
  }

  @GetMapping("/tasks/new")
  public String showNewTaskForm(Model model) {
    model.addAttribute("task", new TaskModel());
    return "new-task";
  }

  @PostMapping("/tasks/save")
  public String saveTask(@ModelAttribute TaskModel task) {
    taskService.addTask(task);
    return "redirect:/tasks";
  }

  @GetMapping("/pomodoro")
  public String timerPomodoro(Model model) {
    return "pomodoro";
  }

  @PostMapping("/addTask")
  public TaskModel addTask(@Validated @RequestBody TaskModel task) {
    return taskService.addTask(task);
  }

  @PutMapping("/updateTask/{id}")
  public TaskModel updateTask(@RequestBody TaskModel task, @PathVariable("id") Long id) {
    return taskService.updateTask(task, id);
  }

  @DeleteMapping("/deleteTask/{id}")
  public String deleteTask(TaskModel task, @PathVariable("id") Long id) {
    taskService.deleteTask(id);
    return "Задача успешно удалена!";
  }


  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Priority.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) {
        setValue(Priority.fromString(text));
      }
    });
  }
}
