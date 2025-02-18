package com.example.toDo.controller;

import com.example.toDo.model.TaskModel;
import com.example.toDo.service.ServiceTaskImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tasks")
public class TaskController {

  private final ServiceTaskImpl taskService;

  @Autowired
  public TaskController(ServiceTaskImpl taskService) {
    this.taskService = taskService;
  }


  @GetMapping
  public String getAllTasks(@RequestParam(defaultValue = "name") String sortField,
      @RequestParam(defaultValue = "asc") String sortDir, Model model) {
    List<TaskModel> tasks = taskService.getAllSortedTasks(sortField, sortDir);
    model.addAttribute("tasks", tasks);
    model.addAttribute("sortField", sortField);
    model.addAttribute("sortDir", sortDir);
    return "tasks";
  }

  @GetMapping("new")
  public String showNewTaskForm(Model model) {
    model.addAttribute("task", new TaskModel());
    return "new-task";
  }

  @PostMapping("save")
  public String saveTask(@ModelAttribute TaskModel task) {
    taskService.addTask(task);
    return "redirect:/tasks";
  }

  @GetMapping("/pomodoro")
  public String timerPomodoro() {
    return "pomodoro";
  }

  @GetMapping("/{id}")
  @ResponseBody
  public String updateTask(@PathVariable Long id) {
    //taskService.updateTask(task, id);
    //todo
    return "Данный участок еще в разработке!";
  }

  @DeleteMapping("/delete/{id}")
  public String deleteTask(@PathVariable Long id,
      @RequestHeader(value = "Referer", required = false) String referer) {
    taskService.deleteTask(id);
    return referer != null ? "redirect:" + referer : "redirect:/tasks";
  }
}
