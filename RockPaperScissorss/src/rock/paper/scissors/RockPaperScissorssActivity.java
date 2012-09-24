package rock.paper.scissors;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;

public class RockPaperScissorssActivity extends Activity {
    /** Called when the activity is first created. */
	
	private TextView resultText, bodyText;
	private Button play, reset;
	private ImageButton scissors, paper, rock;
	private int paperimg, paper_pressedimg, scissorsimg, scissors_pressedimg, rockimg, rock_pressedimg;
	private ImageView compSciss, compPaper, compRock;
	Random rand = new Random();
	int compChoice = 0;
	String pChoice ="";
	String cChoice = "";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Initialize();
    }
    
    /** initialize all of the components*/
    private void Initialize()
    {
    	play = (Button) findViewById(R.id.playButton);
    	reset = (Button) findViewById(R.id.resetButton);
    	resultText = (TextView) findViewById(R.id.resultText);
    	bodyText = (TextView) findViewById(R.id.body);
    	scissors = (ImageButton) findViewById(R.id.scissorsButton);
    	paper = (ImageButton) findViewById(R.id.paperButton);
    	rock = (ImageButton) findViewById(R.id.rockButton);
    	compSciss = (ImageView) findViewById(R.id.compScissorsVw);
    	compPaper = (ImageView) findViewById(R.id.compPaperVw);
    	compRock = (ImageView) findViewById(R.id.compRockVw);
    	paperimg = R.raw.paper;
    	paper_pressedimg = R.raw.paper_pressed;
    	scissorsimg = R.raw.scissors;
    	scissors_pressedimg = R.raw.scissors_pressed;
    	rockimg = R.raw.rock1;
    	rock_pressedimg = R.raw.rock1_pressed;
    	bodyText.setText("How to Play: \nClick on the move you want to make\nand click the play button!");
    	
    	/**set the button Listeners*/
    	play.setOnClickListener(new OnClickListener(){
    		public void onClick(View arg0){
    			play();
    		}
    	});
    	
    	reset.setOnClickListener(new OnClickListener(){
    		public void onClick(View arg0){
    			/**
    			 * Fill this in.
    			 * What should go here?
    			 */
    		}
    	});
    	
    	scissors.setOnClickListener(new OnClickListener(){
    		public void onClick(View arg0){	
    				scissors.setImageResource(scissors_pressedimg);
    				paper.setImageResource(paperimg);
    				rock.setImageResource(rockimg);
    				pChoice = "S";
    				play.setEnabled(true);
    		}
    	});
    	
    	paper.setOnClickListener(new OnClickListener(){
    		public void onClick(View arg0){
    				paper.setImageResource(paper_pressedimg);
    				scissors.setImageResource(scissorsimg);
    				rock.setImageResource(rockimg);
    				pChoice = "P";
    				play.setEnabled(true);
    		}
    	});
    	
    	rock.setOnClickListener(new OnClickListener(){
    		public void onClick(View arg0){
    			rock.setImageResource(rock_pressedimg);
    			scissors.setImageResource(scissorsimg);
    			paper.setImageResource(paperimg);
    			pChoice = "R";
    			play.setEnabled(true);
    		}
    	});
    }
    
    /**The method that chooses the computer's move and compares
     * 	to the player's move.
     */
    public void play()
    {
    	compChoice = rand.nextInt(3);
		
		if(compChoice == 0)
		{
			cChoice = "R";
			compRock.setImageResource(rock_pressedimg);
		}
			
		
		else if(compChoice == 1){
			cChoice = "P";
			compPaper.setImageResource(paper_pressedimg);
		}
		
		else if(compChoice == 2)
		{
			cChoice = "S";
			compSciss.setImageResource(scissors_pressedimg);
			}
			
		check();
    }
    
    /**
     * Compares the Computer's and the Player's moves.
     */
    public void check()
    {
    	if(pChoice == "R")
    	{
    		if(cChoice == "R")
    			resultText.setText("Draw");
    		
    		else if(cChoice == "P")
    			resultText.setText("You Lose");

    		else if(cChoice == "S")
    			resultText.setText("You Win");
    		
    	}
    	
    	else if(pChoice == "P")
    	{
    		if(cChoice == "R")
    			resultText.setText("You win");
    		
    		else if(cChoice == "P")
    			resultText.setText("Draw");

    		else if(cChoice == "S")
    			resultText.setText("You Lose");
    		
    	}
    	
    	else if(pChoice == "S")
    	{
    		if(cChoice == "R")
    			resultText.setText("You Lose");
    		
    		else if(cChoice == "P")
    			resultText.setText("You Win");
    		
    		else if(cChoice == "S")
    			resultText.setText("Draw");
			
		}
		gameOver();
    }
    
    
    /**
     * Runs at the end of each round. Disables all of the buttons
     * except for the reset button.
     */
    public void gameOver()
    {
    	play.setEnabled(false);
		scissors.setEnabled(false);
		rock.setEnabled(false);
		paper.setEnabled(false);
    }
}