package me.devmello.gui.panels;



import me.devmello.gui.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

/**
 *
 * @author John Grosh <john.a.grosh@gmail.com>
 */
public class ConsolePanel extends JPanel {
    static JTextArea text = new JTextArea();
    public ConsolePanel()
    {
        super();

        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        PrintStream con=new PrintStream(new TextAreaOutputStream(text));
        System.setOut(con);
        System.setErr(con);

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(text);

        super.setLayout(new GridLayout(1,1));
        super.add(pane);
        super.setPreferredSize(new Dimension(400,300));
    }
    public static void addToConsole(String words)
    {
        text.append(words);
    }
}