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
public interface HistoryDAO {

    @Query("select * from History")
    LiveData<List<History>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(History history);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(History... histories);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ArrayList<History> histories);

    @Update
    void update(History history);

    @Delete
    void delete(History history);


}
