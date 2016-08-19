import java.awt.*;
/**
 * This interface sets up the behavior of all shapes
 * @author Elias Muche  
 * @version 10/10/15
 */
public interface Shape 
{

    /**
     * This method will select or deselect a shape.
     * @param b True if you want to select and false if you want to deselect
     */
    public void setSelected(boolean b);

    /**
     * This method will check if a shape is selected.
     * @return True if the shape is selected, false if it isn't
     */
    public boolean isSelected();

    /**
     * This method will check if a point the user clicked on, is on a current shape.
     * @param x The x-coordinate of the clicked point
     * @param y the y-coordinate of the clicked point
     * @retrun True if the clicked point was on the shape and false if it wasn't 
     */
    public boolean isOn(int x, int y);

    /**
     * This method will shift the shape from the upper left corner of the surrounding box.
     * @param dx What the x-coordinate will be shifted by
     * @param dy What the y-coordinate will be shifted by
     */
    public void shiftUpperLeftBy(int dx,int dy);

    /**
     * This method will move a shape by moving its left corner of the surrounding box.
     * @param nx The new x-coordinate of the shape 
     * @param ny The new y-coordinate of the shape
     */
    public void moveUpperLeftTo(int nx,int ny);

    /**
     * This method will return the state of the shape(location, height and/or width). 
     * @return The location, height and/or width is returned as a string
     */
    public String toString();

    /**
     * This method will set the color of the shape.
     * @param c A desired color is passed in 
     */
    public void setColor(Color c);

    /**
     * This method will retrieve the color of the shape. 
     * @return The color of the shape is returned
     */
    public Color getColor();
    
    /**
     * This method should draw a shape
     * @param g A graphics object will be passed in by the system
     */
    public void draw(Graphics g);

    
}
