import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 * This class contains the controller.
 * It will interact with the model and tell it to update the view.
 * 
 * @author Elias Muche 
 * @version 10/24/15
 */
public class Controller implements ActionListener,MouseListener,MouseMotionListener,KeyListener 
{
    private String actionCommand="";
    private DrawingBoard board;
    

    /**
     * This method makes the drawing board visible to the controller.
     * This is done so that the model can be updated
     * @param b The drawing board that is being connected
     */
    public void connectModel (DrawingBoard b){
        board=b;//set the board to the parameter
        

    }
    
   

    /**
     * This method occurs when a button is clicked. 
     * It remembers which button was clicked
     * @param e ActionEvent passed in by the system
     */
    public void actionPerformed(ActionEvent e){
        actionCommand=e.getActionCommand();//remember which button was clicked
        board.Transfer();
    }

    /**
     * This method occurs when a click in the drawing panel occurs.
     * It will either draw a shape or select a shape if the click was on the shape
     * @param e MouseEvent passed in by the system
     */
    public void mouseClicked(MouseEvent e){

        if(actionCommand.equals("Circle")){//if the circle button was clicked
            Circle c= new Circle(e.getX(),e.getY(),50);//create a new circle with a default radius
            board.add(c);//add it to the drawing board (list of shapes)
            actionCommand="";//take it out of draw mode
            board.changed();//tell the model a changed occured
            //the model will then notify all views 
            
           
            
            
            
        }
        else if(actionCommand.equals("Delta")){//if the delta button was clicked
            Delta d=new Delta(e.getX(),e.getY(),100);//create a new delta with a default height
            board.add(d);//add it to the drawing board (list of shapes)
            actionCommand="";//take it out of draw mode
            board.changed();//tell the model that a changed occured
            //the model will then notify all views
             
        }
        else if(actionCommand.equals("Tee")){//if the tee button was clicked
            Tee t=new Tee(e.getX(),e.getY(),100);//create a new tee with a default height
            board.add(t);//add it to the drawing board (list of shapes)
            actionCommand="";//take it out of draw mode
            board.changed();//tell the model that a change occured
            //the model will then notify all views 
            
        }
        else {
            board.findShape(e.getX(),e.getY());//if no button was clicked, find out if we clicked on a shape in the drawing board
            board.changed();//tell the model that a changed occured
            //the model will then notify all views
        }
    }
    
    /**
     * This method will change the location of the shape that was clicked on and dragged.
     * @param e MouseEvent passed in by the system
     */
    public void mouseDragged(MouseEvent e){
        if(board.listCopy().get(board.listCopy().size()-1).isSelected()==true){//if a shape was clicked on
            board.listCopy().get(board.listCopy().size()-1).moveUpperLeftTo(e.getX(),e.getY());//moving the shape as it is dragged
            board.changed();//tell the model that a changed occured
            //the model will then notify all views
        
        }
        
        
    
    }
    
    /**
     * Not used.
     * @param e A Mouse event
     */
    public void mouseMoved(MouseEvent e){
    
    
    }

    /**
     * This method sets the program up for dragging a shape.
     * It handles the intial click before the drag.
     * @param e MouseEvent passed in by the system
     */
    public void mousePressed(MouseEvent e){
        board.findShape(e.getX(),e.getY());//check if the click occured on a shape 
        board.changed();//tell the model a change occured 
        //the model will then notify all views
    
    }

    /**
     * Not used.
     * @param e A Mouse event
     */
    public void mouseReleased(MouseEvent e){

    
    }

    /**
     * Not used.
     * @param e A Mouse event
     */
    public void mouseEntered(MouseEvent e){

    
    }

    /**
     * Not used.
     * @param e A Mouse event
     */
    public void mouseExited(MouseEvent e){

    
    }
    
    /**
     * This method will either change the color or remove all shape if a key is pressed.  
     * @param e KeyEvent that is passed in by the system
     */
    public void keyTyped(KeyEvent e){
        
        if(e.getKeyChar()==82||e.getKeyChar()==114){//if R or r was pressed
            
            board.remove();//remove the current selected shape
            board.changed();//tell the drawing board to notify the views
        
        }
        else if(e.getKeyChar()==67||e.getKeyChar()==99){//if C or c was pressed
        
            board.changeColor(board.getNewColor());//change the color of the current selected shape
            board.changed();//tell the drawingboard to notify the views
        
        
        }
        else if(e.getKeyChar()==69||e.getKeyChar()==101){//if E or e was pressed
        
            board.removeAll();//remove all of the shapes in the drawing panel
            board.changed();//tell the drawing board to notify the views
        
        }
        
    }
    
    /**
     * Not used.
     * @param e KeyEvent that is passed in by the system
     */
    public void keyPressed(KeyEvent e){
        
    
    }
    
    /**
     * Not used.
     * @param e KeyEvent that is passed by the system
     */
    public void keyReleased(KeyEvent e){
    
    
    }
}
