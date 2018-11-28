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
		
		// Componentes
		JTextArea entradaTexto = new JTextArea();
		JButton btnCarregarTexto = new JButton("Abrir arquivo");
		JButton btnSalvarMidi = new JButton("Salvar em MIDI");
		JButton btnLimparTexto = new JButton("Limpar texto");
		JButton btnReproduzir = new JButton("Reproduzir");
		JButton btnPausar = new JButton("Pausar");
		JButton btnReiniciar = new JButton("Reiniciar");
		
/*===================================================================*/		
		// Título do Programa
/*===================================================================*/		

		txtNomePrograma = new JLabel();
		txtNomePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePrograma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNomePrograma.setMinimumSize(new Dimension(6, 43));
		txtNomePrograma.setSize(new Dimension(9, 9));
		txtNomePrograma.setText("Text Music player");
		txtNomePrograma.setBounds(89, 53, 346, 57);
		getContentPane().add(txtNomePrograma);
		
/*===================================================================*/		
		// Caixa de Texto
/*===================================================================*/		
		
		entradaTexto.setBounds(89, 121, 346, 156);
		getContentPane().add(entradaTexto);
		entradaTexto.setLineWrap(true);
		entradaTexto.setWrapStyleWord(true);

/*===================================================================*/
		// Primeira linha de botões - Abrir Arquivo - Salvar para Midi - Limpar Texto
/*===================================================================*/		
		// Botão para abrir arquivo
		
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
		btnCarregarTexto.setBounds(46, 299, 150, 23);
		getContentPane().add(btnCarregarTexto);
		
		// Botão para Salvar em MIDI
		
		btnSalvarMidi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				//operacoes.salvarMidi();
				System.out.println("SALVAR MIDI AINDA NAO IMPLEMENTADO!");
			}
		});
		btnSalvarMidi.setBounds(200, 299, 150, 23);
		getContentPane().add(btnSalvarMidi);
		
		// Botão para Limpar a Caixa de Texto
		
		btnLimparTexto.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				entradaTexto.setText(null);
			}
		});
		btnLimparTexto.setBounds(380, 299, 123, 23);
		getContentPane().add(btnLimparTexto);
		
/*===================================================================*/
		// Segunda linha de botões - Reproduzir - Pausar - Reiniciar Reprodução 
/*===================================================================*/
		// Botão Reproduzir
		
		btnReproduzir.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				String texto = entradaTexto.getText();
				
				operacoes.reproduzir(texto);
			}
		});
		btnReproduzir.setBounds(46, 352, 120, 23);
		getContentPane().add(btnReproduzir);
		
		// Botão Pausar
		
		btnPausar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (!operacoes.isFinished())
				{
					operacoes.pausar();
				}
			}
				
		});
		btnPausar.setBounds(216, 352, 105, 23);
		getContentPane().add(btnPausar);
		
		
		// Botão Reiniciar Reprodução
		
		btnReiniciar.setBounds(385, 352, 100, 23);
		getContentPane().add(btnReiniciar);
	}
}