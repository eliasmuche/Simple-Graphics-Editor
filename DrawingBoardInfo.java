import java.awt.*;
import javax.swing.*;
/**
 * This class is the view that contains the jtextarea 
 * The number of shapes on the drawing panel and information about the current selected will be displayed.
 * If no shape is selected, the jtextarea will display so.
 * @author Elias Muche
 * @version 10/25/15 
 */
public class DrawingBoardInfo extends JPanel implements Views{
    private DrawingBoard board;
    private JTextArea t;
    private String info="";
    /**
     * This constructor sets up the drawing board
     * @param b A drawing board is passed in
     */
    public DrawingBoardInfo(DrawingBoard b){
        board=b;//set the board to the parameter
    }
    
    /**
     * This method creates and adds a jtextarea 
     */
    public void addTextArea(){
        t=new JTextArea();//create a jtextarea
        add(t);//add it
    }
    
    /**
     *This method updates the jtext area by resetting the text
     *@param the updated version of the board is passed in 
     */
    public void update(DrawingBoard b){
        board=b;//update the board
        if(board.listCopy().size()==0){
            info="There are no shapes on the drawing board.";
            t.setText(info);
            return;
        }
        if(board.listCopy().get(board.listCopy().size()-1).isSelected()==false){//in case no shape is selected
            info="Number of shapes:"+board.listCopy().size()+"\nNo Shapes are selected.";//information
            t.setText(info);//make it appear in the jtextarea
        }
        else{
            info="Number of shapes:"+board.listCopy().size();//number of shapes
            info+="\nCurrent selected shape info:"+board.listCopy().get(board.listCopy().size()-1).toString();//info about the current selected shape
            t.setText(info);//make it appear in the jtextarea
        }
        
    }
    
    /**
     * Not used 
     */
    public void transfer(){
    
    
    
    }
    
}
