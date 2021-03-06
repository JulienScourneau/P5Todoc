package com.cleanup.todoc.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

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

                ContentValues contentValues = new ContentValues();
                Project[] projectList = Project.getAllProjects();

                for (int i=0;i<=2; i++ ){

                    Project mProject = projectList[i];

                    contentValues.put("id",mProject.getId());
                    contentValues.put("name",mProject.getName());
                    contentValues.put("color",mProject.getColor());

                    db.insert("Project", OnConflictStrategy.IGNORE,contentValues);
                }
            }
        };
    }
}
