package e.otatt.finalproject.db;


import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MovieDAO {

    @Query("select * from Movies")
    LiveData<List<Movies>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movies movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Movies... movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ArrayList<Movies> movies);

    @Update
    void update(Movies movies);

    @Delete
    void delete(Movies movies);

}
