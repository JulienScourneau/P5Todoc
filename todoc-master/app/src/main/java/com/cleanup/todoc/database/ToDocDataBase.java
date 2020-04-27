package com.cleanup.todoc.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

@Database(entities = {Task.class, Project.class}, version = 1)
public abstract class ToDocDataBase extends RoomDatabase {

    private static ToDocDataBase instance;

    public abstract ProjectDao projectDao();
    public abstract TaskDao taskDao();

    public static ToDocDataBase getInstance(Context context){
        if(instance==null) {
            synchronized (ToDocDataBase.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        ToDocDataBase.class, "Todoc_database")
                        .addCallback(prepopulateDatabase())
                        .build();
            }
        }
        return instance;
    }

    private static Callback prepopulateDatabase(){
        return new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

            }
        };
    }
}