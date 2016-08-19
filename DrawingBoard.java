import java.util.*;
import java.awt.Color;

/**
 * This class contains an arraylist to keep track of how many shapes are on the drawing panel.
 * Actions such as adding a shape or removing a shape can be performed.
 * The color of the selected shape can be changed.
 * The location of a shape can be altered.
 * 
 * 
 * @author Elias Muche 
 * @version 10/13/15
 */
public class DrawingBoard
{
    private ArrayList<Shape> list=new ArrayList<Shape>();
    private ArrayList<Views> viewers=new ArrayList<Views>();
    private ArrayList<Color> colors;
    private int colorIndex;
    
    
    /**
     * This constructor creates a list of colors 
     */
    public DrawingBoard(){
        colorIndex=-1;
        colors=new ArrayList<Color>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);
        colors.add(Color.yellow);
        colors.add(Color.cyan);
        colors.add(Color.darkGray);
        colors.add(Color.orange);
        colors.add(Color.magenta);
        colors.add(Color.pink);
        colors.add(Color.white);
    
    }
    /**
     * This method will allow the user to add shape to the drawing board
     * @param shape The shape the user wants to add
     */
    public void add(Shape shape){
        list.add(shape);//adding the shape
        for(Shape s:list){//deselecting all of the shapes
            
            s.setSelected(false);
        
        }
        
        list.get(list.size()-1).setSelected(true);//selecting the topmost shape
    }
    
    
    /**
     * This method takes a point and selects the topmost shape that contains the point.
     * @param x The x-coordinate of the point 
     * @param y The y-coordinate of the point
     */
    public void findShape(int x,int y){
        Shape temp=null;//placeholder when the topmost shape containing the point is moved to the end of the arraylist
        int index=-10;//will hold the location of the topmost shape containing the point 
        boolean foundAShape=false;//in case no shape contains the 
        for(int i=0;i<list.size();i++){
            
           
            if(list.get(i).isOn(x,y)){
                foundAShape=true;//a shape containing the point was found
                temp=list.get(i);//getting ready to place the shape at the end of the arraylist if no other shape contains the point
                index=i;//location 
            
            
            
            
            }
        
        
        }
        
        if(foundAShape==false){
        
            for(int i=0;i<list.size();i++){
            
                list.get(i).setSelected(false);//deslect everything because the user clicked on no shape
            
            }
        
        }
        else{
        
            list.remove(index);//remove the topmost shape containing the point 
            add(temp);//add it to the end 
            list.get(list.size()-1).setSelected(true);//select it
        }
    } 
    
    
    /**
     * This method returns the current selected shape.
     * @return The last item if its selected otherwise return null 
     */
    public Shape getSelectedShape(){
        if(list.get(list.size()-1).isSelected()==false){//checking if the topmost shape isn't selected
        
            return null;//return null if its deselected
        }
        return list.get(list.size()-1);//return it if its selected
    
    }
    
    /**
     * This method removes the current selected shape.
     * @throws IllegalStateException if no shape is selected
     */
    public void remove()throws IllegalStateException{
        
        if(list.get(list.size()-1).isSelected()==false){//in case no shape is selected
        
            throw new IllegalStateException("No shapes are selected");
        
        }
        
        if(list.size()>1){//checking if there are shapes under the top most shape
            list.get(list.size()-2).setSelected(true);//selecting the next topmost shape
        }
        
        list.remove(list.size()-1);//top most shape removal
        
        if(list.size()==0){
            for(Shape s:list){
                s.setSelected(false);
            }
        
        }
       
    }
    
    /**
     * This method will change the color of the current selected shape.
     * @param c The desired new color
     * @throws IllegalStateException if no shapes are selected
     */
    public void changeColor(Color c)throws IllegalStateException{
    
        if(list.get(list.size()-1).isSelected()==false){//in case no shape is selected 
            
            throw new IllegalStateException("No Shapes are selected");
        
        }
        
        list.get(list.size()-1).setColor(c);//set the color of the selected shape
        
    
    }
    
    /**
     * This method will shift the current selected shape by a specified amount in each direction.
     * @param dx The shift amount in the x-direction
     * @param dy The shift amount in the y-direction
     * @throws IllegalStateException if no shape is selected
     */
    public void changeLocation(int dx, int dy)throws IllegalStateException{
    
        if(list.get(list.size()-1).isSelected()==false){//in case no shape was selected
        
            throw new IllegalStateException("No shape was selected.");
        
        }
        list.get(list.size()-1).shiftUpperLeftBy(dx,dy);//calling the shift method of the selected shape
    }
    
    
    /**
     * This method returns a copy of the list of shapes.
     * @return A copy of the list of shapes
     */
    public ArrayList<Shape> listCopy()
    {
        ArrayList<Shape> copy=new ArrayList<Shape>(list);//storing my arraylist into an arraylist
        return copy;
    
    }
    
    /**
     * This method registers a viewer. 
     * @param v A view that will be added to the list of views
     */
    public void addView(Views v){
        viewers.add(v);//add it
    
    
    }
    
   /**
    * This method will return all of the viewers that is registered with the model.
    * @return The list of viewers
    */
   public ArrayList<Views> viewCopy(){
        ArrayList<Views> copy= new ArrayList<Views>(viewers);//new array with the current list
        return copy;
    }
    
    /**
     * This method will tell each view to update itself based on the changes of the model.
     * 
     */
     private void notifyViews(){
    
        for(int i=0;i<viewers.size();i++){
            viewers.get(i).update(this);//each view will update itself with this board
       
        }
   
    }
    
    /**
     * This method will be called by the controller so that the model knows to nofity all of the views. 
     */
    public void changed(){
    
        notifyViews();
    
    } 
    
    /**
     * This method will set the focus to the drawing panel.
     * 
     */
     public void Transfer(){
    
        for(int i=0;i<viewers.size();i++){
            viewers.get(i).transfer();//each view will transfer the focus 
        }

    }
    
    /**
     * This color will get the next color in the color list.
     * @return The next color in the color list
     */
    public Color getNewColor(){
    
        if(colorIndex==colors.size()){
            colorIndex=-1;//if the end of the color list is reached, wrap around
            
        }
       //set the color of the selected shape
       colorIndex+=1;//add one to the index to prepare for the next color    
       return colors.get(colorIndex);//return the next color in the color list
    
    }
    
    
    
    
    /**
     * This method will remove all of the shapes on the drawing board.
     */
    public void removeAll(){
        
        
        while(list.size()>=1){
            remove();//keep removing shapes until there's no more shapes on the board
        
        
        }

    
    
    }
    
    }
