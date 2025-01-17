package com.reschikov.geekbrains.homework;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OneFragment extends Fragment {

	private static final String TAG = "OneFragment ";

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		Log.i(TAG, "onAttach: ");
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate: ");
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.one_fragment, container, false);
		Log.i(TAG, "onCreateView: ");
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.i(TAG, "onViewCreated: ");
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(TAG, "onActivityCreated: ");
	}

	@Override
	public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		Log.i(TAG, "onViewStateRestored: ");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.i(TAG, "onStart: ");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(TAG, "onResume: ");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG, "onPause: ");
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState: ");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG, "onStop: ");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.i(TAG, "onDestroyView: ");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy: ");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		Log.i(TAG, "onDetach: ");
	}
}
