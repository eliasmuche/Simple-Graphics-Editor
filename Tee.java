
import java.awt.*;
/**
 * This class contains the unique properties of a tee.
 * The state of the tee can be altered in this class.
 * @author Elias Muche
 * @version 10/12/15
 */
public class Tee extends AbstractShape
{

    /**
     * This constructor initializes the location and size of a tee.
     * @param x The upper left corner x-coordinate 
     * @param y The upper left corner y-coordinate 
     * @param height The height
     * @throws IllegalArgumentException If the height isn't a mutiple of ten
     */
    public Tee(int x, int y, int height)throws IllegalArgumentException{
        super(x,y,height);//setting the upper left corner location as well as the height 
        if(height%10!=0){// in case the height isn't a  multiple of ten
            throw new IllegalArgumentException("The height must be a multiple of ten.");

        }
        
        setColor(Color.blue);//default color
        
        
    }

    /**
     * This method checks if a clicked point is on a tee shape.
     * @param x The x-coordinate of the clicked point 
     * @param y The y-coordinate of the clicked point
     * @return True if the point was on the shape, false if it wasn't
     */
    public boolean isOn(int x, int y){
        if(y<=getY()+(getH()/5)&& y>=getY()){// this if  statment checks if we are within the top rectangle vertically
            if(x>=getX() && x<=getX()+getH()){//if we are, check if we are in within the top rectangle horizontally 

                return true;//if both cases are true

            
            }

        }

        else if(x>=getX()+(2*(getH()/5)) && x<=getX()+(3*(getH()/5))){//this if statement checks if we are within the tall rectangle horizontally. 
            //we check for this we weren't within the top rectangle

            if(y>=getY() && y<=getY()+getH()){//if we are, check if we are within the tall rectangle vertically

                return true;//if both cases are true

            
            }
        
        }
        return false;

    }

   
    /**
     * This method will describe a tee by its state.
     * This includes its upper left corner location, its height, and its thickness
     * @return A string containg the upper left corner location, the height, and the thickness
     */
    public String toString(){
        String T="";
        T+="The location is:("+getX()+","+getY()+")\n";//add the upper left corner location
        T+="The height is:"+getH();//add the height
        T+="The thickness of the Tee is:"+getH()/5;//add the thickness
        return T;

    }
    
    /**
     * This method will draw a tee
     * @param g A gaphics object will be passed in by the system
     */
    public void draw(Graphics g){
    
        int x1=getX();//upper left x
        int y=getY();//upper left y same for the upper left corner of the verticle rectangle
        int w=getH();//width of top rectangle
        int h=getH()/5;//height of top rectangle
        int x2=getX()+(2*getH()/5);//verticle rectangle x(upper left corner)
        int w2=getH()/5;//width of the verticle rectangle
        
        g.setColor(getColor());//default color 
        g.fillRect(x1,y,w,h);//draw the tee (horizontal rectangle)
        g.fillRect(x2,getY(),w2,getH());//draw the tee (verticle rectangle)
        if(isSelected()){//if its selected draw a black border
            g.setColor(Color.black);
            g.drawRect(x2,getY(),w2,getH());//black border
            g.drawRect(x1,y,w,h);//black border
        
        
        }
        
       
    
    }

}
