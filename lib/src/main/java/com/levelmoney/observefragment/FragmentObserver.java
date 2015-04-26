package com.levelmoney.observefragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Aaron Sarazan on 4/26/15
 * Copyright(c) 2015 Level, Inc.
 */
public abstract class FragmentObserver {
    public void setArguments(Bundle args) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onAttach(Activity activity) {
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroyView() {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onOptionsItemSelected(MenuItem item) {
    }
}
