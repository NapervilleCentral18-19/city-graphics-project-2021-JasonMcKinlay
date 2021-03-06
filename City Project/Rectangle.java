import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y,w,h;
    private Color color;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(int myX, int myY, int myW, int myH, Color myColor)
    {
        x = myX;
        y = myY;
        w = myW;
        h = myH;
        color = myColor;
    }
    
    /**
     * Getters so that the window class can know the location/scale of the building
     */
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getW()
    {
        return w;
    }
    
    public int getH()
    {
        return h;
    }
    
    public void setColor(Color myColor)
    {
        color = myColor;
        repaint();
    }
    
    public Color getColor()
    {
        return color;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method 
        // ...
        draw(g2);
        
        
    }
    
    
       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)
       {
          page.setColor(color);
          page.fillRect(x, y, w, h);
       }
       
    public void run()
    {
        int running  = 0;
    while(true){
        
        if(running % 2 == 0)
            x +=20;
        else
            x -= 20;
        running ++;
            try{
            Thread.sleep(250); //1000 is a second
        }catch (Exception e){}
        
        System.out.print(x+"-----------------");
        //repaint();
    }
  
    }
}
