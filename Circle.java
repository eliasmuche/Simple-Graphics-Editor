import java.awt.*;
/**
 * This class contains the unique properties of a circle.
 * The state of the circle can be altered in this class.
 * @author Elias Muche 
 * @version 10/12/15
 */
public class Circle extends AbstractShape
{

    /**
     * This method initializes the location and size of the circle.
     * @param cx The x-coordinate of the center
     * @param cy The y-coordinate of the center 
     * @param r The radius of the circle
     */
    public Circle(int cx, int cy, int r){
        super(cx-r,cy-r,r*2);//The upper left corner location is set as well as the height(diameter)
        setColor(Color.green);//default color

    
    }

    /**
     * This method will check if a clicked point is on a circle shape.
     * @param x The x-coordinate of the clicked point 
     * @param y The y-coordinate of the clicked point
     * @return True if the point was on the circle, false if it wasn't
     */
    public boolean isOn(int x, int y){
        return Math.sqrt(Math.pow((getX()+getH()/2)-x,2)+Math.pow((getY()+getH()/2)-y,2))<=(getH()/2);
        //finding the distance between the clicked point and the center
        //then returning false if the distance is greater than the radius and true if it isn't

    }

    /**
     * This method will describe a circle by its state.
     * This includes its center location and radius
     * @return A string containing the center location and radius
     */
    public String toString(){
        String C="";
        C+="The location of the center is:("+(getX()+getH()/2)+","+(getY()+getH()/2)+")\n";//adding the center location 
        C+="The radius is:"+(getH()/2);//adding the radius
        return C;
    }
    
    /**
     * This method will draw a circle. 
     * @param g a graphics object passed in by the system
     */
    public void draw(Graphics g){
        g.setColor(getColor());//default color
        g.fillOval(getX(),getY(),getH(),getH());//draw a circle 
        if(isSelected()){//create a black border if its selected 
            g.setColor(Color.black);
            g.drawOval(getX(),getY(),getH(),getH());
        
        
        }
        
        
    }

    
}
