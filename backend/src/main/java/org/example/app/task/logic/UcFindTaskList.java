package org.example.app.task.logic;

import java.util.List;
import java.util.Optional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.common.TaskListCto;
import org.example.app.task.common.TaskListEto;
import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.dataaccess.TaskListRepository;

@ApplicationScoped
@Named
@Transactional
public class UcFindTaskList {

  @Inject
  TaskListRepository taskListRepository;

  @Inject
  TaskListMapper taskListMapper;

  @Inject
  TaskItemMapper taskItemMapper;

  public TaskListEto findById(Long id) {
    Optional<TaskListEntity> entity = taskListRepository.findById(id);
    return entity.map(taskListEntity -> taskListMapper.toEto(taskListEntity)).orElse(null);
  }

  public List<TaskListEto> findAll() {
    return taskListRepository.findAll().stream().map(item -> taskListMapper.toEto(item)).toList();
  }

  public TaskListCto findWithItems(Long id) {
    Optional<TaskListEntity> taskListEntity = taskListRepository.findById(id);
    if (taskListEntity.isEmpty()) {
      return null;
    }
    TaskListCto taskListCto = new TaskListCto();
    taskListCto.setList(taskListMapper.toEto(taskListEntity.get()));

    List<TaskItemEto> itemEtos = taskItemMapper.toEtos(taskListEntity.get().getItems());
    taskListCto.setItems(itemEtos);

    return taskListCto;
  }

}
