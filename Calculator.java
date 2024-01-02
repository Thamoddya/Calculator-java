import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class close extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

class cal implements ActionListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23,
            b24, b25;

    TextField tf;

    String fv, sv, op;
    double fdv, sdv, tot;
    int characterNum;
    String state = "false";

    cal() {
        Frame f1 = new Frame();
        Frame f2 = new Frame();
        Frame f3 = new Frame();

        f1.setBackground(Color.BLACK);
        f1.addWindowListener(new close());
        f1.setBounds(600, 80, 320, 440);
        f1.setTitle("Calculator");

        f2.setBackground(Color.WHITE);
        f2.addWindowListener(new close());
        f2.setBounds(600, 80, 300, 50);
        f2.setTitle("About");
        f2.setUndecorated(true);
        f2.setResizable(false);

        f3.setBackground(Color.WHITE);
        f3.addWindowListener(new close());
        f3.setBounds(600, 80, 600, 200);
        f3.setTitle("About");
        f3.setUndecorated(true);
        f3.setResizable(true);

        MenuBar mbar = new MenuBar();

        MenuItem mi1 = new MenuItem("Standerd");
        MenuItem mi2 = new MenuItem("Scientific");
        MenuItem mi3 = new MenuItem("Copy");
        MenuItem mi4 = new MenuItem("Paste");
        MenuItem mi5 = new MenuItem("Help");
        MenuItem mi6 = new MenuItem("About");
        MenuItem mi7 = new MenuItem("Dark");
        MenuItem mi8 = new MenuItem("Light");
        MenuItem mi9 = new MenuItem("Cut");

        Menu m1 = new Menu("View");
        Menu m2 = new Menu("Select");
        Menu m3 = new Menu("About");
        Menu m6 = new Menu("Mode");
        m1.add(mi1);
        m1.add(mi2);

        m2.add(mi3);
        m2.add(mi4);
        m2.add(mi9);

        m3.add(mi5);
        m3.add(mi6);

        m6.add(mi7);
        m6.add(mi8);

        mbar.add(m1);
        mbar.add(m2);
        mbar.add(m3);
        mbar.add(m6);

        f1.setMenuBar(mbar);

        b1 = new Button("1/x");
        b2 = new Button("B");
        b3 = new Button("x²");
        b4 = new Button("<-");
        b5 = new Button("AC");
        b6 = new Button("π");
        b7 = new Button("%");
        b8 = new Button("/");
        b9 = new Button("7");
        b10 = new Button("8");
        b11 = new Button("9");
        b12 = new Button("*");
        b13 = new Button("4");
        b14 = new Button("5");
        b15 = new Button("6");
        b16 = new Button("-");
        b17 = new Button("1");
        b18 = new Button("2");
        b19 = new Button("3");
        b20 = new Button("+");
        b21 = new Button("±");
        b22 = new Button("0");
        b23 = new Button(".");
        b24 = new Button("=");

        Font font1 = new Font("Sabon Next LT", Font.BOLD, 20);

        // Adding FONT 1 to buttons
        Button[] setFont1 = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20,
                b21, b22, b23, b24};

        for (Button button : setFont1) {
            button.setFont(font1);
        }

        // Special Button styles
        b24.setBackground(Color.magenta);
        b24.setForeground(Color.WHITE);

        //
        tf = new TextField(19);

        Font font3 = new Font("Calibri Light", Font.BOLD, 26);
        tf.setFont(font3);
        tf.setEditable(false);
        tf.setForeground(Color.BLACK);
        tf.setBackground(Color.WHITE);

        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();

        GridLayout gl = new GridLayout(6, 4, 2, 2);

        p1.add(tf);
        p1.setBackground(Color.WHITE);

        p2.setLayout(gl);

        p2.setBackground(Color.WHITE);

        Button[] AllButtons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19,
                b20, b21, b22, b23, b24};

        for (int i = 0; i < AllButtons.length; i++) {
            p2.add(AllButtons[i]);
        }

        f1.add(p1, BorderLayout.NORTH);
        f1.add(p2, BorderLayout.CENTER);

        Button[] setListner = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19,
                b20, b21, b22, b23, b24};

        for (Button button : setListner) {
            button.addActionListener(this);
        }

        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi9.addActionListener(this);

        Button closeButton = new Button("OK");
        Label labelAbout; // create a new Label with the text you want
        labelAbout = new Label(" Calculator " + "2023 All right reserved.");
        labelAbout.setAlignment(Label.CENTER); // center-align the label text
        labelAbout.setForeground(Color.BLACK);

        p3.add(labelAbout);
        p3.add(closeButton);
        f2.add(p3);
        f2.setTitle("About");

        Button closeButtonInHelp = new Button("OK");

        Label lableHelp1, lableHelp2, lableHelp3, lableHelp4, lableHelp5, lableHelp6;
        lableHelp1 = new Label(
                " 1.Launch the Java AWT Simple Calculator Application");
        lableHelp2 = new Label(
                " 2.Java AWT Calculator consists of a simple windows , text field and buttons.");
        lableHelp3 = new Label(
                " 3.To perform any arithmetic operation, you need to enter the numbers into the text field. ");
        lableHelp4 = new Label(
                " 4.After entering the numbers, you need to select the arithmetic operation.");
        lableHelp5 = new Label(
                " 5.Once you have selected the arithmetic operation, the result of the operation will be displayed in the text field.");
        lableHelp6 = new Label(" 6.Clear the Text Field:To clear the text field, click on the 'C' button.");

        Label[] helpLabels = {lableHelp1, lableHelp2, lableHelp3, lableHelp4, lableHelp5, lableHelp6};

        for (Label label : helpLabels) {
            label.setForeground(Color.BLACK);
            f3.add(label, BorderLayout.LINE_START);
            p4.add(label);
        }
        p4.add(closeButtonInHelp);
        f3.add(p4);
        f3.setTitle("Help");

        closeButton.addActionListener(new ActionListener() { // ActionListener to the button
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);// close the frame when the button is clicked
                f1.setVisible(true);// Show the frame when the button is clicked
            }
        });
        closeButtonInHelp.addActionListener(new ActionListener() { // ActionListener to the button
            public void actionPerformed(ActionEvent e) {
                f3.setVisible(false);// close the frame when the button is clicked
                f1.setVisible(true);// Show the frame when the button is clicked
            }
        });
        mi6.addActionListener(new ActionListener() { // add an ActionListener to the About
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);// close the frame when the button is clicked
                f2.setVisible(true);// Show the about frame when the button is clicked
            }
        });
        mi5.addActionListener(new ActionListener() { // add an ActionListener to the About
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);// close the frame when the button is clicked
                f3.setVisible(true);// Show the about frame when the button is clicked
            }
        });
        f1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent d) {

        if (d.getActionCommand().equals("B")) {
            String text = tf.getText();
            int intValue = Integer.parseInt(text);
            String binaryString = Integer.toBinaryString(intValue);
            tf.setText(binaryString);
        }
        if (d.getActionCommand().equals("Copy")) {
            String text = tf.getText();
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
        if (d.getActionCommand().equals("Cut")) {
            String text = tf.getText();
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            tf.setText("");
        }
        if (d.getActionCommand().equals("Paste")) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                    int value = Integer.parseInt(text);
                    tf.setText(String.valueOf(value));
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(cal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(cal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20,
                b21, b22, b23};
        if (d.getActionCommand().equals("Dark")) {
            b24.setBackground(Color.BLUE);
            tf.setForeground(Color.WHITE);
            tf.setBackground(Color.BLACK);

            for (Button button : buttons) {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
            }
        }
        if (d.getActionCommand().equals("Light")) {
            b24.setBackground(Color.ORANGE);
            tf.setForeground(Color.BLACK);
            tf.setBackground(Color.WHITE);

            for (Button button : buttons) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }
        }

        Object o = d.getSource();
        if (o.equals(b9)) {
            tf.setText(tf.getText() + b9.getLabel());

        } else if (o.equals(b10)) {
            tf.setText(tf.getText() + b10.getLabel());
        } else if (o.equals(b11)) {
            tf.setText(tf.getText() + b11.getLabel());
        } else if (o.equals(b13)) {
            tf.setText(tf.getText() + b13.getLabel());
        } else if (o.equals(b14)) {
            tf.setText(tf.getText() + b14.getLabel());
        } else if (o.equals(b15)) {
            tf.setText(tf.getText() + b15.getLabel());
        } else if (o.equals(b17)) {
            tf.setText(tf.getText() + b17.getLabel());
        } else if (o.equals(b18)) {
            tf.setText(tf.getText() + b18.getLabel());
        } else if (o.equals(b19)) {
            tf.setText(tf.getText() + b19.getLabel());
        } else if (o.equals(b22)) {
            tf.setText(tf.getText() + b22.getLabel());
        } else if (o.equals(b20)) {
            fv = tf.getText(); // +
            tf.setText("");
            op = b20.getLabel();
        } else if (o.equals(b16)) { // --
            fv = tf.getText();
            tf.setText("");
            op = b16.getLabel();

        } else if (o.equals(b12)) { // *
            fv = tf.getText();
            tf.setText("");
            op = b12.getLabel();
        } else if (o.equals(b7)) { // %
            double value = Double.parseDouble(tf.getText());
            tf.setText(value / 100 + "");

            if (op.equals("+")) {
                tot = fdv / 100 * sdv + fdv;
                tf.setText(tot + "");
            } else if (op.equals("-")) {
                var totHalf = fdv / 100 * sdv;
                tot = fdv - totHalf;
                tf.setText(tot + "");
            }
        } else if (o.equals(b8)) { // /
            fv = tf.getText();
            tf.setText("");
            op = b8.getLabel();
        } else if (o.equals(b5)) { // AC
            fv = "";
            tf.setText("");
            fv = "";
            sv = "";
        } else if (o.equals(b24)) { // =
            sv = tf.getText();
            fdv = Double.parseDouble(fv);
            sdv = Double.parseDouble(sv);

            if (op.equals("+")) {

                tot = fdv + sdv;
                tf.setText(tot + "");
            } else if (op.equals("-")) {

                tot = fdv - sdv;
                tf.setText(tot + "");
            } else if (op.equals("*")) {
                tot = fdv * sdv;
                tf.setText(tot + "");
            } else if (op.equals("/")) {
                tot = fdv / sdv;
                tf.setText(tot + "");
            }

        } else if (o.equals(b4)) { // <-
            String tfText = tf.getText();
            tf.setText(tfText.substring(0, tfText.length() - 1));

        } else if (o.equals(b3)) { // squr X
            fv = tf.getText();
            tf.setText("");
            fdv = Double.parseDouble(fv);
            tot = fdv * fdv;
            tf.setText(tot + "");
        } else if (o.equals(b21)) { // ±
        } else if (o.equals(b3)) { // squr X
            fv = tf.getText();
            tf.setText("");
            fdv = Double.parseDouble(fv);
            tot = fdv * fdv;
            tf.setText(tot + "");
        } else if (o.equals(b1)) { // x/1
            fv = tf.getText();
            tf.setText("");
            fdv = Double.parseDouble(fv);
            tot = 1 / fdv;
            tf.setText(tot + "");
        } else if (o.equals(b21)) { // ±
            String normal = tf.getText();
            if (state.equals("false")) {
                tf.setText("-" + normal);
                state = "true";
            } else if (state.equals("true")) {
                state = "false";
                if (normal.equals("")) {
                    tf.setText("");
                } else if (normal.startsWith("-")) {
                    tf.setText(normal.replaceFirst("-", ""));
                }
            }
        } else if (o.equals(b23)) {
            tf.setText(tf.getText() + ".");
        } else if (o.equals(b6)) { // suqre root
            fv = tf.getText();
            tot = Math.sqrt(Double.parseDouble(fv));
            tf.setText(tot + "");
        }
        throw new UnsupportedOperationException(
                "Not supported.");
    }

    ;
};

public class Calculator {
    public static void main(String[] args) {

        new cal();

    }

    ;
};
