package edu.brooklyn.cisc3130.campus_taskboard.repository;

import edu.brooklyn.cisc3130.campus_taskboard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByDeletedFalse();

    List<Task> findByCompletedTrueAndDeletedFalse();

    List<Task> findByCompletedFalseAndDeletedFalse();

    List<Task> findByPriorityAndDeletedFalse(Task.Priority priority);
}