package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ControllerProduto;
import model.ModelProduto;

@SuppressWarnings("serial")
public class FrmProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;
	private JTable tbProdutos;
	JButton btnSalvarProduto = new JButton("");
	JButton btnPesquisarProduto = new JButton("Pesquisar");
	JButton btnNovoProduto = new JButton("");
	JButton btnAlterarProduto = new JButton("");
	JButton btnExcluirProduto = new JButton("");
	JFormattedTextField txtEstoqueProduto = new JFormattedTextField();
	JFormattedTextField txtValorProduto = new JFormattedTextField();

	ArrayList<ModelProduto> listaModelProduto = new ArrayList<>();
	ControllerProduto controllerProduto = new ControllerProduto();
	ModelProduto modelProduto = new ModelProduto();
	String salvarAlterar;
	private JTextField txtPesquisarProduto;

	public FrmProduto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				btnNovoProduto.grabFocus();
			}
		});
		initComponents();
		carregarProdutos();
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProduto frame = new FrmProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponents() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmProduto.class.getResource("/img/icon_produto.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
		setTitle("Produtos");
		setBounds(100, 100, 408, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 0, 392, 361);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 14, 43, 17);
		panel.add(lblNewLabel);

		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setEditable(false);
		txtCodigoProduto.setEnabled(false);
		txtCodigoProduto.setBounds(82, 11, 80, 20);
		panel.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(200, 14, 37, 17);
		panel.add(lblNewLabel_1);

		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEstoque.setBounds(23, 56, 48, 17);
		panel.add(lblEstoque);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblValor.setBounds(204, 56, 33, 17);
		panel.add(lblValor);

		txtNomeProduto = new JTextField();
		txtNomeProduto.setEnabled(false);
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(251, 11, 117, 20);
		panel.add(txtNomeProduto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 140, 345, 100);
		panel.add(scrollPane);

		tbProdutos = new JTable();
		tbProdutos.setGridColor(Color.GRAY);
		tbProdutos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tbProdutos.setDefaultRenderer(Object.class, new CellRenderer());
		tbProdutos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Nome", "Estoque", "Valor" }));
		tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(110);
		tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(60);
		tbProdutos.getColumnModel().getColumn(3).setPreferredWidth(70);
		scrollPane.setViewportView(tbProdutos);
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
				final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
				tbProdutos.setRowSorter(classificador);
				String textoPesquisa = txtPesquisarProduto.getText();

				classificador.setRowFilter(RowFilter.regexFilter(textoPesquisa, 1));
			}
		});

		btnPesquisarProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/icon_pesquisar.png")));
		btnPesquisarProduto.setBounds(23, 106, 124, 25);
		panel.add(btnPesquisarProduto);
		btnNovoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				}
				habilitaCampos(true);
			}
		});

		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar = "salvar";
				habilitaCampos(true);
			}
		});
		btnNovoProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/icon_novo.png")));
		btnNovoProduto.setBounds(23, 243, 43, 41);
		panel.add(btnNovoProduto);
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar = "alterar";
				int linhaSelecionada = tbProdutos.getSelectedRow();

				if (linhaSelecionada != -1) {
					int codigoProduto = (int) tbProdutos.getValueAt(linhaSelecionada, 0);

					try {
						habilitaCampos(true);
						// RECUPERAR DADOS DO BANCO
						modelProduto = controllerProduto.retornarProdutoController(codigoProduto);

						// MOSTRAR NA INTERFACE
						txtCodigoProduto.setText(String.valueOf(modelProduto.getIdProduto()));
						txtNomeProduto.setText(modelProduto.getnomeProduto());
						txtEstoqueProduto.setText(String.valueOf(modelProduto.getEstoqueProduto()));
						txtValorProduto.setText(String.valueOf(modelProduto.getValorProduto()));

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar o Produto!", "Atenção", 0,
								new ImageIcon(getClass().getResource("/img/icon_erro.png")));
					}
				} else {
					JOptionPane.showMessageDialog(null, "Erro, nenhum produto selecionado!", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}

			}
		});
		btnAlterarProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/icon_editar.png")));
		btnAlterarProduto.setBounds(272, 295, 43, 41);
		panel.add(btnAlterarProduto);

		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSeleciona = tbProdutos.getSelectedRow();

				if (linhaSeleciona != -1) {

					int codigoProduto = (int) tbProdutos.getValueAt(linhaSeleciona, 0);

					if (controllerProduto.excluirProdutoController(codigoProduto)) {
						JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!", "Sucesso", 0,
								new ImageIcon(getClass().getResource("/img/icon_correto.png")));
						carregarProdutos();
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao excuir Produto!!", "Atenção", 0,
								new ImageIcon(getClass().getResource("/img/icon_erro.png")));
					}
					;
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum Produto Selecionado", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}
			}
		});
		btnExcluirProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/icon_excluir.png")));
		btnExcluirProduto.setBounds(23, 295, 43, 41);
		panel.add(btnExcluirProduto);
		btnSalvarProduto.setEnabled(false);

		btnSalvarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (salvarAlterar.equals("salvar")) {
					salvarProduto();
				} else if (salvarAlterar.equals("alterar")) {
					alterarProduto();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar Produto", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}

			}
		});
		btnSalvarProduto.setIcon(new ImageIcon(FrmProduto.class.getResource("/img/icon_salvar.png")));
		btnSalvarProduto.setBounds(325, 295, 43, 41);
		panel.add(btnSalvarProduto);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 93, 392, 2);
		panel.add(separator);

		txtPesquisarProduto = new JTextField();
		txtPesquisarProduto.setColumns(10);
		txtPesquisarProduto.setBounds(157, 106, 211, 25);
		panel.add(txtPesquisarProduto);

		txtEstoqueProduto.setEnabled(false);
		txtEstoqueProduto.setBounds(82, 55, 80, 20);
		panel.add(txtEstoqueProduto);
		txtValorProduto.setEnabled(false);

		txtValorProduto.setBounds(251, 55, 117, 20);
		panel.add(txtValorProduto);

		carregarProdutos();
		setLocationRelativeTo(null);

	}

	private void carregarProdutos() {
		listaModelProduto = controllerProduto.listaProdutoController();
		DefaultTableModel modeloTabela = (DefaultTableModel) tbProdutos.getModel();
		modeloTabela.setNumRows(0);
		// INSERIR PRODUTOS
		int contador = listaModelProduto.size();

		for (int i = 0; i < contador; i++) {
			listaModelProduto.get(i).getValorProduto();
			modeloTabela.addRow(
					new Object[] { listaModelProduto.get(i).getIdProduto(), listaModelProduto.get(i).getnomeProduto(),
							listaModelProduto.get(i).getEstoqueProduto(), listaModelProduto.get(i).getValorProduto() });
		}

	}

	private void salvarProduto() {
		modelProduto.setnomeProduto(txtNomeProduto.getText());
		modelProduto.setEstoqueProduto(Integer.parseInt(txtEstoqueProduto.getText()));
		modelProduto.setValorProduto(Double.parseDouble(txtValorProduto.getText()));

		if (controllerProduto.salvarProdutoController(modelProduto) > 0) {
			JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso", "Sucesso", 0,
					new ImageIcon(getClass().getResource("/img/icon_correto.png")));
			carregarProdutos();
			habilitaCampos(false);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar Produto!", "Atenção", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
		}
		;
	}

	private void alterarProduto() {
		modelProduto.setnomeProduto(txtNomeProduto.getText());
		modelProduto.setEstoqueProduto(Integer.parseInt(txtEstoqueProduto.getText()));
		modelProduto.setValorProduto(Double.parseDouble(txtValorProduto.getText()));

		if (controllerProduto.alterarProdutoController(modelProduto)) {
			JOptionPane.showMessageDialog(null, "Produto alterado com Sucesso", "Sucesso", 0,
					new ImageIcon(getClass().getResource("/img/icon_correto.png")));
			carregarProdutos();
			habilitaCampos(false);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Produto!", "Atenção", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
		}
		;
	}

	private void habilitaCampos(boolean condicao) {
		btnSalvarProduto.setEnabled(condicao);
		txtNomeProduto.setEnabled(condicao);
		txtEstoqueProduto.setEnabled(condicao);
		txtValorProduto.setEnabled(condicao);
		limparCampos();
		txtNomeProduto.grabFocus();
	}

	private void limparCampos() {
		txtCodigoProduto.setText("");
		txtNomeProduto.setText("");
		txtEstoqueProduto.setText("");
		txtValorProduto.setText("");
	}

	public class CellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		public CellRenderer() {
			super();
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			this.setHorizontalAlignment(CENTER);

			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}
}
