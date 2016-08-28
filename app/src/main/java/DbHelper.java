import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void addList(ToDoList lists){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LISTS_NAME,lists.getLists());
        db.insert(TABLE_LISTS, null, values);
        db.close();
    }
    public void addTask(ToDoList tasks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TASKS_NAME,tasks.getTasks());
        db.insert(TABLE_TASKS, null, values);
        db.close();
    }



    public ToDoList getList(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LISTS, new String[] { KEY_LISTS_ID,
        KEY_LISTS_NAME}, KEY_LISTS_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        ToDoList listsData = new ToDoList(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return listsData;
    }
    public ToDoList getTasks(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TASKS, new String[] { KEY_TASKS_ID,
                        KEY_TASKS_NAME}, KEY_TASKS_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        ToDoList tasksData = new ToDoList(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return tasksData;
    }


    public int updateList(ToDoList toDoList) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LISTS_NAME, toDoList.getLists());
        return db.update(TABLE_LISTS, values, KEY_LISTS_ID + " =?",
                new String[]{String.valueOf(toDoList.getId())});
    }

}
