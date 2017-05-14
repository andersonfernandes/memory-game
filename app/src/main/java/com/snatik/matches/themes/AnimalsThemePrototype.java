package com.snatik.matches.themes;

/**
 * Created by anderson on 13/05/17.
 */

public class AnimalsThemePrototype extends ThemePrototype {

    public AnimalsThemePrototype() {
        id = 1;
		name = "Animals";
		backgroundImageUrl = URI_DRAWABLE + "back_animals";

        generateDrawbles("animals_%d", 28);
    }

    @Override
    public ThemePrototype clone() {
        return new AnimalsThemePrototype();
    }
}
