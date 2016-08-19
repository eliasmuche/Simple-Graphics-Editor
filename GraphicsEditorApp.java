import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class creates the window and sets everything (buttons, drawing panel, and jtextarea) up.
 * This class also runs the program.
 * I have added additional features including:
 * The removal of the selected shape(press R or r).
 * Changing the color of the shape(press C or c).
 * Removing all of the shapes in the drawing board(press E or e).
 * @author Elias Muche 
 * @version 10/24/15
 */
public class GraphicsEditorApp 
{

    /**
     * This method runs the program.
     * @param args Empty string array
     */
    public static void main(String[] args){
        DrawingBoard board=new DrawingBoard();//create a new drawing board
        Controller c=new Controller();//create a new controller
        JFrame f=new JFrame("GraphicsEditorApp");//create a new window
        f.setSize(750,750);//window size
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close when close clicked
        View v=new View(board);//create a new drawing panel 
        v.addMouseListener(c);//setting up the click handling 
        v.addMouseMotionListener(c);//setting up the motion handling
        f.setVisible(true);
        v.setFocusable(true);
        v.addKeyListener(c);//setting up the key handling 
        v.setBackground(Color.lightGray);//default background 
        board.addView(v);//add the view into the drawing board's list of views
        f.getContentPane().add(v,BorderLayout.CENTER);//add the view into the frame
        ButtonPanel v2=new ButtonPanel();//the panel where the button are located 
        JButton b=new JButton("Circle");//circle button
        b.addActionListener(c);//setting up the button click handling
        v2.add(b);//add the button to the panel 
        b=new JButton("Delta");//delta button 
        b.addActionListener(c);//setting up the button click handling 
        v2.add(b);//add the button to the panel
        b=new JButton("Tee");//tee button
        b.addActionListener(c);//setting up the button click handling 
        v2.add(b);//add the button to the panel
        f.getContentPane().add(v2,BorderLayout.NORTH);//add the panel containing the buttons to the frame
        board.addView(v2);//add the button panel to the drawing board's list of views

        DrawingBoardInfo info=new DrawingBoardInfo(board);//the panel that will contain the jtextarea
        info.addTextArea();//add a jtextarea
        f.getContentPane().add(info,BorderLayout.SOUTH);// add the panel to the frame
        board.addView(info);//add the panel to the drawing board's list of views
        c.connectModel(board);//mvc pattern implementation
        f.validate();
        //f.setVisible(true);//make the window visible
               
    }
}