package com.taskmanager.dao;

import com.taskmanager.model.Task;

public interface ITaskDao extends IDao<Task> {
    Task findById(String id);
}
