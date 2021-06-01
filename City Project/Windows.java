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
    private Color light, dark;
    private Rectangle[][] grid;
    private Rectangle building;

    /**
     * Constructor for objects of class Windows
     */
    public Windows(Rectangle build, Color brightness, Color darkness)
    {
        building = build;
        light = brightness;
        dark = darkness;
        rows = building.getH() / 20;
        cols = building.getW() / 20;
        grid = new Rectangle[rows-9][cols-2];
        
        int x = building.getX() + 10;
        int y = building.getY() + 10;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new Rectangle(x, y, 20, 20, light);
                x += 30;
            }
            y += 30;
            x = building.getX() + 10;
        }
    
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
        Random generator = new Random();
        int randRow, randCol;
        
        for (int i = 0; i < 10; i++) {
            randRow = generator.nextInt(grid.length);
            randCol = generator.nextInt(grid[0].length);
            
            if (running % 2 == 0)
            {
                //color = Color.yellow;
                grid[randRow][randCol].setColor(light);
            }
            else
            {
                //color = Color.black;
                grid[randRow][randCol].setColor(dark);
            } 
            repaint();
        }
        
        
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        //repaint();
    }
    
       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)
       {
          int rowIncrement = 0;
          int colIncrement = 0;
           for (int j = 0; j < grid[0].length; j++) { //Rectangle[] row : grid
            for (int i = 0; i < grid.length; i++) {
                page.setColor(grid[i][j].getColor());
                page.fillRect(grid[i][j].getX(), grid[i][j].getY(), 15, 15);
                colIncrement += 30;
                }
            colIncrement = 0;
            rowIncrement += 30;
            }
          
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
          //page.setColor(color);
          //page.fillRect(building.getX()+10, building.getY()+10, 20, 20);
          //page.fillRect(building.getX()+40, building.getY()+40, 20, 20);
          
       }
       
       //public void drawGrid(Graphics2D page)
       
    public void run()
    {
        int running  = 0;
    while(true){
        
        flash(running);
        running ++;
            try{
            Thread.sleep(1); //1000 is a second
        }catch (Exception e){}
        
        //System.out.print(x+"-----------------");
        //repaint();
    }
  
    }
}
