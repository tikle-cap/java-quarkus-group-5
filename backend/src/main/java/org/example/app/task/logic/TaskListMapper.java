package org.example.app.task.logic;

import org.example.app.task.common.TaskListEto;
import org.example.app.task.dataaccess.TaskListEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface TaskListMapper {


  TaskListEto toEto(TaskListEntity task);


  TaskListEntity toEntity(TaskListEto task);
}
