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
public class Cloud extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y;
    private Color color;

    /**
     * Constructor for objects of class Floor
     */
    public Cloud(int myX, int myY)
    {
        x = myX;
        y = myY;
        color = Color.white;
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
          page.fillOval(x, y, 40, 20);
          page.fillOval(x+10, y-10, 20, 20);
       }
       
       public void move ()
       {
           if (x == 800)
               x = 0;
           else
               x += 5;
           repaint();
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
