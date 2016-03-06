/*
 * Copyright 2015 Level Money, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.levelmoney.observefragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public interface IObserveActivity {
    void addObserver(ActivityObserver observer);
    void removeObserver(ActivityObserver observer);
    void onCreate(Bundle savedInstanceState);
    void onPostCreate(Bundle savedInstanceState);
    void onActivityResult(final int requestCode, final int resultCode, final Intent data);
    void onStart();
    void onResume();
    void onSaveInstanceState(final Bundle outState);
    void onPause();
    void onStop();
    void onDestroy();
    void onBackPressed();
    boolean onCreateOptionsMenu(final Menu menu);
    boolean onOptionsItemSelected(final MenuItem item);
    boolean dispatchTouchEvent(MotionEvent ev);
}
