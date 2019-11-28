package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroProduto extends JFrame {

	ArrayList<Produto> Estoque;
	private JPanel contentPane;
	private JTextField campoCodigoProd;
	private JTextField campoQtdEstoque;
	private JTextField campoNomeProd;
	private JTextField campoPrecoUnit;
	private JTextField campoDescricao;
	static TelaCadastroProduto frame;
	private JTextField textField;
	private JTextField campoDescricao2;
	private JTable tabelaProdutos;
	DefaultTableModel modelo;
	private static int count = 0;
	
	private void LoadTable() {
		
		for (int i=0; i<Estoque.size(); i++) {
			modelo.addRow(new Object[] {Estoque.get(i).getCod_barras(), Estoque.get(i).getNome(),  
										Estoque.get(i).getPreco_unitario(), Estoque.get(i).getQuantidade()
			});
		}
	}

	
	private static void run() {
		try {
			frame = new TelaCadastroProduto();
			frame.setVisible(true);
			count = count + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	private TelaCadastroProduto() {
		

		Estoque = new ArrayList();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(450, 250, 513, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigoDoProduto = new JLabel("Codigo do Produto: ");
		lblCodigoDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDoProduto.setBounds(327, 124, 170, 34);
		contentPane.add(lblCodigoDoProduto);

		JLabel lblQuantidadeNoEstoque = new JLabel("Quantidade no Estoque:");
		lblQuantidadeNoEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidadeNoEstoque.setBounds(147, 129, 170, 25);
		contentPane.add(lblQuantidadeNoEstoque);

		JLabel lblNomeProduto = new JLabel("Nome Produto: ");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProduto.setBounds(20, 21, 112, 25);
		contentPane.add(lblNomeProduto);

		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio: ");
		lblPreoUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreoUnitrio.setBounds(10, 129, 112, 25);
		contentPane.add(lblPreoUnitrio);

		campoCodigoProd = new JTextField();
		campoCodigoProd.setBounds(327, 165, 130, 25);
		contentPane.add(campoCodigoProd);
		campoCodigoProd.setColumns(10);

		campoQtdEstoque = new JTextField();
		campoQtdEstoque.setBounds(177, 165, 86, 25);
		contentPane.add(campoQtdEstoque);
		campoQtdEstoque.setColumns(10);

		campoNomeProd = new JTextField();
		campoNomeProd.setBounds(30, 45, 394, 25);
		contentPane.add(campoNomeProd);
		campoNomeProd.setColumns(10);

		campoPrecoUnit = new JTextField();
		campoPrecoUnit.setBounds(10, 165, 95, 25);
		contentPane.add(campoPrecoUnit);
		campoPrecoUnit.setColumns(10);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeProdutos.setBounds(143, -1, 180, 35);
		contentPane.add(lblCadastroDeProdutos);

		Button button = new Button("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			float preco = Float.parseFloat(campoPrecoUnit.getText()); 
			int barcod =Integer.parseInt(campoCodigoProd.getText());
			int qnt_estoque =Integer.parseInt(campoQtdEstoque.getText());
			Produto p = new Produto(barcod,campoNomeProd.getText(), campoDescricao2.getText(), preco, qnt_estoque);
			Estoque.add(p);
			LoadTable();
			TelaCadastroProduto.run();	 

			}
		});

		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(102, 204, 102));
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.setBounds(402, 253, 71, 25);
		contentPane.add(button);

		Button button_1 = new Button("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.setBackground(new Color(153, 51, 0));
		button_1.setBounds(318, 253, 71, 25);
		contentPane.add(button_1);


		JLabel lblDescricao = new JLabel("Descricao: ");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(20, 67, 76, 25);
		contentPane.add(lblDescricao);
		
		campoDescricao2 = new JTextField();
		campoDescricao2.setBounds(30, 93, 394, 25);
		contentPane.add(campoDescricao2);
		campoDescricao2.setColumns(10);
		
		JLabel lblPesquisarProd = new JLabel("Pesquisar Produto");
		lblPesquisarProd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPesquisarProd.setBounds(166, 395, 151, 34);
		contentPane.add(lblPesquisarProd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 440, 452, 149);
		contentPane.add(scrollPane);
		
		tabelaProdutos = new JTable();
		
		tabelaProdutos.setModel(modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod_Barras", "Nome", "Preco", "Qntd_Estoque"
			}
		));
		scrollPane.setViewportView(tabelaProdutos);
		
	}
	
	public static TelaCadastroProduto getInstance(){
		
		if (count == 0) {
			
		TelaCadastroProduto.run();
			
		}
		else {
			return null;	
		}
		return null;
	}
	
}
