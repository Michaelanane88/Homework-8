package edu.brooklyn.cisc3130.campus_taskboard.service;

import edu.brooklyn.cisc3130.campus_taskboard.exception.TaskNotFoundException;
import edu.brooklyn.cisc3130.campus_taskboard.model.Task;
import edu.brooklyn.cisc3130.campus_taskboard.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findByDeletedFalse();
    }

    public Task getTaskById(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        if (task.getDeleted()) {
            throw new TaskNotFoundException(id);
        }

        return task;
    }

    public Task createTask(Task task) {

        if (task.getCompleted() == null) {
            task.setCompleted(false);
        }

        if (task.getDeleted() == null) {
            task.setDeleted(false);
        }

        if (task.getPriority() == null) {
            task.setPriority(Task.Priority.MEDIUM);
        }

        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task updatedTask) {

        Task task = getTaskById(id);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.getCompleted());
        task.setPriority(updatedTask.getPriority());

        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {

        Task task = getTaskById(id);

        task.setDeleted(true);

        taskRepository.save(task);
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompletedTrueAndDeletedFalse();
    }

    public List<Task> getIncompleteTasks() {
        return taskRepository.findByCompletedFalseAndDeletedFalse();
    }

    public List<Task> getTasksByPriority(Task.Priority priority) {
        return taskRepository.findByPriorityAndDeletedFalse(priority);
    }
}