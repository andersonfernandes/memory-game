package com.snatik.matches.themes;

import android.graphics.Bitmap;

import com.snatik.matches.common.Shared;
import com.snatik.matches.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 13/05/17.
 */

public abstract class ThemePrototype {

    protected int id;
    protected String name;
    protected String backgroundImageUrl;
    protected List<String> tileImageUrls;

    public static final String URI_DRAWABLE = "drawable://";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public List<String> getTileImageUrls() {
        return tileImageUrls;
    }

    public void generateDrawbles(String format, int size) {
        tileImageUrls = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            tileImageUrls.add(URI_DRAWABLE + String.format(format, i));
        }
    }

    public Bitmap getBackgroundImage() {
        String drawableResourceName = backgroundImageUrl.substring(URI_DRAWABLE.length());
        int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
        Bitmap bitmap = Utils.scaleDown(drawableResourceId, Utils.screenWidth(), Utils.screenHeight());
        return bitmap;
    }

    public abstract ThemePrototype clone();

}
