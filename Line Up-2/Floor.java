
/**
 * Write a description of class Floor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

    import java.awt.*;
    import java.util.*;

    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
    
public class Floor extends JComponent
{
    // instance variables - replace the example below with your own
    private int x,y,w,h;

    /**
     * Constructor for objects of class Floor
     */
    public Floor()
    {
        // initialise instance variables
        x = 50;
        y = 125;
        w = 250;
        h = 50;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        // invoke the draw method
        draw(g2);
    }
    
    public void draw(Graphics2D page)
    {
        page.setColor(Color.black);
        page.fillRect(x,y,w,h);
    }
    
    /**
     * Animate the object by updating the object's attributes
     * such that they appear to be animated when they are next drawn
     */
    public void setX(int running)
    {
        if (running % 2 == 0)
            x += 20;
        else
            x -= 20;
    }
}
