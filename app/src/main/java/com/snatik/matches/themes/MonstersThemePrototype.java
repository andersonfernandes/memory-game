package com.snatik.matches.themes;

/**
 * Created by anderson on 14/05/17.
 */

public class MonstersThemePrototype extends ThemePrototype {

    public MonstersThemePrototype() {
        id = 2;
        name = "Mosters";
        backgroundImageUrl = URI_DRAWABLE + "back_horror";

        generateDrawbles("mosters_%d", 40);
    }

    @Override
    public ThemePrototype clone() {
        return new MonstersThemePrototype();
    }
}
