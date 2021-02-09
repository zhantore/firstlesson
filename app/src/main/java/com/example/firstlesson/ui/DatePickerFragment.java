package com.example.firstlesson.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerFragment extends DialogFragment {

    String TAG = "DatePickerFragment";
    Calendar calendar;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Log.v(TAG, "onCreateDialog()");
        calendar = Calendar.getInstance(Locale.getDefault());

        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), y, m, d);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.v(TAG, "onAttach()");

        calendar = Calendar.getInstance(Locale.getDefault());
        try {
            Intent calendarIntent = new Intent(Intent.ACTION_EDIT);
            calendarIntent.setType("vnd.android.cursor.item/event");
            calendarIntent.putExtra("beginTime", calendar.getTimeInMillis());
            calendarIntent.putExtra("allDay", true);
            calendarIntent.putExtra("rule", "FREQ=YEARLY");
            calendarIntent.putExtra("endTime", calendar.getTimeInMillis() * 1000 * 60);
            calendarIntent.putExtra("title", "This is the end of the class");
            calendarIntent.putExtra("eventTimezone", "UTC/GMT +6:00");
            startActivity(calendarIntent);
        }catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(TAG, "onDetach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate()");
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        Log.v(TAG, "onGetLayoutInflater()");
        return super.onGetLayoutInflater(savedInstanceState);
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        Log.v(TAG, "onCancel()");
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.v(TAG, "onDismiss()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(TAG, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "onSaveInstanceState()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(TAG, "onDestroyView()");
    }
}
