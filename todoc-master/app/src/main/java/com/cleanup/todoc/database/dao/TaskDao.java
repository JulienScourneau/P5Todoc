package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.cleanup.todoc.model.Task;

import java.util.List;


@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTask();

    @Insert
    void createTask(Task task);

    @Query("DELETE FROM Task WHERE id = :taskId")
    int deleteTask(long taskId);


}
