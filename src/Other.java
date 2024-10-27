import java.awt.event.*;

// implements the listener interface
class Other implements ActionListener {

    GFG1 gfgObj;

    Other(GFG1 gfgObj) {
        this.gfgObj = gfgObj;
    }

    public void actionPerformed(ActionEvent e)
    {
        // setting text from different class
        gfgObj.textField.setText("Using Different Classes");
    }
}