package com.yackovich.tulog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TuLogDatabaseHelper extends SQLiteOpenHelper 
{
	private static final String DATABASE_NAME="TuLog";
	private static final int DATABASE_VERSION=1;
	
	/****************** TULOG DATABASE SCHEMA ************************/
	/*================================================================
	 * TABLE workout
	 * A set of exercises to be performed at once.
	 *================================================================ 
	 *  workout_id   : ID of the workout (PK AI)
	 *  workout_name : Description of the workout 
	 *================================================================ */
	private static final String WORKOUT_TABLE_NAME="workout";
	private static final String WORKOUT_TABLE_CREATE=		
     "CREATE TABLE " + WORKOUT_TABLE_NAME + 
	 " (workout_id INT PRIMARY KEY AUTO_INCREMENT, " +
	  " workout_name VARCHAR(32) NOT_NULL)";
	
	/*================================================================
	 * TABLE exercise
	 * An actual performance of an exercise, part of a workout.
	 *================================================================ 
	 *  exercise_id   : ID of the exercise (PK AI)
	 *  exercise_name : short description of the exercise
	 *================================================================ */
	private static final String EXERCISE_TABLE_NAME="exercise";
	private static final String EXERCISE_TABLE_CREATE=
     "CREATE TABLE " + WORKOUT_TABLE_NAME +
	 " (exercise_id INT PRIMARY KEY AUTO_INCREMENT, " +
	 " exercise_name VARCHAR(32) NOT_NULL)";
	
	/*================================================================
	 * TABLE workout_exercise
	 * relationship table of exercises contained in a workout (many-many)
	 *================================================================ 
	 *  workout_id  : ID of the workout
	 *  exercise_id : ID of the exercise
	 *  (PK: workout_id,exercise_id)
	 *================================================================ */
	private static final String WORKOUT_EXERCISE_TABLE_NAME="workout_exercise";
	private static final String WORKOUT_EXERCISE_TABLE_CREATE=
     "CREATE TABLE " + WORKOUT_EXERCISE_TABLE_NAME + " (" +
	 "workout_id INT NOT NULL, " +
	 "exercise_id INT NOT NULL) " +
	 "PRIMARY KEY (workout_id, exercise_id)";
	
	/*================================================================
	 * TABLE exerciseinstance
	 * An actual performance of an exercise, part of a workout.
	 *================================================================ 
	 *  exerciseinstance_id: primary key
	 *  workout_id          : ID of workout that was in progress
	 *  exercise_id         : ID of exercise that was performed
	 *  time                : Date and Time of the performance
	 *  weight              : Amount of weight used.
	 *  duration            : The time under load (TUL) of the exercise in seconds.
	 *  repetitions         : Number of repetitions done (optional, assumed 1)
	 *================================================================ */
	private static final String EXERCISEINSTANCE_TABLE_NAME="exerciseinstance";
	private static final String EXERCISEINSTANCE_TABLE_CREATE=
		"CREATE TABLE " + EXERCISEINSTANCE_TABLE_NAME + " (" +
		"exerciseinstance INT PRIMARY KEY AUTO_INCREMENT, " +
		"workout_id INT NOT NULL, " +
		"exercise_id INT NOT NULL, " +
		"time DATETIME, " +
		"weight INT, " +
		"duration INT, " +
		"repetitions DEFAULT 1)";
													 
	TuLogDatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(WORKOUT_TABLE_CREATE);
		db.execSQL(EXERCISE_TABLE_CREATE);
		db.execSQL(WORKOUT_EXERCISE_TABLE_CREATE);
		db.execSQL(EXERCISEINSTANCE_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		Log.e(this.getClass().getName(), "Upgrade unsupported");
	}
	
}
