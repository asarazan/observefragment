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

public abstract class ActivityObserver {

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onPostCreate(Bundle savedInstanceState) {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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

    public void onDestroy() {
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onFinish() {

    }

    public void onCreateOptionsMenu(Menu menu) {
    }

    public void onOptionsItemSelected(MenuItem item) {
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }
}
