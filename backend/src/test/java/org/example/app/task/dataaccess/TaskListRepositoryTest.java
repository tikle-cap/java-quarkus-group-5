package org.example.app.task.dataaccess;

import java.util.List;
import jakarta.inject.Inject;

import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TaskListRepositoryTest extends Assertions {

  @Inject
  TaskListRepository taskListRepository;

  @Test
  public void testgetAllTaskListsWithoutItems() {
    List<TaskListEntity> taskLists = this.taskListRepository.findAll();

    assertThat(taskLists).hasSize(4);

    assertThat(taskLists)
        .allMatch(taskList -> !Hibernate.isInitialized(taskList.getItems()));

  }
}
