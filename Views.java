
/**
 * This inteface contains the specification for a view to coordinate with the model.
 * 
 * @author Elias Muche
 * @version 10/25/15
 */
public interface Views
{
    /**
     * This method will update the view based on the changes of the drawing board.
     * @param b The updated drawing board
     */
    public void update(DrawingBoard b);
    
    /**
     * This method will transfer the focus to a drawing panel 
     */
    public void transfer();
}
