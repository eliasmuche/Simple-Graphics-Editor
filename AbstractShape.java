import java.awt.Color;
/**
 * This abstract class will contain properties common to all shapes.
 * The class will also update states that are common to all shapes.
 * 
 * @author Elias Muche
 * @version 10/12/15
 */
public abstract class AbstractShape implements Shape
{
    private boolean selected=false;
    private Color c;
    private int x,y,h;
    /**
     * This constructor initializes the upper left corner location and the height.
     * These properties are common to all shapes
     * @param x The x-coordinate of the upper left corner
     * @param y The y-coordinate of the upper left corner
     * @param h The height of the shape
     * @throws IllegalArgumentException if the height is negative or 0
     */
    public AbstractShape(int x, int y, int h)throws IllegalArgumentException{
        if(h<=0){
            throw new IllegalArgumentException("The height must be positive.");
        
        }
        this.x=x;
        this.y=y;
        this.h=h;
    }

    /**
     * This method selects and deselects a shape.
     * @param s Either true or false
     * 
     */
    public void setSelected(boolean s){
        selected=s;
    }
    
    /**
     * This method checks if a shape is selected. 
     * @return True if it's selected and false if it isn't
     */
    public boolean isSelected(){
        return selected==true;

    }

    /**
     * This method will set the color of the delta.
     * @param c A desired color is passed in 
     */
    public void setColor(Color c){

        this.c=c;

    }

    /**
     * This method will retrieve the color of the delta. 
     * @return The color of the delta is returned
     */
    public Color getColor(){

        return c;

    }

    /**
     * This method shifts the upper left corner of a shape.
     * @param dx The shift desired in the x-direction.
     * @param dy The shift desired in the y-direction.
     */
    public void shiftUpperLeftBy(int dx,int dy){

        x+=dx;
        y+=dy;

    }
    
    /**
     * This method moves the upper left corner of a shape. 
     * @param nx The x-coordinate of the new location
     * @param ny The y-coordinate of the new location
     */
    public void moveUpperLeftTo(int nx,int ny){

        x=nx;
        y=ny;

    }

    /**
     * This method retrieves the x-coordinate of the upper left corner of a shape.
     * @return The upper left corner x-coordinate
     */
    public int  getX(){

        return x;

    }

    /**
     * This method retrieves the y-coordinate of the upper left corner of a shape.
     * @return The upper left corner y-coordinate
     */
    public int getY(){

        return y;

    }

    /**
     * This method retrieves the height of a shape.
     * @return The height
     */
    public int getH(){

        return h;

    } 
    
    /**
     * This method will determine whether a clicked point is on a shape or not.
     * This method is abstract because the implementation varies from shape to shape
     * @param x The x-coordinate of the clicked point
     * @param y The y-coordinate of the clicked point
     * @return True if the point was on the shape, and false if it wasn't
     */
    public abstract boolean isOn(int x,int y);

    /**
     * This method will describe a shape by its state.
     * This method is abstract because the implementation varies from shape to shape
     * @return A string containing a defining point and the height of the shape 
     */
    public abstract String toString();
}
