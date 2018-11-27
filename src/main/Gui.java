package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame
{
	
	private JLabel txtNomePrograma;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Gui frame = new Gui();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setSize(550, 450);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public Gui()
	{
		getContentPane().setLayout(null);
		
		
		// Caixa de Texto
		JTextArea entradaTexto = new JTextArea();
		entradaTexto.setBounds(89, 121, 346, 156);
		getContentPane().add(entradaTexto);
		entradaTexto.setLineWrap(true);
		entradaTexto.setWrapStyleWord(true);

		// Botão Reproduzir
		JButton btnReproduzir = new JButton("Reproduzir");
		btnReproduzir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String texto = entradaTexto.getText();
				
				operacoes.reproduzir(texto,0); // reproduzir a partir da posicao 0
			}
		});
		btnReproduzir.setBounds(46, 352, 105, 23);
		getContentPane().add(btnReproduzir);
		
		// Botão Pausar
		JButton btnPausar = new JButton("Pausar");
		btnPausar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				operacoes.pausar(); // pausar
			}
				
		});
		btnPausar.setBounds(216, 352, 105, 23);
		getContentPane().add(btnPausar);
		
		
		// Botão Reiniciar Reprodução
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(385, 352, 89, 23);
		getContentPane().add(btnReiniciar);
		
		
		// Botão para abrir arquivo
		JButton btnCarregarTexto = new JButton("Abir arquivo");
		btnCarregarTexto.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser File = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = File.showOpenDialog(null);
				
				if(returnValue == JFileChooser.APPROVE_OPTION)
				{
					arquivo arquivo = new arquivo();
					arquivo.leArquivo(File.getSelectedFile());
					entradaTexto.setText(arquivo.getTexto());
				}
			}
		});
		btnCarregarTexto.setBounds(118, 299, 123, 23);
		getContentPane().add(btnCarregarTexto);
		
		// Botão para Limpar a Caixa de Texto
		JButton btnLimparTexto = new JButton("Limpar texto");
		btnLimparTexto.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				entradaTexto.setText(null);
			}
		});
		btnLimparTexto.setBounds(297, 299, 123, 23);
		getContentPane().add(btnLimparTexto);
		
		txtNomePrograma = new JLabel();
		txtNomePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePrograma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNomePrograma.setMinimumSize(new Dimension(6, 43));
		txtNomePrograma.setSize(new Dimension(9, 9));
		txtNomePrograma.setText("Text To Music");
		txtNomePrograma.setBounds(89, 53, 346, 57);
		getContentPane().add(txtNomePrograma);
	}
}