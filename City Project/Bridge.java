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
public class Bridge extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private Color color;

    /**
     * Constructor for objects of class Bridge
     */
    public Bridge()
    {
        color = new Color(46,46,46);
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
          page.fillRect(0, 515, 200,10);
          page.fillRect(600, 515, 200,10);
          page.fillRect(300, 475, 200,10);
          page.rotate(30.0);
       }
       
    public void run()
    {
        int running  = 0;
    while(true){
        
            try{
            Thread.sleep(250); //1000 is a second
        }catch (Exception e){}
        
        //System.out.print(x+"-----------------");
        //repaint();
    }
  
    }
}
