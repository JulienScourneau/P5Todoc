package com.cleanup.todoc.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.ProjectRepository;
import com.cleanup.todoc.repository.TaskRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    private final TaskRepository mTaskRepository;
    private final ProjectRepository mProjectRepository;
    private final Executor mExecutor;

    public TaskViewModel(TaskRepository taskRepository, ProjectRepository projectRepository, Executor executor) {
        this.mTaskRepository = taskRepository;
        this.mProjectRepository = projectRepository;
        this.mExecutor = executor;
    }

    public LiveData<Project> getProjectList(){
        return mProjectRepository.getProjectList();
    }

    public LiveData<Project> getProject(long projectId){
        return mProjectRepository.getProject(projectId);
    }

    public LiveData<List<Task>> getTask(){
        return mTaskRepository.getTask();
    }

    public void createTask(final Task task){
        mExecutor.execute(() -> mTaskRepository.createTask(task));
    }

    public void deleteTask(final long taskId){
        mExecutor.execute(() -> mTaskRepository.deleteTask(taskId));
    }
}
