package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Task;


@Dao
public interface TaskDao {

   // @Query("SELECT * FROM Task")
   // LiveData<Task> getTask();
//
   // @Insert
   // void insertTask(Task task);
//
   // @Query("DELETE FROM Task WHERE id = :taskId")
   // int deleteTask(long taskId);


}
