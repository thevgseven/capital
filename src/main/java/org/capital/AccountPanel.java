package org.capital;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AccountPanel extends JPanel {
    public AccountPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create a 2x2 grid layout for the account sections
        JPanel gridPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Display Credit Card details in a card-like format
        JPanel creditCardPanel = createCardPanel("", "Visa", "XXXX-XXXX-XXXX-3333", "Balance: 5000", "Credit Capacity: 100000");
        gridPanel.add(createBorderedPanel(creditCardPanel, "Credit Cards"));

        // Display Debit Card details in a card-like format
        JPanel debitCardPanel = createCardPanel("", "RuPay", "XXXX-XXXX-XXXX-6666", "Balance: 20000");
        gridPanel.add(createBorderedPanel(debitCardPanel, "Debit Cards"));

        // Display Saving Account details in a card-like format
        JPanel savingAccountPanel = createCardPanel("", "HDFC Bank", "XXXX-XXXX-XXXX-1234", "Balance: 150000");
        gridPanel.add(createBorderedPanel(savingAccountPanel, "Saving Accounts"));

        // Display Current Account details in a card-like format
        JPanel currentAccountPanel = createCardPanel("", "HDFC Bank", "XXXX-XXXX-XXXX-1111", "Balance: 50000");
        gridPanel.add(createBorderedPanel(currentAccountPanel, "Current Accounts"));

        add(gridPanel, BorderLayout.CENTER);
    }

    private JPanel createCardPanel(String title, String cardType, String cardNumber, String... details) {
        JPanel cardPanel = new JPanel(new GridLayout(details.length + 3, 1, 10, 10));
        cardPanel.setBackground(new Color(240, 240, 240)); // Light gray background

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("monospace", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(titleLabel);

        JLabel typeLabel = new JLabel("Type: " + cardType);
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(typeLabel);

        JLabel numberLabel = new JLabel("Number: " + cardNumber);
        numberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(numberLabel);

        for (String detail : details) {
            JLabel detailLabel = new JLabel(detail);
            detailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardPanel.add(detailLabel);
        }

        return cardPanel;
    }

    private JPanel createBorderedPanel(JPanel contentPanel, String title) {
        JPanel borderedPanel = new JPanel(new BorderLayout());
        borderedPanel.setBorder(BorderFactory.createTitledBorder(title));
        borderedPanel.add(contentPanel, BorderLayout.CENTER);

        return borderedPanel;
    }
}
