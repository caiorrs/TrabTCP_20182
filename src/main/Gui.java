package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setSize(550, 450);
					frame.setLocationRelativeTo(null);
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
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String texto = textArea.getText();
				
				operacoes.reproduzir(texto,0); // reproduzir a partir da posicao 0
			}
		});
		btnNewButton.setBounds(46, 352, 105, 23);
		getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("Pausar");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				operacoes.pausar(); // pausar
			
			}
				
		});
		button_1.setBounds(216, 352, 105, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Recomeçar");
		button_2.setBounds(385, 352, 89, 23);
		getContentPane().add(button_2);
		
		JButton btnCarregarTexto = new JButton("Carregar Texto");
		btnCarregarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser File = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = File.showOpenDialog(null);
				
				if(returnValue == JFileChooser.APPROVE_OPTION)
				{
					arquivo arquivo = new arquivo();
					arquivo.leArquivo(File.getSelectedFile());
					textArea.setText(arquivo.getTexto());
				}
			}
		});
		btnCarregarTexto.setBounds(118, 299, 123, 23);
		getContentPane().add(btnCarregarTexto);
		
		JButton button = new JButton("Limpar campo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
			}
		});
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

	
	private JTextField txtNomeGenericoDo;

}