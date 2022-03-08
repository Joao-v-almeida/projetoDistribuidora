package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JTextField txtCepCliente;
	private JTextField txtTelefoneCliente;
	private JScrollPane scrollPane;
	private JTable tbCliente;
	JButton btnNovoCliente = new JButton("");
	JButton btnCancelarOperacao = new JButton("");
	JButton btnAlterarCliente = new JButton("");
	JButton btnSalvarCliente = new JButton("");
	JButton btnRemoverCliente = new JButton("");
	JComboBox<Object> cbCliente = new JComboBox<Object>();

	ControllerCliente controllerCliente = new ControllerCliente();
	ModelCliente modelCliente = new ModelCliente();
	ArrayList<ModelCliente> listaModelCliente = new ArrayList<>();

	public FrmCliente() {
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
	public void initComponents() {
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
		panel.setBounds(0, 0, 414, 441);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 14, 43, 17);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);

		txtCodCliente = new JTextField();
		txtCodCliente.setBounds(88, 11, 51, 20);
		panel.add(txtCodCliente);
		txtCodCliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(177, 14, 37, 17);
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(224, 11, 167, 20);
		txtNomeCliente.setColumns(10);
		panel.add(txtNomeCliente);

		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(18, 52, 56, 17);
		panel.add(lblNewLabel_1);

		txtEndCliente = new JTextField();
		txtEndCliente.setBounds(88, 49, 303, 20);
		panel.add(txtEndCliente);
		txtEndCliente.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Bairro:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(37, 89, 37, 17);
		panel.add(lblNewLabel_2);

		txtBairroCliente = new JTextField();
		txtBairroCliente.setBounds(88, 86, 70, 20);
		panel.add(txtBairroCliente);
		txtBairroCliente.setColumns(10);

		lblNewLabel_3 = new JLabel("Cidade:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(173, 89, 41, 17);
		panel.add(lblNewLabel_3);

		txtCidadeCliente = new JTextField();
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

		txtCepCliente = new JTextField();
		txtCepCliente.setBounds(88, 123, 100, 20);
		panel.add(txtCepCliente);
		txtCepCliente.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(198, 126, 52, 17);
		panel.add(lblNewLabel_6);

		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setBounds(260, 123, 131, 20);
		panel.add(txtTelefoneCliente);
		txtTelefoneCliente.setColumns(10);

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

		btnNovoCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_novo.png")));
		btnNovoCliente.setBounds(17, 325, 57, 33);
		btnNovoCliente.setToolTipText("INCLUIR");
		panel.add(btnNovoCliente);

		btnCancelarOperacao.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_cancelar.png")));
		btnCancelarOperacao.setBounds(18, 397, 57, 33);
		btnCancelarOperacao.setToolTipText("CANCELAR");
		panel.add(btnCancelarOperacao);

		btnAlterarCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_editar.png")));
		btnAlterarCliente.setBounds(267, 397, 57, 33);
		btnAlterarCliente.setToolTipText("ALTERAR");
		panel.add(btnAlterarCliente);

		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarCliente();
				carregarCliente();

			}
		});
		btnSalvarCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_salvar.png")));
		btnSalvarCliente.setBounds(334, 397, 57, 33);
		btnSalvarCliente.setToolTipText("SALVAR");
		panel.add(btnSalvarCliente);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 169, 414, 2);
		panel.add(separator);

		cbCliente.setModel(new DefaultComboBoxModel(new String[] { "PR", "MT", "BA" }));
		cbCliente.setBounds(344, 87, 47, 22);
		panel.add(cbCliente);
		
		btnRemoverCliente.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/icon_excluir.png")));
		btnRemoverCliente.setBounds(88, 325, 57, 33);
		btnRemoverCliente.setToolTipText("REMOVER");
		panel.add(btnRemoverCliente);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 380, 414, 2);
		panel.add(separator_1);
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

		if (controllerCliente.salvarClienteController(modelCliente) > 0) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso", "Sucesso", 0,
					new ImageIcon(getClass().getResource("/img/icon_correto.png")));
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente!", "Atenção", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
		}
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
