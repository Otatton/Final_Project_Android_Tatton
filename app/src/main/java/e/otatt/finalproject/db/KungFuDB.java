package e.otatt.finalproject.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {History.class, Movies.class}, version =1, exportSchema = false)
public abstract class KungFuDB extends RoomDatabase {

    private static KungFuDB instance;

    public static KungFuDB getInstance(Context context){
        if (instance != null) return instance;

        instance = Room.databaseBuilder(context, KungFuDB.class,"user-database")
                .build();
        return instance;
    }

    public abstract MovieDAO movieDAO();
    public abstract HistoryDAO historyDAO();

}
