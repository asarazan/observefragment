package com.levelmoney.observefragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Aaron Sarazan on 4/28/15
 * Copyright(c) 2015 Level, Inc.
 */
public interface IObserveFragment {
    void addObserver(FragmentObserver observer);
    void removeObserver(FragmentObserver observer);
    void setArguments(final Bundle args);
    void onActivityResult(final int requestCode, final int resultCode, final Intent data);
    void onAttach(final Activity activity);
    void onViewCreated(final View view, final Bundle savedInstanceState);
    void onStart();
    void onResume();
    void onSaveInstanceState(final Bundle outState);
    void onPause();
    void onStop();
    void onDestroyView();
    void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater);
    boolean onOptionsItemSelected(final MenuItem item);
}
