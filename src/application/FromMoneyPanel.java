package application;

import javax.swing.*;

import mc.model.*;
import mc.view.MoneyDialog;

public class FromMoneyPanel extends JPanel implements  MoneyDialog{
    private  JTextField textField;
    private  JComboBox comboBox;
    
    public FromMoneyPanel(JComboBox comboBox, JTextField textField) {
        this.textField = textField;
        this.comboBox = comboBox;
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(textField);
        this.add(comboBox);
    }

    @Override
    public Money get() {
        return new Money(Float.parseFloat(textField.getText()),
                new Currency(comboBox.getSelectedItem().toString()));
    }

    public JTextField getTextField() {
        return textField;
    }
}
