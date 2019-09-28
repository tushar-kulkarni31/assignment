package com.fsd.assignment.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fsd.assignment.dao.Task;
import com.fsd.assignment.domain.Domainrepository;
import com.mongodb.MongoClient;

@Service
public class TaskService {
	
	@Autowired
	Domainrepository domainrepository;
	
	public List<Task> getAllTask() {
	 List<Task> findAll = domainrepository.findAll();
     System.out.println("Test");
     return findAll;
	}
	
	public Task getTask(Integer taskId) {
		Task findByTaskId = domainrepository.findByTaskId(taskId);
		return findByTaskId;
	}
	
	public String addTask(Task task) {
		String message = null;
		try {
			task.setTaskId(TaskService.generateRandomIntIntRange(1, 1000));
			Task existingTask = domainrepository.findByTaskId(task.getTaskId());
			if(existingTask == null) {
				domainrepository.save(task);
				message = "Added Successfully !";
			} else {
				message = "Task already exists";
			}
			
		} catch (Exception e) {
			System.out.println("Error while adding task "+e);
			message = "Task could not be added";
		}
		return message;
	}
	
	public int deleteTask(Integer taskId) {
		Task task = domainrepository.findByTaskId(taskId);
		if(task != null) {
			domainrepository.delete(task);
			return 1;
		}
		return -1;
		
	}

	public String updateTask(Task task) {
		String message = null;
		try {
			Query query = new Query();
			MongoOperations mongoOperations = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(), "taskassgn"));
			query.addCriteria(Criteria.where("Task").is(task.getTaskName()));
			Task findOne = mongoOperations.findOne(query, Task.class);
			
			  findOne.setEndDate(task.getEndDate());
			  findOne.setParentId(task.getParentId());
			  findOne.setParentTask(task.getParentTask());
			  findOne.setPriority(task.getPriority());
			  findOne.setStartDate(task.getStartDate()); 
			  findOne.setTaskName(task.getTaskName());
			  mongoOperations.save(findOne);
			  
			  
			 
			System.out.println(findOne);
			//domainrepository.save(task);
			message = "Task updated successfully";
		}catch (Exception e) {
			System.out.println("Error while updating task "+e);
			message = "Task could not be updated";
		}
		return message;
	}
	
	public static int generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    return r.nextInt((1000 - 1) + 1) + min;
	}
}
