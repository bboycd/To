import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_LISTS = "lists";
    public static final String TABLE_TASKS = "tasks";

    private static final String KEY_LISTS_ID = "lists id";
    private static final String KEY_TASKS_ID = "tasks id";

    private static final String KEY_LISTS_NAME = "lists name";
    private static final String KEY_TASKS_NAME = "tasks name";


    private DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LISTS_TABLE = "CREATE LISTS TABLE" + TABLE_LISTS + "(" +
                KEY_LISTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_LISTS_NAME + " TEXT" +")";

        String CREATE_TASKS_TABLE = "CREATE TASKS TABLE" + TABLE_TASKS + "(" +
                KEY_TASKS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_TASKS_NAME + " TEXT" +")";
        db.execSQL(CREATE_TASKS_TABLE);
        db.execSQL(CREATE_LISTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LISTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);

    }



}
