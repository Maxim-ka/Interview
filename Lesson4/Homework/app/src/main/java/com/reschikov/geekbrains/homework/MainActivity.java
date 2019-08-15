package com.reschikov.geekbrains.homework;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
	
	private static final String TAG = "MainActivity "; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null){
			getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment, new OneFragment())
				.commit();
		}
		Log.i(TAG, "onCreate: ");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "onRestoreInstanceState: ");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart: ");
	}

	@Override
	protected void onPostCreate(@Nullable Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		Log.i(TAG, "onPostCreate: ");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume: ");
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		Log.i(TAG, "onPostResume: ");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause: ");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState: ");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop: ");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart: ");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy: ");
	}
}
