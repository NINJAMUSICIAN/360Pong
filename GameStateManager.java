public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;
	
	public static final int NUMGAMESTATES = 4;
	public static final int PLAYSTATE = 0;
	public static final int LOGOSTATE = 1;
	public static final int MENUSTATE = 2;
	public static final int LOADINGSTATE = 3;
	
	
	public GameStateManager(){
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = PLAYSTATE;
		loadState(currentState);
		
	}
	
	private void loadState(int state){
		if(state == PLAYSTATE){
		       gameStates[state] = new PlayState(this);
		}
	}
	
	private void unloadState(int state){
		gameStates[state] = null;
	}
	
	public void setState(int state){
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	public void update(){
		try{
		gameStates[currentState].update();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void draw(java.awt.Graphics2D g){
		try{
		gameStates[currentState].draw(g);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
