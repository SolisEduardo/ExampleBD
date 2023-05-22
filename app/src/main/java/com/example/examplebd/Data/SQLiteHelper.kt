package com.example.examplebd.Data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.examplebd.Model.QuestionViewModel

class SQLiteHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION
) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "question.db"
        private const val TBL_QUESTION1 = "tbl_question1"
        private const val TBL_QUESTION2 = "tbl_question2"
        private const val TBL_QUESTION3 = "tbl_question3"
        private const val ID = "id"
        private const val QUESTION1 ="question1"
        private const val QUESTION2 ="question2"
        private const val QUESTION3 ="question3"
        private const val QUESTION4 ="question4"
        private const val QUESTION5 ="question5"
        private const val DATE ="date"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        //create table 1
        val createTableSection1 = ("CREATE TABLE " + TBL_QUESTION1 + "("
                + ID + " INTEGER PRIMARY KEY," + QUESTION1 + " TEXT,"
                + QUESTION2 + " TEXT," + QUESTION3 + " TEXT,"
                + QUESTION4 + " TEXT," + QUESTION5 + " TEXT,"
                + DATE + " TEXT" + ")")

        val createTableSection2 = ("CREATE TABLE " + TBL_QUESTION2 + "("
                + ID + " INTEGER PRIMARY KEY," + QUESTION1 + " TEXT,"
                + QUESTION2 + " TEXT," + QUESTION3 + " TEXT,"
                + QUESTION4 + " TEXT," + QUESTION5 + " TEXT,"
                + DATE + " TEXT" + ")")
        val createTableSection3 = ("CREATE TABLE " + TBL_QUESTION3 + "("
                + ID + " INTEGER PRIMARY KEY," + QUESTION1 + " TEXT,"
                + QUESTION2 + " TEXT," + QUESTION3 + " TEXT,"
                + QUESTION4 + " TEXT," + QUESTION5 + " TEXT,"
                + DATE + " TEXT" + ")")

        db?.execSQL(createTableSection1)
        db?.execSQL(createTableSection2)
        db?.execSQL(createTableSection3)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_QUESTION1")
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_QUESTION2")
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_QUESTION3")

        onCreate(db)
    }
    fun insertQuestionSection1(questionModel : QuestionViewModel): Long
    {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,questionModel.id)
        contentValues.put(QUESTION1,questionModel.question1)
        contentValues.put(QUESTION2,questionModel.question2)
        contentValues.put(QUESTION3,questionModel.question3)
        contentValues.put(QUESTION4,questionModel.question4)
        contentValues.put(QUESTION5,questionModel.question5)
        contentValues.put(DATE,questionModel.date)

        val success = db.insert(TBL_QUESTION1,null,contentValues)
        db.close()
        return success
    }
    fun insertQuestionSection2(questionModel : QuestionViewModel): Long
    {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,questionModel.id)
        contentValues.put(QUESTION1,questionModel.question1)
        contentValues.put(QUESTION2,questionModel.question2)
        contentValues.put(QUESTION3,questionModel.question3)
        contentValues.put(QUESTION4,questionModel.question4)
        contentValues.put(QUESTION5,questionModel.question5)
        contentValues.put(DATE,questionModel.date)

        val success = db.insert(TBL_QUESTION2,null,contentValues)
        db.close()
        return success
    }
    fun insertQuestionSection3(questionModel : QuestionViewModel): Long
    {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID,questionModel.id)
        contentValues.put(QUESTION1,questionModel.question1)
        contentValues.put(QUESTION2,questionModel.question2)
        contentValues.put(QUESTION3,questionModel.question3)
        contentValues.put(QUESTION4,questionModel.question4)
        contentValues.put(QUESTION5,questionModel.question5)
        contentValues.put(DATE,questionModel.date)

        val success = db.insert(TBL_QUESTION3,null,contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range", "SuspiciousIndentation")
    fun getAllQuestionSection1(): ArrayList<QuestionViewModel>
    {
        val questionList : ArrayList<QuestionViewModel> =ArrayList()
        val selectQuery = "SELECT * FROM $TBL_QUESTION1"
        val db = this.readableDatabase

        val cursor : Cursor?

        try {
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: Exception)
        {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id: Int
        var question1 : String
        var question2 : String
        var date : String

        if (cursor.moveToFirst())
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                question1 = cursor.getString(cursor.getColumnIndex("question1"))
                question2 = cursor.getString(cursor.getColumnIndex("question2"))
                date = cursor.getString(cursor.getColumnIndex("date"))

                val questions = QuestionViewModel(id=id, question1=question1,question2=question2,date=date)
                questionList.add(questions)
            }while (cursor.moveToNext())
            return questionList
    }
    @SuppressLint("Range", "SuspiciousIndentation")
    fun getAllQuestionSection2(): ArrayList<QuestionViewModel>
    {
        val questionList : ArrayList<QuestionViewModel> =ArrayList()
        val selectQuery = "SELECT * FROM $TBL_QUESTION2"
        val db = this.readableDatabase

        val cursor : Cursor?

        try {
            cursor = db.rawQuery(selectQuery,null)
        }catch (e: Exception)
        {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id: Int
        var question1 : String
        var question2 : String
        var date : String

        if (cursor.moveToFirst())
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                question1 = cursor.getString(cursor.getColumnIndex("question1"))
                question2 = cursor.getString(cursor.getColumnIndex("question2"))
                date = cursor.getString(cursor.getColumnIndex("date"))

                val questions = QuestionViewModel(id=id, question1=question1,question2=question2,date=date)
                questionList.add(questions)
            }while (cursor.moveToNext())
        return questionList
    }
}