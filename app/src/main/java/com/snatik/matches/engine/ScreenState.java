package com.snatik.matches.engine;

/**
 * Created by anderson on 14/05/17.
 */

public enum ScreenState {

    MENU(new MenuState()),
    GAME(new GameState()),
    DIFFICULTY(new DifficultyState()),
    THEME_SELECT(new ThemeSelectState());

    private final FragmentState state;

    ScreenState(FragmentState state) {
        this.state= state;
    }

    public FragmentState getState() {
        return this.state;
    }

}
