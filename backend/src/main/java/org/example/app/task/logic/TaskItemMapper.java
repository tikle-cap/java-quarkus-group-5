package org.example.app.task.logic;

import java.util.List;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface TaskItemMapper {

  default List<TaskItemEto> toEtos(List<TaskItemEntity> items) {
    return items.stream().map(item -> toEto(item)).toList();
  }

  TaskItemEto toEto(TaskItemEntity taskItemEntity);

  TaskItemEntity toEntity(TaskItemEto taskItemEto);
}
