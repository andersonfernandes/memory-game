package com.snatik.matches.model;

import com.snatik.matches.themes.ThemePrototype;

/**
 * This is instance of active playing game
 * 
 * @author sromku
 */
public class Game {

	/**
	 * The board configuration
	 */
	public BoardConfiguration boardConfiguration;

	/**
	 * The board arrangment
	 */
	public BoardArrangment boardArrangment;

	/**
	 * The selected theme
	 */
	public ThemePrototype theme;

	public GameState gameState;

}
