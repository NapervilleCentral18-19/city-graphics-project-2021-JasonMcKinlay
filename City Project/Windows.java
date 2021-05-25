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
public class Windows extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int rows, cols;
    //private int x,y,w,h;
    private Color color;
    private Rectangle[][] grid;
    private Rectangle building;

    /**
     * Constructor for objects of class Floor
     */
    public Windows(Rectangle build)
    {
        building = build;
        color = Color.white;
        rows = building.getH() / 20;
        cols = building.getW() / 20;
        grid = new Rectangle[rows-2][cols-2];
        
        int x = building.getX() + 10;
        int y = building.getY() + 10;
        for (Rectangle[] row : grid) {
            for (Rectangle col : row) {
                col = new Rectangle(x, y, 20, 20, Color.white);
                x += 40;
            }
            y += 40;
            x = building.getX();
        }
        /*
        x = 0;
        y = 0;
        w = 25;
        h = 25;
        */
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getCols()
    {
        return cols;
    }
    
    public Rectangle[][] getGrid()
    {
        return grid;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method 
        // ...
        draw(g2);
        
        
    }
    
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void flash(int running)
    {
        // update the objects in the cityscape so they are animated
        // ...
        //height = 100 +generator.nextInt(45);
        
        if (running % 2 == 0)
            color = Color.white;
        else
            color = Color.black;
        
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }
    
       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)
       {
          /*for (Rectangle[] row : grid) {
            for (Rectangle col : row) {
                page.setColor(color);
                page.fillRect(col.getX(), col.getY(), col.getW(), col.getH());
                }
            }
          */
          /*int row = 0;
          int col = 0;
          if (row == grid.length-1 || col == grid.length-1) {
              return; }
          else {
              page.setColor(color);
              page.fillRect(grid[row][col].getX(), grid[row][col].getY(), 25, 25);
              if (col == grid.length-1) {
                  row++;
                  col = 0;
              }
              else {
                  col++;
              }
          }*/
          page.setColor(color);
          page.fillRect(building.getX(), building.getY(), 20, 20);
       }
       
       //public void drawGrid(Graphics2D page)
       
    public void run()
    {
        int running  = 0;
    while(true){
        
        flash(running);
        running ++;
            try{
            Thread.sleep(500); //1000 is a second
        }catch (Exception e){}
        
        //System.out.print(x+"-----------------");
        //repaint();
    }
  
    }
}
