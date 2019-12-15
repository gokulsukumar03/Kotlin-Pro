package com.kotlin.demo.base.room

import android.arch.lifecycle.LiveData
import androidx.room.*
import bergco.se.mvvm.model.Task

@Dao
interface TasksDAO {
    @Query("SELECT * FROM Tasks")
    suspend fun getTasks(): List<Task>

    @Query("SELECT * FROM Tasks")
    fun observeTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Tasks WHERE groupId = :groupId")
    fun observeTasksByGroupId(groupId: String): LiveData<List<Task>>

    @Query("SELECT * FROM Tasks WHERE groupId = :groupId")
    suspend fun getTasksByGroupId(groupId: String): List<Task>

    @Query("SELECT * FROM Tasks WHERE taskId = :taskId")
    suspend fun getTaskById(taskId: String): Task?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(task: Task): Int

    @Query("DELETE FROM Tasks WHERE taskId = :taskId")
    suspend fun deleteTaskById(taskId: String): Int


}
