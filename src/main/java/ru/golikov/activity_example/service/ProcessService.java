package ru.golikov.activity_example.service;

import lombok.RequiredArgsConstructor;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import ru.golikov.activity_example.dto.PostValueDto;
import ru.golikov.activity_example.dto.TaskDto;
import ru.golikov.activity_example.error.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProcessService {

  private final RuntimeService runtimeService;

  private final TaskService taskService;

  private final HistoryService historyService;

  /**
   * метод запускает активити процесс
   * @param postValue - postValue - число переданное в теле POST запроса (/start)
   */
  public void startProcess(PostValueDto postValue) {
    Map<String, Object> params = new HashMap<>();
    params.put("postValue", postValue.getPostValue());
    runtimeService.startProcessInstanceByKey("process", params);
  }

  /**
   * @return - метод возвращает список задач.
   */
  public List<TaskDto> getAllTasks() {
    List<Task> list = taskService.createTaskQuery().list();
    return list.stream()
            .map(task -> TaskDto.builder()
                    .id(task.getId())
                    .taskProperty(task.getName())
                    .build())
            .collect(Collectors.toList());
  }

  /**
   * метод выполняет задачу
   * @param taskDto - для выполнения задачи необходим Id задачи
   */
  public void completeTask(TaskDto taskDto) {
    Task task = taskService.createTaskQuery().taskId(taskDto.getId()).includeProcessVariables().singleResult();
    if (task != null) {
      taskService.complete(taskDto.getId(), task.getProcessVariables());
    } else throw new ResourceNotFoundException("Задачи с Id = " + taskDto.getId() + " не найдено" );
  }

  /**
   * @return - List<TaskDto> - список выполненных задач
   */
  public List<TaskDto> getResult() {
    List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().includeProcessVariables().finished().list();
    return list.stream()
            .map(task -> {
              Integer randomData = (Integer) task.getProcessVariables().get("randomData");
              Integer postValue = (Integer) task.getProcessVariables().get("postValue");
              return TaskDto.builder()
                      .id(task.getId())
                      .taskProperty(task.getName())
                      .isCompleted(true)
                      .randomData(randomData)
                      .postValue(postValue)
                      .summa(randomData + postValue)
                      .build();
            })
            .collect(Collectors.toList());
  }
}
