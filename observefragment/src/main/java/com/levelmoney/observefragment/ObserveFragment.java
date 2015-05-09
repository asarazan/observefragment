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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.LinkedHashSet;
import java.util.Set;

public class ObserveFragment extends Fragment implements IObserveFragment {
    private static final String TAG = ObserveFragment.class.getSimpleName();

    private final Set<FragmentObserver> mObservers = new LinkedHashSet<>();

    public ObserveFragment() {}

    @SuppressLint("ValidFragment")
    protected ObserveFragment(Set<FragmentObserver> observers) {
        this();
        mObservers.addAll(observers);
    }

    @Override
    public void addObserver(FragmentObserver observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(FragmentObserver observer) {
        mObservers.remove(observer);
    }

    @Override
    public void setArguments(final Bundle args) {
        super.setArguments(args);
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.setArguments(args);
            }
        });
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onActivityResult(requestCode, resultCode, data);
            }
        });
    }

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onAttach(activity);
            }
        });
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onViewCreated(view, savedInstanceState);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onStart();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onResume();
            }
        });
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onSaveInstanceState(outState);
            }
        });
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onPause();
            }
        });
        super.onPause();
    }

    @Override
    public void onStop() {
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onStop();
            }
        });
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onDestroyView();
            }
        });
        super.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onCreateOptionsMenu(menu, inflater);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        boolean retval = super.onOptionsItemSelected(item);
        foreach(new RunnableArg1<FragmentObserver>() {
            @Override
            public void run(FragmentObserver input) {
                input.onOptionsItemSelected(item);
            }
        });
        return retval;
    }

    private void foreach(RunnableArg1<FragmentObserver> fn) {
        for(FragmentObserver o : mObservers) {
            fn.run(o);
        }
    }
}
