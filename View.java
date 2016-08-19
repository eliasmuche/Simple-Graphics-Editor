import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * This class conatains the view where the drawing takes place.
 * 
 * @author Elias Muche
 * @version 10/16/15
 */
public class View extends JPanel implements Views{
    private DrawingBoard board;
    private ArrayList<Shape> list=new ArrayList<Shape>();
    
    /**
     * This constructor takes a drawing board as a parameter. 
     * @param b The drawing board
     */
    public View(DrawingBoard b){
        board=b;//add the drawing board 
    
    
    }
    
    /**
     * Dummy construtor in case an object needs to be created without a drawing board.
     */public View(){
    
    
    
    }
    
    
   
    /**
     * This method will redraw all of the shapes.
     * @param g A graphics object will be passed in by the system
     * {@inheritDoc}
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<board.listCopy().size();i++){
            board.listCopy().get(i).draw(g);//tell each shape to draw itself
            
            if(board.listCopy().size()==0){
                break;
            
            }
            
        
        }
        
    }
    
    /**
     * This method will update the view by redrawing the shapes when the model changes.
     * @param b The updated drawing board is passed in
     */
    public void update(DrawingBoard b){
    
        list=b.listCopy();//get the new list of shapes
        repaint();//repaint everything
    
    }
    
    /**
     *  
     */
    public void transfer(){
        setFocusable(true);
        requestFocus();
    
    }
    
   
    
}
