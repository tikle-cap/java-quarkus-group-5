package org.example.app.task.common;

import java.util.List;

public class TaskListCto {

  private TaskListEto list;
  private List<TaskItemEto> items;

  public TaskListCto() {

    super();
  }
  
  public List<TaskItemEto> getItems() {
    return items;
  }

  public void setItems(List<TaskItemEto> items) {
    this.items = items;
  }

  public TaskListEto getList() {
    return list;
  }

  public void setList(TaskListEto list) {
    this.list = list;
  }
}
