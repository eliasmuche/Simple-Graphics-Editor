
import java.awt.*;
/**
 * This class contains the unique properties of a delta shape.
 * The state of the shape can be altered in this class.
 * @author Elias Muche
 * @version 10/10/15
 */
public class Delta extends AbstractShape{

    /**
     * This constructor will initialize the location and height of the delta. 
     * @param ax The x-coordinate of the apex
     * @param ay The y-coordinate of the apex 
     * @param height The height of the delta
     * @throws IllegalArgumentException if the height isn't even
     */
    public Delta(int ax, int ay, int height)throws IllegalArgumentException{
        super(ax-height/2,ay,height);//setting the location of the upper left corner and setting up the height 
        if (height%2!=0){//ensuring the height is even 
            throw new IllegalArgumentException("The height must be even");

        }
        setColor(Color.yellow);//default color
        
    
    }

    /**
     * This method will check if a clicked point is on the delta.
     * @param x The x-coordinate of the clicked point 
     * @param y The y-coordinate of the clicked point
     * @ return If the clicked point is on the shape, the method returns true. It returns false otherwise
     */
    public boolean isOn(int x, int y){
        int blx=getX();//x-coordinate of the bottom left point 
        int bly=getY()+getH();//y-coordinate of the bottom left point
        int brx=getX()+getH();//x-coordinate of the bottom right point 
        int bry=getY()+getH();//y-coordinate of the bottom right point
        double leftSlope=(bly-getY())/((getX()+getH()/2)-blx);//the slope of the left side of the delta is calculated
        double rightSlope=(bry-getY())/((getX()+getH()/2)-brx);//the slope of the right side of the delta is calculated
        double slope=(bly-y)/(x-blx);//the slope between the clicked point and the bottom left point is calculated 
        double slope2=(bry-y)/(x-brx);//the slope between the clicked point and the bottom right point is calculated
      
        
        
        if(x<(getX())||x>(getX()+getH())){//returning false if the clicked point is outside the box horizontally 

            return false;
        }
        else if(y>(getY()+getH())||y<getY()){//returning false if the clicked point is outside the box vertically 

            return false;

        }
        //at this point we know the point is in the surrounding box

        return slope<=leftSlope&&slope2>=rightSlope;  //now we compare all of the slopes
        //first expression checks if our slope between the bottom left point and clicked point is not bigger than the slope of the left side
        //second expression checks if our slope between the bottom right point and clicked point is not smaller than the slope of the right side

    }

   

    
    /**
     * This method will represent the delta shape by its state.
     * @return The delta's apex location and height is returned
     */
    public String toString(){
        String D="";
        D+="The apex is located at:("+(getX()+getH()/2)+","+getY()+")\n";//adding the apex location
        D+="The height is:"+getH();//adding the height
        return D;
    }
    
    /**
     * This method will draw a delta shape.   
     * @param g A graphics object will be passed in by the system
     */
    public void draw(Graphics g){
        int[] x=new int[3];//x-coordinate array
        x[0]=getX();//bottom left x
        x[1]=getX()+getH()/2;//apex x
        x[2]=getX()+getH();//bottom right x
        
        int[] y=new int[3];//y-coordinate array 
        y[0]=getY()+getH();//bottom left y
        y[1]=getY();//apex y
        y[2]=getY()+getH();//bottom right y
        
        g.setColor(getColor());//set the color to the default color
        g.fillPolygon(x,y,3);//draw the polygon using the arrays and number of points
        if(isSelected()){//if the shape is selected, draw a black border
             g.setColor(Color.black);
             g.drawPolygon(x,y,3);//black border
        
        }
      
        
        
    
    }

    
    
   
}
