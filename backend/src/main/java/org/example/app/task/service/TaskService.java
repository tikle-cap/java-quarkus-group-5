package org.example.app.task.service;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.example.app.task.common.TaskItemEto;
import org.example.app.task.common.TaskListCto;
import org.example.app.task.common.TaskListEto;
import org.example.app.task.logic.UcDeleteTaskItem;
import org.example.app.task.logic.UcDeleteTaskList;
import org.example.app.task.logic.UcFindTaskItem;
import org.example.app.task.logic.UcFindTaskList;
import org.example.app.task.logic.UcSaveTaskItem;
import org.example.app.task.logic.UcSaveTaskList;

@Path("/task")
public class TaskService {

  @Inject
  private UcFindTaskList ucFindTaskList;

  @Inject
  private UcSaveTaskList ucSaveTaskList;

  @Inject
  private UcDeleteTaskList ucDeleteTaskList;

  @Inject
  private UcFindTaskItem ucFindTaskItem;

  @Inject
  private UcSaveTaskItem ucSaveTaskItem;

  @Inject
  private UcDeleteTaskItem ucDeleteTaskItem;


  @GET
  @Path("/lists")
  public List<TaskListEto> findAllTaskLists() {
    return this.ucFindTaskList.findAll();
  }

  @GET
  @Path("/list/{id}")
  public TaskListEto findTaskList(@PathParam("id") Long id) {

    TaskListEto task = this.ucFindTaskList.findById(id);
    if (task == null) {
      throw new NotFoundException("TaskList with id " + id + " does not exist.");
    }
    return task;
  }

  @POST
  @Path("/list")
  public TaskListEto createOrUpdateTastList(TaskListEto taskListEto) {
    TaskListEto savedTaskList = this.ucSaveTaskList.saveTaskList(taskListEto);

    return savedTaskList;
  }

  @GET
  @Path("/list-with-items/{id}")
  public TaskListCto getListWithItems(@PathParam("id") Long id) {
    return ucFindTaskList.findWithItems(id);
  }

  @DELETE
  @Path("/list/{id}")
  public void deleteTaskList(@PathParam("id") Long id) {
    ucDeleteTaskList.deleteTaskList(id);
  }

  @POST
  @Path("/item")
  public TaskItemEto addOrUpdateTaskItem(TaskItemEto taskItemEto) {
    TaskItemEto savedEto = ucSaveTaskItem.saveTaskItem(taskItemEto);
    return savedEto;
  }

  @GET
  @Path("/item/{id}")
  public TaskItemEto findTaskItem(@PathParam("id") Long id) {
    TaskItemEto taskitem = ucFindTaskItem.findById(id);
    if (taskitem == null) {
      throw new NotFoundException("TaskItem with id " + id + " does not exist.");
    }
    return taskitem;
  }

  @DELETE
  @Path("/item/{id}")
  public void deleteTaskItem(@PathParam("id") Long id) {
    ucDeleteTaskItem.deleteTaskItem(id);
  }

}
