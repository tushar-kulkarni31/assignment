package com.fsd.assignment.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "task")
public class Task {

	@Id
	private ObjectId _id;
	@Field("Task_ID")
	// @Indexed(unique = true)
	private Integer taskId;
	@Field("Task")
	private String taskName;
	@Field("Start_Date")
	private String startDate;
	@Field("End_Date")
	private String endDate;
	@Field("Priority")
	private String priority;
	@Field("Parent_ID")
	private String parentId;
	@Field("Parent_Task")
	private String parentTask;

	public Task() {

	}

	public Task(Integer taskID, String task, String startDate, String endDate, String priority, String parentTask,
			String parentId) {
		this.taskId = taskID;
		this.taskName = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.parentTask = parentTask;
		this.parentId = parentId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
