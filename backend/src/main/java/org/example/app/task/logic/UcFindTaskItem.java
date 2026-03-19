package org.example.app.task.logic;

import java.util.Optional;
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
public class UcFindTaskItem {

  @Inject
  TaskItemRepository taskItemRepository;

  @Inject
  TaskItemMapper mapper;

  public TaskItemEto findById(Long id) {
    Optional<TaskItemEntity> entity = taskItemRepository.findById(id);
    return entity.map(taskItemEntity -> mapper.toEto(taskItemEntity)).orElse(null);
  }
  
}
