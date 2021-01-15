package main.java.ui;

import main.java.controller.CustomerController;
import main.java.model.dto.BookDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class MainPageView extends JFrame{
    private int width = 350;
    private int height = 1000;
    private JList<BookDTO> listBook;
    DefaultListModel<BookDTO> model;

    JButton searchButton;
    JTextField searchText;

    JPanel panel1;
    JPanel panel2;

    CustomerController cc = CustomerController.istance;

    public MainPageView() {
        JSplitPane splitPane = new JSplitPane();
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);
        splitPane.setDividerLocation(200);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(createControlPanel());
        splitPane.setBottomComponent(createMainPanel());
        setListeners();
        setTitle("Strona glowna");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        // create list book and set to scrollpane and add to panel
        panel1.add(new JScrollPane(listBook = createListBooks()),
                BorderLayout.CENTER);
        return panel1;
    }

    private JList<BookDTO> createListBooks() {
        model = new DefaultListModel<>();

        JList<BookDTO> list = new JList<BookDTO>(model);
        list.setCellRenderer(new BookView());
        return list;
    }

    private JPanel createControlPanel(){
        panel2 = new JPanel();
        panel2.setLayout(null);
        searchButton = new JButton("Szukaj");
        searchButton.setBounds(10, 10, 80, 25);
        panel2.add(searchButton);

        searchText = new JTextField(20);
        searchText.setBounds(100, 10, 160, 25);
        panel2.add(searchText);
        return panel2;
    }

    private void setListeners(){

        searchButton.addActionListener(e -> {
            try {
                model.clear();
                String title = searchText.getText();
                List<BookDTO> bookDTOList = cc.findBooks(searchText.getText());
                for(BookDTO b:bookDTOList){
                    model.addElement(b);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

    }

}