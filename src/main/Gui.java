package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Gui extends JFrame
{
	private JLabel txtNomePrograma;
	private String titulo = "Text Music Player";
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Gui frame = new Gui();
					frame.setResizable(false);
					frame.setSize(550, 450);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public Gui()
	{
		
		setTitle(titulo);
		
		// Componentes
		//JFrame janela = new JFrame();
		JTextArea entradaTexto = new JTextArea();
		JButton btnCarregarTexto = new JButton("Abrir arquivo");
		JButton btnSalvarMidi = new JButton("Salvar em MIDI");
		JButton btnLimparTexto = new JButton("Limpar texto");
		JButton btnReproduzir = new JButton("Reproduzir");
		JButton btnPausar = new JButton("Pausar");
		JButton btnParar = new JButton("Parar"); // Stop
		JButton btnReiniciar = new JButton("Reiniciar");
		//JScrollPane sp = new JScrollPane(entradaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		setLayout(null);
		
/*===================================================================*/		
		// Título do Programa
/*===================================================================*/		

		txtNomePrograma = new JLabel();
		txtNomePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomePrograma.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNomePrograma.setMinimumSize(new Dimension(6, 43));
		txtNomePrograma.setSize(new Dimension(9, 9));
		txtNomePrograma.setText(titulo);
		txtNomePrograma.setBounds(89, 53, 346, 57);
		add(txtNomePrograma);
		
/*===================================================================*/		
		// Caixa de Texto
/*===================================================================*/		
		
		entradaTexto.setBounds(89, 121, 346, 156);
		add(entradaTexto);
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
					Arquivo arquivo = new Arquivo();
					arquivo.leArquivo(File.getSelectedFile());
					entradaTexto.setText(arquivo.getTexto());
				}
			}
		});
		btnCarregarTexto.setBounds(46, 299, 150, 23);
		add(btnCarregarTexto);
		
		// Botão para Salvar em MIDI
		
		btnSalvarMidi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("SALVAR MIDI AINDA NAO IMPLEMENTADO!");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Digite o nome do arquivo para salvar");
				 
				int userSelection = fileChooser.showSaveDialog(getContentPane());
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    Arquivo arquivo = new Arquivo();
				    //System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				}
			}
		});
		btnSalvarMidi.setBounds(200, 299, 150, 23);
		add(btnSalvarMidi);
		
		// Botão para Limpar a Caixa de Texto
		
		btnLimparTexto.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				entradaTexto.setText(null);
			}
		});
		btnLimparTexto.setBounds(380, 299, 123, 23);
		add(btnLimparTexto);
		
/*===================================================================*/
		// Segunda linha de botões - Reproduzir - Pausar - Parar - Reiniciar Reprodução 
/*===================================================================*/
		// Botão Reproduzir
		
		btnReproduzir.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				if(Operacoes.isFinished() || !Operacoes.isStarted())
				{
					String texto = entradaTexto.getText();
					Operacoes.reproduzir(texto);
				}
				else if(Operacoes.isStarted()) 
				{
					Operacoes.parar();
				}
			}
		});
		btnReproduzir.setBounds(20, 352, 120, 23);
		add(btnReproduzir);
		
		// Botão Pausar
		
		btnPausar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (!Operacoes.isFinished() && Operacoes.isStarted())
				{
					Operacoes.pausar();
				}
			}
		});
		btnPausar.setBounds(150, 352, 105, 23);
		add(btnPausar);
		
		// Botão Parar
		
		btnParar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (Operacoes.isPlaying())
				{
					Operacoes.parar();
				}
			}
		});
		btnParar.setBounds(280, 352, 80, 23);
		add(btnParar);
		
		
		// Botão Reiniciar Reprodução
		
		btnReiniciar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String texto = entradaTexto.getText();
				
				Operacoes.parar();
				Operacoes.reproduzir(texto);
			}
		});
		
		btnReiniciar.setBounds(400, 352, 100, 23);
		add(btnReiniciar);
	}
}