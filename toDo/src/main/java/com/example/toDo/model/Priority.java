package com.example.toDo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Priority {
  HIGH("Высокий"),
  MIDDLE("Средний"),
  LOW("Низкий");

  private final String title;

  Priority(String title) {
    this.title = title;
  }

  @JsonValue
  public String getTitle() {
    return title;
  }

  @JsonCreator
  public static Priority fromString(String value) {
    if (value == null || value.isEmpty()) {
      return null;
    }
    for (Priority priority : Priority.values()) {
      if (priority.title.equalsIgnoreCase(value) || priority.name().equalsIgnoreCase(value)) {
        return priority;
      }
    }
    throw new IllegalArgumentException("Неизвестный приоритет: " + value);
  }
}
