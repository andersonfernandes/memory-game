package com.snatik.matches.engine;

import android.support.v4.app.Fragment;

import com.snatik.matches.fragments.ThemeSelectFragment;

/**
 * Created by anderson on 14/05/17.
 */

public class ThemeSelectState implements FragmentState {
    @Override
    public Fragment createFragment() {
        return new ThemeSelectFragment();
    }
}
