import java.awt.*; // for Frame
import java.awt.event.*; // for ActionListener

class Fdemo extends Frame implements ActionListener { // Frame is a class in awt package

    Fdemo() { // constructor

        setLayout(null); // setting layout to null
        setVisible(true); // setting visibility to true
        setSize(800, 600); // setting size of frame
        setBackground(Color.black); // setting background color to black
        setForeground(Color.white); // setting foreground color to white

    }

    public void actionPerformed(ActionEvent e) { // method of action listener interface

    }

}

public class ticTacToe {
    public static void main(String[] args) {

        Fdemo f = new Fdemo(); // creating object of Fdemo class
    }
}
