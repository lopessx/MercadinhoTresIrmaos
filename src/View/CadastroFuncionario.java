package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;

	/**
	 * Launch the application.
	 */
	static CadastroFuncionario frame;
	private JTextField campoLogradouro;
	private JTextField campoBairoo;
	private JTextField campoCidade;
			public static void run() {
				try {
					frame = new CadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public CadastroFuncionario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 200, 588, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeNovo = new JLabel("Cadastro de novo funcion\u00E1rio");
		lblCadastroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroDeNovo.setBounds(70, 11, 243, 34);
		contentPane.add(lblCadastroDeNovo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(27, 62, 59, 26);
		contentPane.add(lblNome);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(78, 62, 463, 25);
		contentPane.add(campoNome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnCadastrar.setForeground(new Color(0, 128, 0));
		btnCadastrar.setBackground(new Color(60, 179, 113));
		btnCadastrar.setBounds(369, 226, 193, 77);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setForeground(new Color(139, 0, 0));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(10, 226, 193, 77);
		contentPane.add(btnCancelar);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogradouro.setBounds(27, 110, 106, 26);
		contentPane.add(lblLogradouro);
		
		campoLogradouro = new JTextField();
		campoLogradouro.setBounds(117, 110, 424, 25);
		contentPane.add(campoLogradouro);
		campoLogradouro.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBairro.setBounds(27, 153, 59, 26);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(259, 153, 59, 26);
		contentPane.add(lblCidade);
		
		campoBairoo = new JTextField();
		campoBairoo.setBounds(78, 158, 161, 20);
		contentPane.add(campoBairoo);
		campoBairoo.setColumns(10);
		
		campoCidade = new JTextField();
		campoCidade.setBounds(317, 158, 224, 20);
		contentPane.add(campoCidade);
		campoCidade.setColumns(10);
	}
}