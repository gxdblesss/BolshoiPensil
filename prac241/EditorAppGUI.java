package prac241;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorAppGUI {
    private IDocument document;
    private final ICreateDocument factory;

    public EditorAppGUI(ICreateDocument factory) {
        this.factory = factory;
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Editor Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                document = factory.createNew();
            }
        });

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                document = factory.createOpen();
            }
        });

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (document != null) {
                    document.save();
                } else {
                    JOptionPane.showMessageDialog(frame, "No document to save.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (document != null) {
                    document.close();
                }
                System.exit(0);
            }
        });

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ICreateDocument factory = new CreateTextDocument();
        new EditorAppGUI(factory);
    }
}

