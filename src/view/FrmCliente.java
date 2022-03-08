package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControllerCliente;
import model.ModelCliente;

public class FrmCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodCliente;
	private JTextField txtNomeCliente;
	private JTextField txtEndCliente;
	private JTextField txtBairroCliente;
	private JLabel lblNewLabel_3;
	private JTextField txtCidadeCliente;
	private JScrollPane scrollPane;
	private JTable tbCliente;
	private JButton btnNovoCliente = new JButton("");
	private JButton btnCancelarOperacao = new JButton("");
	private JButton btnAlterarCliente = new JButton("");
	private JButton btnSalvarCliente = new JButton("");
	private JButton btnRemoverCliente = new JButton("");
	private MaskFormatter FormatoCEP;
	private MaskFormatter FormatoTelefone;
	private JComboBox<Object> cbCliente = new JComboBox<Object>();
	private JFormattedTextField txtCepCliente = new JFormattedTextField();
	private ControllerCliente controllerCliente = new ControllerCliente();
	private ModelCliente modelCliente = new ModelCliente();
	private ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();
	private String salvarAlterar;
	private JFormattedTextField txtTelefoneCliente = new JFormattedTextField();

	public FrmCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				btnNovoCliente.grabFocus();
			}
		});
		initComponents();
		carregarCliente();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
		setResizable(false);
		setTitle("Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/img/icon_cliente.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(0, 0, 414, 441);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 14, 43, 17);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);

		txtCodCliente = new JTextField();
		txtCodCliente.setEnabled(false);
		txtCodCliente.setBounds(88, 11, 51, 20);
		panel.add(txtCodCliente);
		txtCodCliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(177, 14, 37, 17);
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(224, 11, 167, 20);
		txtNomeCliente.setColumns(10);
		panel.add(txtNomeCliente);

		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(18, 52, 56, 17);
		panel.add(lblNewLabel_1);

		txtEndCliente = new JTextField();
		txtEndCliente.setEnabled(false);
		txtEndCliente.setBounds(88, 49, 303, 20);
		panel.add(txtEndCliente);
		txtEndCliente.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Bairro:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(37, 89, 37, 17);
		panel.add(lblNewLabel_2);

		txtBairroCliente = new JTextField();
		txtBairroCliente.setEnabled(false);
		txtBairroCliente.setBounds(88, 86, 70, 20);
		panel.add(txtBairroCliente);
		txtBairroCliente.setColumns(10);

		lblNewLabel_3 = new JLabel("Cidade:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(173, 89, 41, 17);
		panel.add(lblNewLabel_3);

		txtCidadeCliente = new JTextField();
		txtCidadeCliente.setEnabled(false);
		txtCidadeCliente.setBounds(224, 86, 78, 20);
		txtCidadeCliente.setColumns(10);
		panel.add(txtCidadeCliente);

		JLabel lblNewLabel_4 = new JLabel("UF:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(312, 89, 20, 17);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("CEP:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(46, 126, 28, 17);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(198, 126, 52, 17);
		panel.add(lblNewLabel_6);

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setBounds(18, 194, 373, 120);
		panel.add(scrollPane);

		tbCliente = new JTable();
		tbCliente.setGridColor(Color.GRAY);
		tbCliente.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tbCliente.setDefaultRenderer(Object.class, new CellRenderer());
		tbCliente.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Cliente", "Cidade", "Telefone" }));
		tbCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbCliente.getColumnModel().getColumn(2).setPreferredWidth(70);
		scrollPane.setViewportView(tbCliente);
		btnNovoCliente.setBackground(new Color(245, 245, 245));
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar = "salvar";
				limparCampos();
				habilitaCampos(true);
			}
		});

		btnNovoCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_novo.png")));
		btnNovoCliente.setBounds(17, 325, 57, 33);
		btnNovoCliente.setToolTipText("INCLUIR");
		panel.add(btnNovoCliente);
		btnCancelarOperacao.setBackground(new Color(245, 245, 245));
		btnCancelarOperacao.setEnabled(false);
		btnCancelarOperacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
				cancelaOperacao();
			}
		});

		btnCancelarOperacao.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_cancelar.png")));
		btnCancelarOperacao.setBounds(18, 397, 57, 33);
		btnCancelarOperacao.setToolTipText("CANCELAR");
		panel.add(btnCancelarOperacao);
		
		btnAlterarCliente.setBackground(new Color(245, 245, 245));
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar = "alterar";
				int linhaSelecionada = tbCliente.getSelectedRow();

				if (linhaSelecionada != -1) {
					int codigoCliente = (int) tbCliente.getValueAt(linhaSelecionada, 0);

					try {
						habilitaCampos(rootPaneCheckingEnabled);
						// RECUPERAR DADOS DO BANCO
						modelCliente = controllerCliente.retornarProdutoController(codigoCliente);

						// MOSTRAR NA INTERFACE
						txtCodCliente.setText(String.valueOf(modelCliente.getIdCliente()));
						txtNomeCliente.setText(modelCliente.getNomeCliente());
						txtEndCliente.setText(String.valueOf(modelCliente.getEnderecoCliente()));
						txtBairroCliente.setText(String.valueOf(modelCliente.getBairroCliente()));
						txtCidadeCliente.setText(String.valueOf(modelCliente.getCidadeCliente()));
						cbCliente.setToolTipText(String.valueOf(modelCliente.getUfCliente()));
						txtCepCliente.setText(String.valueOf(modelCliente.getCepCliente()));
						txtTelefoneCliente.setText(String.valueOf(modelCliente.getTelefoneCliente()));

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar o Cliente!", "Atenção", 0,
								new ImageIcon(getClass().getResource("/img/icon_erro.png")));
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado!", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}

			}
		});

		btnAlterarCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_editar.png")));
		btnAlterarCliente.setBounds(267, 397, 57, 33);
		btnAlterarCliente.setToolTipText("ALTERAR");
		panel.add(btnAlterarCliente);
		btnSalvarCliente.setBackground(new Color(245, 245, 245));
		btnSalvarCliente.setEnabled(false);

		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (salvarAlterar.equals("salvar")) {
					salvarCliente();

				} else if (salvarAlterar.equals("alterar")) {
					alterarCliente();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar Cliente", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}

			}
		});
		btnSalvarCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_salvar.png")));
		btnSalvarCliente.setBounds(334, 397, 57, 33);
		btnSalvarCliente.setToolTipText("SALVAR");
		panel.add(btnSalvarCliente);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 169, 414, 2);
		panel.add(separator);
		cbCliente.setEnabled(false);

		cbCliente.setModel(new DefaultComboBoxModel(new String[] { "\u00A0AC", "\u00A0AL", "\u00A0AP", "\u00A0AM",
				"\u00A0BA", "\u00A0CE", "\u00A0DF", "\u00A0ES", "\u00A0GO", "\u00A0MA", "\u00A0MT", "\u00A0MS",
				"\u00A0MG", "\u00A0PA", "\u00A0PB", "\u00A0PR", "\u00A0PE", "\u00A0PI", "\u00A0RJ", "\u00A0RN",
				"\u00A0RS", "\u00A0RO", "\u00A0RR", "\u00A0SC", "\u00A0SP", "\u00A0SE", "\u00A0TO" }));
		cbCliente.setBounds(344, 87, 47, 22);
		panel.add(cbCliente);
		btnRemoverCliente.setBackground(new Color(245, 245, 245));
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSeleciona = tbCliente.getSelectedRow();

				if (linhaSeleciona != -1) {

					int codigoCliente = (int) tbCliente.getValueAt(linhaSeleciona, 0);

					int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado? ",
							"Excluir", JOptionPane.YES_NO_OPTION);
					if (confirma == JOptionPane.YES_OPTION) {
						if (controllerCliente.excluirClienteController(codigoCliente)) {
							JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", 0,
									new ImageIcon(getClass().getResource("/img/icon_correto.png")));
							carregarCliente();

						} else {
							JOptionPane.showMessageDialog(null, "Erro ao excuir Cliente!!", "Atenção", 0,
									new ImageIcon(getClass().getResource("/img/icon_erro.png")));
						}
						;
					}

				} else {
					JOptionPane.showMessageDialog(null, "Nenhum Cliente Selecionado", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}
			}
		});

		btnRemoverCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_excluir.png")));
		btnRemoverCliente.setBounds(88, 325, 57, 33);
		btnRemoverCliente.setToolTipText("REMOVER");
		panel.add(btnRemoverCliente);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 380, 414, 2);
		panel.add(separator_1);

		try {
			FormatoCEP = new MaskFormatter("#####-###");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Inserir campo personalizado", "Erro", 0);
		}
		txtCepCliente = new JFormattedTextField(FormatoCEP);
		txtCepCliente.setEnabled(false);
		txtCepCliente.setBounds(88, 125, 100, 20);
		panel.add(txtCepCliente);

		try {
			FormatoTelefone = new MaskFormatter("(##) # ####-####");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Inserir campo personalizado", "Erro", 0);
		}
		txtTelefoneCliente = new JFormattedTextField(FormatoTelefone);
		txtTelefoneCliente.setEnabled(false);
		txtTelefoneCliente.setBounds(261, 125, 131, 20);
		panel.add(txtTelefoneCliente);
	}

	private void carregarCliente() {
		listaModelCliente = controllerCliente.listaClienteController();
		DefaultTableModel modeloTabela = (DefaultTableModel) tbCliente.getModel();
		modeloTabela.setNumRows(0);
		// INSERIR PRODUTOS
		int contador = listaModelCliente.size();

		for (int i = 0; i < contador; i++) {
			modeloTabela.addRow(new Object[] { listaModelCliente.get(i).getIdCliente(),
					listaModelCliente.get(i).getNomeCliente(), listaModelCliente.get(i).getCidadeCliente(),
					listaModelCliente.get(i).getTelefoneCliente() });
		}
	}

	private void salvarCliente() {
		modelCliente.setNomeCliente(this.txtNomeCliente.getText());
		modelCliente.setEnderecoCliente(this.txtEndCliente.getText());
		modelCliente.setBairroCliente(this.txtBairroCliente.getText());
		modelCliente.setCidadeCliente(this.txtCidadeCliente.getText());
		modelCliente.setUfCliente(this.cbCliente.getSelectedItem().toString());
		modelCliente.setCepCliente(this.txtCepCliente.getText());
		modelCliente.setTelefoneCliente(this.txtTelefoneCliente.getText());

		boolean retorno = controllerCliente.verificarDadosCliente(modelCliente);
		if (retorno) {
			if (controllerCliente.salvarClienteController(modelCliente) > 0) {
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso", "Sucesso", 0,
						new ImageIcon(getClass().getResource("/img/icon_correto.png")));
				carregarCliente();
				limparCampos();
				habilitaCampos(false);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente!", "Atenção", 0,
						new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			}
		}

	}

	private void alterarCliente() {
		modelCliente.setNomeCliente(this.txtNomeCliente.getText());
		modelCliente.setEnderecoCliente(this.txtEndCliente.getText());
		modelCliente.setBairroCliente(this.txtBairroCliente.getText());
		modelCliente.setCidadeCliente(this.txtCidadeCliente.getText());
		modelCliente.setUfCliente(this.cbCliente.getSelectedItem().toString());
		modelCliente.setCepCliente(this.txtCepCliente.getText());
		modelCliente.setTelefoneCliente(this.txtTelefoneCliente.getText());

		boolean retorno = controllerCliente.verificarDadosCliente(modelCliente);
		if (retorno) {
			if (controllerCliente.alterarProdutoController(modelCliente)) {
				JOptionPane.showMessageDialog(null, "Cliente alterado com Sucesso", "Sucesso", 0,
						new ImageIcon(getClass().getResource("/img/icon_correto.png")));
				carregarCliente();
				limparCampos();
				habilitaCampos(false);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao alterar Cliente!", "Atenção", 0,
						new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			}
		}

	}

	private void limparCampos() {
		txtCodCliente.setText("");
		txtNomeCliente.setText("");
		txtEndCliente.setText("");
		txtBairroCliente.setText("");
		txtCidadeCliente.setText("");
		cbCliente.setSelectedItem("");
		txtCepCliente.setText("");
		txtTelefoneCliente.setText("");
	}

	private void habilitaCampos(boolean condicao) {
		txtNomeCliente.setEnabled(condicao);
		txtEndCliente.setEnabled(condicao);
		txtBairroCliente.setEnabled(condicao);
		txtCidadeCliente.setEnabled(condicao);
		cbCliente.setEnabled(condicao);
		txtCepCliente.setEnabled(condicao);
		txtTelefoneCliente.setEnabled(condicao);
		btnCancelarOperacao.setEnabled(condicao);
		btnSalvarCliente.setEnabled(condicao);
		txtNomeCliente.grabFocus();
	}

	private void cancelaOperacao() {
		txtNomeCliente.setEnabled(false);
		txtEndCliente.setEnabled(false);
		txtBairroCliente.setEnabled(false);
		txtCidadeCliente.setEnabled(false);
		cbCliente.setEnabled(false);
		txtCepCliente.setEnabled(false);
		txtTelefoneCliente.setEnabled(false);
		btnSalvarCliente.setEnabled(false);
		btnCancelarOperacao.setEnabled(false);
		btnNovoCliente.grabFocus();
	}

	public class CellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		public CellRenderer() {
			super();
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			this.setHorizontalAlignment((int) CENTER_ALIGNMENT);

			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}
}
