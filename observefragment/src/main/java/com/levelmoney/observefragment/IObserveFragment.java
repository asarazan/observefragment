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

package com.levelmoney.observefragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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
