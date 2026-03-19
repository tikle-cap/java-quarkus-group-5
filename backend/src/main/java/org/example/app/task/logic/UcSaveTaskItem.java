package org.example.app.task.logic;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.TaskItemRepository;

@ApplicationScoped
@Named
@Transactional
public class UcSaveTaskItem {

  @Inject
  TaskItemRepository taskItemRepository;

  @Inject
  TaskItemMapper mapper;

  public TaskItemEto saveTaskItem(TaskItemEto taskItemEto) {
    TaskItemEntity entity = mapper.toEntity(taskItemEto);
    entity = taskItemRepository.save(entity);
    return mapper.toEto(entity);
  }

}
