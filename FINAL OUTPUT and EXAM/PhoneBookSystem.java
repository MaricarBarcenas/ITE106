import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PhonebookSystem extends JFrame implements ActionListener {
    private JTextField eventField, nameField, phoneField;
    private JTextArea displayArea;
    private String filename = "phonebook.txt", selectedContact = "";
    private HashMap<String, String> phonebook;

    public PhonebookSystem() {
        phonebook = new HashMap<>();

        //===================Main Frame ng GUI=================//
        setTitle("Phonebook System - Custom Colors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        //===================Colors for Custom Theme=================//
        Color bgColor = new Color(228, 224, 225); // E4E0E1
        Color fgColor = Color.BLACK;
        Color buttonColor = new Color(171, 136, 109); // AB886D
        Color headerColor = new Color(214, 192, 179); // D6C0B3
        Color borderColor = new Color(73, 54, 40); // 493628

        //===================Font Settings=================//
        Font labelFont = new Font("Times New Roman", Font.BOLD, 14);
        Font fieldFont = new Font("Times New Roman", Font.PLAIN, 12);
        Font buttonFont = new Font("Times New Roman", Font.BOLD, 12);

        //===================Initialize ung mga variables/objects=================//
        eventField = new JTextField();
        eventField.setEditable(false);
        eventField.setBackground(headerColor);
        eventField.setForeground(fgColor);
        eventField.setFont(fieldFont);

        nameField = new JTextField();
        nameField.setBackground(bgColor);
        nameField.setForeground(fgColor);
        nameField.setCaretColor(fgColor);
        nameField.setFont(fieldFont);

        phoneField = new JTextField();
        phoneField.setBackground(bgColor);
        phoneField.setForeground(fgColor);
        phoneField.setCaretColor(fgColor);
        phoneField.setFont(fieldFont);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(bgColor);
        displayArea.setForeground(fgColor);
        displayArea.setCaretColor(fgColor);
        displayArea.setFont(fieldFont);

        //===================will hold the header and input panels=================//
        JPanel topPanels = new JPanel(new BorderLayout());
        topPanels.setBackground(bgColor);
        add(topPanels, BorderLayout.NORTH);

        // para sa display ng text about sa events or changes na nangyayari //
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(headerColor);
        headerPanel.add(eventField);
        topPanels.add(headerPanel, BorderLayout.NORTH);

        //===================Name and Phone Number=================//
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.setBackground(bgColor);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(fgColor);
        nameLabel.setFont(labelFont);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(fgColor);
        phoneLabel.setFont(labelFont);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        topPanels.add(inputPanel, BorderLayout.SOUTH);

        //===================Scroll bars para sa display ng mga name and their corresponding phone numbers=================//
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.getViewport().setBackground(bgColor);
        scrollPane.setBorder(BorderFactory.createLineBorder(borderColor));
        add(scrollPane, BorderLayout.CENTER);

        //===================Buttons=================//
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bgColor);
        String[] buttons = {"Add", "Search", "Delete", "Select", "Update"};
        for (String button : buttons) {
            JButton b = new JButton(button);
            b.setBackground(buttonColor);
            b.setForeground(fgColor);
            b.setFont(buttonFont);
            b.setFocusPainted(false); // Remove focus border for a cleaner look
            b.addActionListener(this);
            buttonPanel.add(b);
        }
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        loadContacts();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Add":
                addContact();
                break;
            case "Search":
                searchContact();
                break;
            case "Delete":
                deleteContact();
                break;
            case "Select":
                selectContact();
                break;
            case "Update":
                updateContact();
                break;
        }
    }

    private void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    phonebook.put(parts[0], parts[1]);
                }
            }
            updateDisplay();
            eventField.setText("Contacts loaded successfully.");
        } catch (IOException ex) {
            eventField.setText("Failed to load contacts.");
        }
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        if (name.isEmpty() || phone.isEmpty()) {
            eventField.setText("Name or phone cannot be empty.");
            return;
        }
        phonebook.put(name, phone);
        saveContacts();
        updateDisplay();
        eventField.setText("Contact added: " + name);
    }

    private void searchContact() {
        String name = nameField.getText().trim();
        if (phonebook.containsKey(name)) {
            phoneField.setText(phonebook.get(name));
            eventField.setText("Contact found: " + name);
        } else {
            eventField.setText("Contact not found: " + name);
        }
    }

    private void deleteContact() {
        String name = nameField.getText().trim();
        if (phonebook.remove(name) != null) {
            saveContacts();
            updateDisplay();
            eventField.setText("Contact deleted: " + name);
        } else {
            eventField.setText("Contact not found: " + name);
        }
    }

    private void selectContact() {
        String name = nameField.getText().trim();
        if (phonebook.containsKey(name)) {
            selectedContact = name;
            phoneField.setText(phonebook.get(name));
            eventField.setText("Contact selected: " + name);
        } else {
            eventField.setText("Contact not found: " + name);
        }
    }

    private void updateContact() {
        if (selectedContact.isEmpty()) {
            eventField.setText("No contact selected for update.");
            return;
        }
        String newPhone = phoneField.getText().trim();
        if (newPhone.isEmpty()) {
            eventField.setText("Phone cannot be empty.");
            return;
        }
        phonebook.put(selectedContact, newPhone);
        saveContacts();
        updateDisplay();
        eventField.setText("Contact updated: " + selectedContact);
    }

    private void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException ex) {
            eventField.setText("Failed to save contacts.");
        }
    }

    private void updateDisplay() {
        displayArea.setText("");
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            displayArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        new PhonebookSystem();
    }
}
