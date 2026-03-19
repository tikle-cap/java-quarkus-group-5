package org.example.app.task.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.dataaccess.TaskItemRepository;

@ApplicationScoped
@Named
@Transactional
public class UcDeleteTaskItem {

  @Inject
  TaskItemRepository taskItemRepository;

  public void deleteTaskItem(Long id) {
    taskItemRepository.deleteById(id);
  }

  public void deleteTaskItem(TaskItemEto taskItemEto) {
    Long id = taskItemEto.getId();
    if (id == null) {
      return;
    }
    taskItemRepository.deleteById(id);
  }
}
