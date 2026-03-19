package org.example.app.task.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class TaskServiceTest extends Assertions {

  /** Test of {@link TaskService#findTaskList(Long)}. */
  @Test
  public void testFindTaskList() {

    given().when().get("/task/list/1").then().statusCode(200)
        .body(is("{\"id\":1,\"version\":0,\"title\":\"Shopping List\"}"));
  }

  @Test
  public void testSaveTaskList() {
    given().when().body("{ \"title\": \"Shopping List\" }").contentType(ContentType.JSON).post("/task/list").then()
        .statusCode(200);
  }
}
