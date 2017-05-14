package com.snatik.matches.engine;

import android.support.v4.app.Fragment;

import com.snatik.matches.fragments.MenuFragment;

/**
 * Created by anderson on 14/05/17.
 */

public class MenuState implements FragmentState {
    @Override
    public Fragment createFragment() {
        return new MenuFragment();
    }
}
