package lab4.lab.com.lab4.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DB(private val mCtx: Context) {
    private var mDBHelper: DBHelper? = null
    private var mDB: SQLiteDatabase? = null

    // получить все данные из таблицы DB_TABLE
    val allData: Cursor
        get() = mDB!!.query(DB_TABLE, null, null, null, null, null, null)

    // открыть подключение
    fun open() {
        mDBHelper = DBHelper(mCtx, DB_NAME, null, DB_VERSION)
        mDB = mDBHelper!!.writableDatabase
    }

    // закрыть подключение
    fun close() {
        if (mDBHelper != null) mDBHelper!!.close()
    }

    // добавить запись в DB_TABLE
    fun addRec(text: String) {
        val cv = ContentValues()
        cv.put("text", text)
        mDB!!.insert(DB_TABLE, null, cv)
    }

    // обновить запись в DB_TABLE
    fun update(id: Long, text: String):Boolean {
        if(checkNoteExisting(id)) {
            val cv = ContentValues()
            cv.put("text", text)
            mDB!!.update(DB_TABLE, cv, "id = ?",
                    arrayOf(id.toString()))
            return true
        }
        return false
    }

    fun checkNoteExisting(id:Long):Boolean
    {
        val cursor = mDB!!.query(DB_TABLE, null, "id = "+id, null, null, null, null)

        if(cursor.count==0) {
            cursor.close()
            return false
        }

        cursor.close()
        return true
    }
    // удалить запись из DB_TABLE
    fun delRec(id: Long):Boolean {
        if(checkNoteExisting(id)) {
            mDB!!.delete(DB_TABLE, "id = " + id, null)
            return true
        }
        return false
    }

    // удалить все записи из DB_TABLE
    fun delAll() {
        mDB!!.delete(DB_TABLE, null, null)
    }

    companion object {
        private val DB_NAME = "mydb"
        private val DB_VERSION = 1
        private val DB_TABLE = "notes"
    }
}