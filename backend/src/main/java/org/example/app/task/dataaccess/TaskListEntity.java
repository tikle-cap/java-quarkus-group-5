package org.example.app.task.dataaccess;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskList;

@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity implements TaskList {

  @Column(name = "TITLE")
  private String title;

  protected TaskListEntity() {

  }

  public TaskListEntity(String title) {
    this.title = title;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  public List<TaskItemEntity> getItems() {
    return items;
  }

  public void setItems(List<TaskItemEntity> items) {
    this.items = items;
  }

  @OneToMany(mappedBy = "taskList", fetch = FetchType.LAZY)
  public List<TaskItemEntity> items;
}
