package com.example.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);

    @Query("SELECT * FROM users WHERE  id=:id")
    public User findUserById(int id);
}
