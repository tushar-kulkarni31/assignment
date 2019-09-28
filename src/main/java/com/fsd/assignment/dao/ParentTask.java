package com.fsd.assignment.dao;

import org.springframework.data.mongodb.core.mapping.Field;

public class ParentTask {

	@Field("Parent_ID")
	private Long parentId;
	@Field("Parent_Task")
	private String parentTask;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
