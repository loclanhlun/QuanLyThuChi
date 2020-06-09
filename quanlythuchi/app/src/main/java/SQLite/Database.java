package SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context)
    {
        super(context,"assignment14.sqlite", null, 1) ;

    }
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE THU(KHOANTHU NVARCHAR, LOAITHU NVARCHAR, SOTIEN INT, NGAYTHANG NVARCHAR, IDTHU INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("CREATE TABLE CHI(KHOANCHI NVARCHAR, LOAICHI NVARCHAR, SOTIEN INT, NGAYTHANG NVARCHAR, IDCHI INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS THU");
        db.execSQL("DROP TABLE IF EXISTS CHI");
        onCreate(db);
    }
}
