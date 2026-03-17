package org.example.app.task.dataaccess;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity {

  protected TaskItemEntity() {

  }

  public TaskItemEntity(String title, LocalDateTime deadline) {
    this.title = title;
    this.deadline = deadline;
  }

  @Column(name = "TITLE")
  private String title;

  @Column(name = "COMPLETED")
  private boolean completed;

  @Column(name = "STARRED")
  private boolean starred;

  @Column(name = "DEADLINE")
  private LocalDateTime deadline;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "LIST_ID")
  public TaskListEntity taskList;


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public boolean isStarred() {
    return starred;
  }

  public void setStarred(boolean starred) {
    this.starred = starred;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }
}
