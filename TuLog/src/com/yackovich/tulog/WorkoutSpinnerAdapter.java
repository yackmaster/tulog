package com.yackovich.tulog;

import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/**
 * Retrieves the workouts available, and provides them to a spinner adapter.
 * @author John C. Yackovich
 *
 */
public class WorkoutSpinnerAdapter implements SpinnerAdapter
{
	SharedPreferences prefs;
	public WorkoutSpinnerAdapter(SharedPreferences a_prefs)
	{
		prefs = a_prefs;
		populateWorkouts();
	}
	
	public void populateWorkouts()
	{
		int workoutCount = prefs.getInt("workouts.count", 0);
		for (int i = 0; i < workoutCount; i++)
		{
			String workoutName = prefs.getString("workout."+i, "UNDEFINED");
			
			
		}
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
