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

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.levelmoney.observefragment.RunnableArg1;

import java.util.LinkedHashSet;
import java.util.Set;

public class ObserveAppCompatActivity extends AppCompatActivity implements IObserveActivity {
    private static final String TAG = ObserveAppCompatActivity.class.getSimpleName();

    private final Set<ActivityObserver> mObservers = new LinkedHashSet<>();

    public ObserveAppCompatActivity() {}

    @SuppressLint("ValidFragment")
    protected ObserveAppCompatActivity(Set<ActivityObserver> observers) {
        mObservers.addAll(observers);
    }

    @Override
    public void addObserver(ActivityObserver observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(ActivityObserver observer) {
        mObservers.remove(observer);
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onCreate(savedInstanceState);
            }
        });
    }

    @Override
    public void onPostCreate(final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onPostCreate(savedInstanceState);
            }
        });
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onActivityResult(requestCode, resultCode, data);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onStart();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onResume();
            }
        });
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onSaveInstanceState(outState);
            }
        });
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onPause();
            }
        });
        super.onPause();
    }

    @Override
    public void onStop() {
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onStop();
            }
        });
        super.onStop();
    }

    @Override
    public void onDestroy() {
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onDestroy();
            }
        });
        super.onDestroy();
    }

    @Override
    public void finish() {
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onFinish();
            }
        });
        super.finish();
    }

    @Override
    public void onBackPressed() {
        final boolean[] handled = { false };
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                if (!handled[0] && input.onBackPressed()) {
                    handled[0] = true;
                }
            }
        });
        if (!handled[0]) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        boolean retval = super.onCreateOptionsMenu(menu);
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onCreateOptionsMenu(menu);
            }
        });
        return retval;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        boolean retval = super.onOptionsItemSelected(item);
        foreach(new RunnableArg1<ActivityObserver>() {
            @Override
            public void run(ActivityObserver input) {
                input.onOptionsItemSelected(item);
            }
        });
        return retval;
    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        for (ActivityObserver observer : mObservers) {
            if (observer.dispatchTouchEvent(ev)) return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    private void foreach(RunnableArg1<ActivityObserver> fn) {
        for(ActivityObserver o : mObservers) {
            fn.run(o);
        }
    }
}
