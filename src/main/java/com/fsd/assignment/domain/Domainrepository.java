package com.fsd.assignment.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fsd.assignment.dao.Task;

@Repository
public interface Domainrepository extends MongoRepository<Task, String>{
	Task findByTaskId(Integer taskId);
	Task findByTaskName(String taskName);

}
