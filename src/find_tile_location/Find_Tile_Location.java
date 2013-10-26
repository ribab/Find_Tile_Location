
package find_tile_location;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



/**
 * @author Richard Barella Jr.
 * @author Adam Bennett
 * @author Ryan Slyter
 */

public class Find_Tile_Location {
	
    // Main function
    public static void main(String[] args) throws IOException {

    	final String TILESET_FILE_NAME = "images/tileset.png";
    	
        // create game
        org.newdawn.slick.BasicGame game = new org.newdawn.slick.BasicGame("zed") {
        	
        	Image tiles;
        	
            // Test-level
            //Level_Manager test;
            // Game Initialization
            @Override
            public void init(GameContainer gc) throws SlickException {

            	tiles = new Image(TILESET_FILE_NAME);
            	
            	//test = new Level_Manager();
            }

            // Game Updates
            @Override
            public void update(GameContainer gc, int delta) throws SlickException {
            	
                 gc.setVSync(true);
            }
            
            // Game Rendering
            @Override
            public void render(GameContainer gc, Graphics g) throws SlickException {
                
                g.drawImage(tiles, 0, 0);
                
                g.drawString(gc.getInput().getMouseX()/16 + ", " + gc.getInput().getMouseY()/16, 580, 10);
            }
        };
        
        BufferedImage bimg = ImageIO.read(new File(TILESET_FILE_NAME));
        int width          = bimg.getWidth();
        int height         = bimg.getHeight();
        
        AppGameContainer container;
        try {
            container = new AppGameContainer(game, width + 60, height, false); // create game instance
            container.setShowFPS(false);
            container.start();                      // start game instance
        } catch (SlickException ex) { // catch exceptions
            ex.printStackTrace();
            Logger.getLogger(Find_Tile_Location.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
