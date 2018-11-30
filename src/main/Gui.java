package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jfugue.pattern.Pattern;



public class Gui extends JFrame
{
	private JLabel txtNomePrograma;
	private static JLabel lblStatus = new JLabel("Parado");
	private String titulo = "TCPlayer";
	private static boolean toggleTexto = false;
	
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
					Operacoes.setStatusLabel(lblStatus);
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
		JTextArea entradaTexto = new JTextArea();
		JButton btnCarregarTexto = new JButton("Abrir arquivo");
		JButton btnSalvarMidi = new JButton("Salvar em MIDI");
		JButton btnLimparTexto = new JButton("Limpar texto");
		JButton btnReproduzir = new JButton("Reproduzir");
		JButton btnPausar = new JButton("Pausar");
		JButton btnParar = new JButton("Parar"); // Stop
		JScrollPane sp = new JScrollPane(entradaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		getContentPane().setLayout(null);
		
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
		getContentPane().add(txtNomePrograma);
		
/*===================================================================*/		
		// Caixa de Texto
/*===================================================================*/		
		
			entradaTexto.setLineWrap(true);
			entradaTexto.setWrapStyleWord(true);
			sp.setBounds(89, 121, 346, 156);
			getContentPane().add(sp);

/*===================================================================*/		
		// Status do player
/*===================================================================*/	
			
			lblStatus.setBackground(Color.WHITE);
			lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setForeground(Color.BLACK);
			lblStatus.setBounds(231, 288, 64, 14);
			getContentPane().add(lblStatus);
			
/*===================================================================*/
		// Primeira linha de botões - Abrir Arquivo - Salvar para Midi - Limpar Texto
/*===================================================================*/		
		// Botão para abrir arquivo
		
		btnCarregarTexto.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser File = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				File.setFileFilter(new FileNameExtensionFilter("Arquivos de Texto", "txt", "text"));
				int returnValue = File.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION)
				{
					Arquivo arquivo = new Arquivo();
					arquivo.leArquivo(File.getSelectedFile());
					entradaTexto.setText(arquivo.getTexto());
				}
			}
		});
		btnCarregarTexto.setBounds(118, 355, 150, 23);
		getContentPane().add(btnCarregarTexto);
		
		// Botão para Salvar em MIDI
		
		btnSalvarMidi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo MIDI", "midi"));
				fileChooser.setDialogTitle("Digite o nome do arquivo para salvar");
				 
				int userSelection = fileChooser.showSaveDialog(getContentPane());
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					String texto = entradaTexto.getText();
					StringBuilder parsedEntry = parseTexto.parse(texto);
					Pattern patternParaSalvar = new Pattern(parsedEntry.toString());

					Arquivo.escreveMIDI(patternParaSalvar, fileChooser.getSelectedFile());
					//System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				}
			}
		});
		btnSalvarMidi.setBounds(272, 355, 150, 23);
		getContentPane().add(btnSalvarMidi);
		
		// Botão para Limpar a Caixa de Texto
		
		btnLimparTexto.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				entradaTexto.setText(null);
			}
		});
		btnLimparTexto.setBounds(381, 310, 123, 23);
		getContentPane().add(btnLimparTexto);
		
/*===================================================================*/
		// Segunda linha de botões - Reproduzir - Pausar - Parar 
/*===================================================================*/
		// Botão Reproduzir
		
		btnReproduzir.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				String texto = entradaTexto.getText();
				btnPausar.setText("Pausar");
				toggleTexto = false;
				lblStatus.setText("Rodando");
				lblStatus.setForeground(Color.GREEN);
				if(Operacoes.isFinished() || !Operacoes.isStarted())
				{
					Operacoes.reproduzir(texto);
				}
				else if(Operacoes.isStarted()) 
				{
					Operacoes.parar();
					Operacoes.reproduzir(texto);
				}
			}
		});
		btnReproduzir.setBounds(30, 310, 120, 23);
		getContentPane().add(btnReproduzir);
		
		// Botão Pausar
		
		
		
		btnPausar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (Operacoes.isPlaying() || Operacoes.isPaused())
				{
					if(!toggleTexto)
					{
						btnPausar.setText("Continuar");
						lblStatus.setText("Pausado");
						lblStatus.setForeground(Color.RED);
					}
					else
					{
						btnPausar.setText("Pausar");
						lblStatus.setText("Rodando");
						lblStatus.setForeground(Color.GREEN);
					}
					toggleTexto = !toggleTexto;
					
					Operacoes.pausar();
				}
			}
		});
		btnPausar.setBounds(160, 310, 105, 23);
		getContentPane().add(btnPausar);
		
		// Botão Parar
		
		btnParar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				btnPausar.setText("Pausar");
				lblStatus.setText("Parado");
				lblStatus.setForeground(Color.BLACK);
				toggleTexto = false;
				Operacoes.parar();
			}
		});
		btnParar.setBounds(275, 310, 80, 23);
		getContentPane().add(btnParar);
	}
}