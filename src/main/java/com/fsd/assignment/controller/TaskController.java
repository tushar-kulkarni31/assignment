package com.fsd.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.assignment.dao.Task;
import com.fsd.assignment.service.TaskService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaskController {
	
	@Autowired
	TaskService taskService;
	   
	   @RequestMapping(value ="/getTasks", method = RequestMethod.GET)
	    public List<Task> getAllTodos() {
	       return taskService.getAllTask();
	    }
	   
	   @RequestMapping(value ="/editTask/{taskId}", method = RequestMethod.GET)
	    public Task getTask(@PathVariable("taskId") Integer taskId) {
	       Task task = taskService.getTask(taskId);
	       return task;
	    }
	   
	   @RequestMapping(value = "/addTask", method = RequestMethod.POST)
	   public ResponseEntity<Object> addTask(@RequestBody Task task) {
	      String message = taskService.addTask(task);
	      return new ResponseEntity<>(message, HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/deteteTask", method = RequestMethod.DELETE)
	    @ResponseBody
	    public String deleteTask(@RequestParam("taskId") Integer taskId){
	        if(taskService.deleteTask(taskId) == 1){
	            return "Item Deleted Successfully";
	        }else{
	            return "Something went wrong !";
	        }
	    }
	   
	   @RequestMapping(value= "/updateTask", method = RequestMethod.PUT)
	    @ResponseBody
	    public ResponseEntity<Object> updateTask(@RequestBody Task task){
		   String message = taskService.updateTask(task);
		   return new ResponseEntity<>(message, HttpStatus.OK);
	    }
	   
}
