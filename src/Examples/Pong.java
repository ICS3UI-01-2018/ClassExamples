package Examples;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author lamon
 */
public class Pong extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));

    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    // paddle variables
    int paddleWidth = 50;
    int paddleHeight = 100;

    int player1X = 50;
    int player1Y = HEIGHT / 2 - paddleHeight / 2;

    int player2X = WIDTH - 50 - paddleWidth;
    int player2Y = HEIGHT / 2 - paddleHeight / 2;

    int paddleSpeed = 4;

    // control variables
    boolean player1Up = false;
    boolean player1Down = false;
    boolean player2Up = false;
    boolean player2Down = false;

    // ball variables
    int ballSize = 20;
    int ballX = WIDTH / 2 - ballSize / 2;
    int ballY = HEIGHT / 2 - ballSize / 2;
    int ballSpeed = 2;

    int directionX = 1;
    int directionY = 1;

    // score vairables
    int player1Score = 0;
    int player2Score = 0;
    
    Font scoreFont = new Font("arial", Font.BOLD, 42);

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Pong() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);

        // Set things up for the game at startup
        preSetup();

        // Start the game loop
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        g.setColor(Color.BLACK);
        // draw the background in black
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // draw the paddles
        g.setColor(Color.WHITE);
        g.fillRect(player1X, player1Y, paddleWidth, paddleHeight);
        g.fillRect(player2X, player2Y, paddleWidth, paddleHeight);

        // draw the ball
        g.fillRect(ballX, ballY, ballSize, ballSize);
        
        // draw score
        g.setFont(scoreFont);
        g.drawString("" + player1Score, 100, 50);
        g.drawString("" + player2Score, 650, 50);

        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {

        // move the ball
        ballX = ballX + directionX * ballSpeed;
        ballY = ballY + directionY * ballSpeed;

        // did ball hit the wall?
        // bottom wall
        if (ballY + ballSize >= HEIGHT) {
            directionY = -1;
            // hit top of screen
        } else if (ballY <= 0) {
            directionY = 1;
        }

        // move the player
        movePlayer();

        
        // ball hit paddle
        if(collides(player1X, player1Y, paddleWidth, paddleHeight, ballX, ballY, ballSize, ballSize)){
            directionX = 1;
        }
        if(collides(player2X, player2Y, paddleWidth, paddleHeight, ballX, ballY, ballSize, ballSize)){
            directionX = -1;
        }
        
        
        // did the player score?
        scorePoints();
        
        
    }
    
    public void movePlayer(){
        if(player1Up && player1Y > 0){
            player1Y = player1Y - paddleSpeed;
        }
        if(player1Down && player1Y + paddleHeight < HEIGHT){
            player1Y = player1Y + paddleSpeed;
        }
        
        if(player2Up){
            player2Y = player2Y - paddleSpeed;
        }
        if(player2Down){
            player2Y = player2Y + paddleSpeed;
        }
    }
    
    
    // collision
    public boolean collides(int aX, int aY, int aW, int aH, int bX, int bY, int bW, int bH){
        if((aX + aW < bX || aX > bX + bW || aY + aH < bY || aY > bY + bH)){
            return false;
        }else{
            return true;
        }
    }

    // method to check if someone scored
    // move ball back to center
    public void scorePoints() {
        // did ball hit the right
        if (ballX + ballSize >= WIDTH) {
            // increase player1 score
            player1Score++;
            // move ball to center
            ballX = WIDTH / 2 - ballSize / 2;
            ballY = HEIGHT / 2 - ballSize / 2;
        } else if (ballX <= 0) {
            // increase player 2 score
            player2Score++;
            // center the ball
            ballX = WIDTH / 2 - ballSize / 2;
            ballY = HEIGHT / 2 - ballSize / 2;
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            // determine the key pressed
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W) {
                player1Up = true;
            } else if (key == KeyEvent.VK_S) {
                player1Down = true;
            } else if (key == KeyEvent.VK_UP) {
                player2Up = true;
            } else if (key == KeyEvent.VK_DOWN) {
                player2Down = true;
            }

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            // determine the key pressed
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W) {
                player1Up = false;
            } else if (key == KeyEvent.VK_S) {
                player1Down = false;
            } else if (key == KeyEvent.VK_UP) {
                player2Up = false;
            } else if (key == KeyEvent.VK_DOWN) {
                player2Down = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        Pong game = new Pong();
    }
}
