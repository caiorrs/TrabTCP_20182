package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Gui extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Gui() {
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(89, 121, 346, 156);
		getContentPane().add(textArea);
		textArea.setLineWrap(true);
		
		JButton btnNewButton = new JButton("Reproduzir");
		btnNewButton.setBounds(46, 352, 105, 23);
		getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("Pausar");
		button_1.setBounds(216, 352, 105, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Recome�ar");
		button_2.setBounds(385, 352, 89, 23);
		getContentPane().add(button_2);
		
		JButton btnCarregarTexto = new JButton("Carregar Texto");
		btnCarregarTexto.setBounds(118, 299, 123, 23);
		getContentPane().add(btnCarregarTexto);
		
		JButton button = new JButton("Limpar campo");
		button.setBounds(297, 299, 123, 23);
		getContentPane().add(button);
		
		txtNomeGenericoDo = new JTextField();
		txtNomeGenericoDo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeGenericoDo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNomeGenericoDo.setMinimumSize(new Dimension(6, 43));
		txtNomeGenericoDo.setSize(new Dimension(9, 9));
		txtNomeGenericoDo.setEditable(false);
		txtNomeGenericoDo.setText("Nome generico do programa");
		txtNomeGenericoDo.setBounds(89, 53, 346, 57);
		getContentPane().add(txtNomeGenericoDo);
		txtNomeGenericoDo.setColumns(10);
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNomeGenericoDo;

}
