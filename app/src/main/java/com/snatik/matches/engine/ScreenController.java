package com.snatik.matches.engine;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.snatik.matches.R;
import com.snatik.matches.common.Shared;
import com.snatik.matches.events.ui.ResetBackgroundEvent;
import com.snatik.matches.fragments.DifficultySelectFragment;
import com.snatik.matches.fragments.GameFragment;
import com.snatik.matches.fragments.MenuFragment;
import com.snatik.matches.fragments.ThemeSelectFragment;

public class ScreenController {

	private static ScreenController mInstance = null;
	private static List<ScreenState> openedScreens = new ArrayList<>();
	private FragmentManager mFragmentManager;

	private ScreenController() {
	}

	public static ScreenController getInstance() {
		if (mInstance == null) {
			mInstance = new ScreenController();
		}
		return mInstance;
	}

//	public enum Screen {
//		MENU(new MenuState()),
//		GAME(new GameState()),
//		DIFFICULTY(new DifficultyState()),
//		THEME_SELECT(new ThemeSelectState());
//
//		private final FragmentState state;
//
//		Screen(FragmentState state) {
//			this.state= state;
//		}
//
//		public FragmentState getState() {
//			return this.state;
//		}
//	}
	
	public static ScreenState getLastScreen() {
		return openedScreens.get(openedScreens.size() - 1);
	}

	public void openScreen(ScreenState screen) {
		mFragmentManager = Shared.activity.getSupportFragmentManager();
		
		if (screen == ScreenState.GAME && openedScreens.get(openedScreens.size() - 1) == ScreenState.GAME) {
			openedScreens.remove(openedScreens.size() - 1);
		} else if (screen == ScreenState.DIFFICULTY && openedScreens.get(openedScreens.size() - 1) == ScreenState.GAME) {
			openedScreens.remove(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
		}
		Fragment fragment = screen.getState().createFragment();
		FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, fragment);
		fragmentTransaction.commit();
		openedScreens.add(screen);
	}

	public boolean onBack() {
		if (openedScreens.size() > 0) {
			ScreenState screenToRemove = openedScreens.get(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
			if (openedScreens.size() == 0) {
				return true;
			}
			ScreenState screen = openedScreens.get(openedScreens.size() - 1);
			openedScreens.remove(openedScreens.size() - 1);
			openScreen(screen);
			if ((screen == ScreenState.THEME_SELECT || screen == ScreenState.MENU) &&
					(screenToRemove == ScreenState.DIFFICULTY || screenToRemove == ScreenState.GAME)) {
				Shared.eventBus.notify(new ResetBackgroundEvent());
			}
			return false;
		}
		return true;
	}

}
