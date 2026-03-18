package org.example.app.task.dataaccess;

import java.time.LocalDate;
import java.time.Month;
import jakarta.inject.Inject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TaskItemRepositoryTest extends Assertions {

  @Inject
  private TaskItemRepository taskItemRepository;

  @Test
  public void testFindById() {

    // given
    Long itemId = 11L;

    // when
    TaskItemEntity item = this.taskItemRepository.findById(itemId).get();

    // then
    assertThat(item.getTitle()).isEqualTo("Milk");
  }


  @Test
  public void testDeleteAllCompletedTasks() {

    TaskItemEntity newCompletedTaskItem = new TaskItemEntity("completed", true, false, LocalDate.of(2020, Month.JANUARY, 18).atStartOfDay());
    taskItemRepository.save(newCompletedTaskItem);
    assertThat(taskItemRepository.findAll()).anyMatch(TaskItemEntity::isCompleted);

    taskItemRepository.deleteByCompletedTrue();

    assertThat(taskItemRepository.findAll()).allMatch(item -> !item.isCompleted());
  }
}
