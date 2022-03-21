package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import controller.ControllerUsuario;
import model.ModelUsuario;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;

public class FrmUsuario extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private ControllerUsuario controllerUsuario = new ControllerUsuario();
	private ModelUsuario modelUsuario = new ModelUsuario();
	private JPanel contentPane;
	private JTextField txtCodUsu;
	private JTextField txtNomeUsu;
	private JTextField txtLoginUsu;
	private JTable tableUsuario;
	private JButton btnNovoUsuario = new JButton("");
	private JButton btnCancelarUsuario = new JButton("");
	private JButton btnAlterarUsuario = new JButton("");
	private JButton btnCadastrarUsuario = new JButton("");
	private JButton btnRemoverUsuario = new JButton("");
	private String salvarAlterar;
	private ArrayList<ModelUsuario> listaModelUsuario = new ArrayList<>();
	private JPasswordField passwordSenhaUsuario;
	
	public FrmUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmUsuario.class.getResource("/img/icon_usuario.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				btnNovoUsuario.grabFocus();
			}
		});
		initComponents();
		carregarUsuario();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario frame = new FrmUsuario();
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
		setTitle("Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(5, 5, 430, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("Código:");
		lblCod.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCod.setBounds(21, 13, 43, 17);
		lblCod.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblCod);
		
		txtCodUsu = new JTextField();
		txtCodUsu.setEnabled(false);
		txtCodUsu.setBounds(68, 13, 73, 18);
		panel.add(txtCodUsu);
		txtCodUsu.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(21, 53, 37, 17);
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNome);
		
		txtNomeUsu = new JTextField();
		txtNomeUsu.setEnabled(false);
		txtNomeUsu.setBounds(68, 52, 273, 20);
		panel.add(txtNomeUsu);
		txtNomeUsu.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLogin.setBounds(21, 94, 46, 14);
		panel.add(lblLogin);
		
		txtLoginUsu = new JTextField();
		txtLoginUsu.setEnabled(false);
		txtLoginUsu.setBounds(68, 91, 273, 20);
		panel.add(txtLoginUsu);
		txtLoginUsu.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSenha.setBounds(21, 136, 46, 14);
		panel.add(lblSenha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setBounds(18, 194, 373, 120);
		panel.add(scrollPane);
		
		tableUsuario = new JTable();
		tableUsuario.setGridColor(Color.GRAY);
		tableUsuario.setDefaultRenderer(Object.class, new CellRenderer());
		tableUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Login", "Nome"
			}
		));
		tableUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tableUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableUsuario.getColumnModel().getColumn(2).setPreferredWidth(70);
		
		scrollPane.setViewportView(tableUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 169, 414, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 380, 414, 2);
		panel.add(separator_1);
			btnCadastrarUsuario.setEnabled(false);
			btnCadastrarUsuario.setToolTipText("SALVAR");
		
		
		//btnCadastrar
			btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (salvarAlterar.equals("salvar")) {
					salvarUsuario();

				} else if (salvarAlterar.equals("alterar")) {
					alterarUsuario();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar Usuario", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}

			}
		});
		
		
		btnCadastrarUsuario.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/icon_salvar.png")));
		btnCadastrarUsuario.setBounds(334, 397, 57, 33);
		panel.add(btnCadastrarUsuario);
		btnAlterarUsuario.setToolTipText("ALTERAR");
		
		
		btnAlterarUsuario.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/icon_editar.png")));
		
		//btnAlterar
		
			btnAlterarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar = "alterar";
				int linhaSelecionada = tableUsuario.getSelectedRow();

				if (linhaSelecionada != -1) {
					int codigoUsuario = (int) tableUsuario.getValueAt(linhaSelecionada, 0);

					try {
						habilitaCampos(rootPaneCheckingEnabled);
						
						modelUsuario = controllerUsuario.retornarProdutoController(codigoUsuario);

						
						txtCodUsu.setText(String.valueOf(modelUsuario.getIdUsuario()));
						txtNomeUsu.setText(modelUsuario.getNomeUsuario());
						txtLoginUsu.setText(String.valueOf(modelUsuario.getLoginUsuario()));
						passwordSenhaUsuario.setText(String.valueOf(modelUsuario.getSenhaUsuario()));

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar o Usuario!", "Atenção", 0,
								new ImageIcon(getClass().getResource("/img/icon_erro.png")));
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum Usuairo selecionado!", "Atenção", 0,
							new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				}

			}	
			
		});
			
			
		btnAlterarUsuario.setBounds(267, 397, 57, 33);
		panel.add(btnAlterarUsuario);
			btnCancelarUsuario.setEnabled(false);
			btnCancelarUsuario.setToolTipText("CANCELAR");
		
		//btnCancelar
		
			btnCancelarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limparCampos();
				cancelarUsuario();
			
			}
		});
		
		
		btnCancelarUsuario.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/icon_cancelar.png")));
		btnCancelarUsuario.setBounds(18, 397, 57, 33);
		panel.add(btnCancelarUsuario);
		
		
		//btnNovo
		
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarAlterar = "salvar";
				limparCampos();
				habilitaCampos(true);
			}
		});
		
		
		btnNovoUsuario.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/icon_novo.png")));
		btnNovoUsuario.setBounds(17, 325, 57, 33);
		panel.add(btnNovoUsuario);
		btnNovoUsuario.setToolTipText("INCLUIR");
		
		
		
		//btnRemover
		
			btnRemoverUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			int linhaSeleciona = tableUsuario.getSelectedRow();

			if (linhaSeleciona != -1) {

				int codigoUsuario = (int) tableUsuario.getValueAt(linhaSeleciona, 0);

				int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir o Usuario selecionado? ",
						"Excluir", JOptionPane.YES_NO_OPTION);
				if (confirma == JOptionPane.YES_OPTION) {
					if (controllerUsuario.excluirUsuarioController(codigoUsuario)) {
						JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso!", "Sucesso", 0,
								new ImageIcon(getClass().getResource("/img/icon_correto.png")));
						carregarUsuario();

					} else {
						JOptionPane.showMessageDialog(null, "Erro ao excuir Usuario!!", "Atenção", 0,
								new ImageIcon(getClass().getResource("/img/icon_erro.png")));
					}
					;
				}

			} else {
				JOptionPane.showMessageDialog(null, "Nenhum Usuario Selecionado", "Atenção", 0,
						new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			}
		
			}
		});
			
			
		btnRemoverUsuario.setIcon(new ImageIcon(FrmUsuario.class.getResource("/img/icon_excluir.png")));
		btnRemoverUsuario.setBounds(88, 325, 57, 33);
		btnRemoverUsuario.setToolTipText("REMOVER");
		panel.add(btnRemoverUsuario);
		
		passwordSenhaUsuario = new JPasswordField();
		passwordSenhaUsuario.setEnabled(false);
		passwordSenhaUsuario.setBounds(68, 134, 273, 20);
		panel.add(passwordSenhaUsuario);
		
		
		
		
	}
	
	private void carregarUsuario() {
		listaModelUsuario = controllerUsuario.listaUsuarioController();
		DefaultTableModel modeloTabela = (DefaultTableModel) tableUsuario.getModel();
		modeloTabela.setNumRows(0);
		
		int contator = listaModelUsuario.size();
		
		for (int i = 0;  i < contator; i++) {
			modeloTabela.addRow(new Object[] { listaModelUsuario.get(i).getIdUsuario(),
					listaModelUsuario.get(i).getNomeUsuario(), listaModelUsuario.get(i).getLoginUsuario()});
			}
		}
	

	private void alterarUsuario() {
		modelUsuario.setNomeUsuario(this.txtNomeUsu.getText());
		modelUsuario.setLoginUsuario(this.txtLoginUsu.getText());
		modelUsuario.setSenhaUsuario(this.passwordSenhaUsuario.getText());
		
		boolean retorno = controllerUsuario.verificarDadosUsuario(modelUsuario);
		if (retorno) {
			if (controllerUsuario.alterarUsuarioController(modelUsuario)) {
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com Sucesso", "Sucesso", 0,
						new ImageIcon(getClass().getResource("/img/icon_correto.png")));
				carregarUsuario();
				limparCampos();
				habilitaCampos(false);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuario!", "Atenção", 0,
						new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			}
		}

	}
	private void salvarUsuario() {
		modelUsuario.setNomeUsuario(this.txtNomeUsu.getText());
		modelUsuario.setLoginUsuario(this.txtLoginUsu.getText());
		modelUsuario.setSenhaUsuario(this.passwordSenhaUsuario.getText());
		
		boolean retorno = controllerUsuario.verificarDadosUsuario(modelUsuario);
		if (retorno) {
			if (controllerUsuario.salvarUsuarioController(modelUsuario) > 0 ){
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com Sucesso", "Sucesso", 0,
						new ImageIcon(getClass().getResource("/img/icon_correto.png")));
				carregarUsuario();
				limparCampos();
				habilitaCampos(false);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuario!", "Atenção", 0,
						new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			}
		}
	}
	

	private void limparCampos() {
	txtCodUsu.setText("");
	txtNomeUsu.setText("");
	passwordSenhaUsuario.setText("");
	txtLoginUsu.setText("");
	
}
	private void habilitaCampos(boolean condicao) {
		txtNomeUsu.setEnabled(condicao);
		txtLoginUsu.setEnabled(condicao);
		passwordSenhaUsuario.setEnabled(condicao);
		btnCancelarUsuario.setEnabled(condicao);
		btnCadastrarUsuario.setEnabled(condicao);
		txtNomeUsu.grabFocus();
	}
	
	private void cancelarUsuario() {
		txtNomeUsu.setEnabled(false);
		txtLoginUsu.setEnabled(false);
		passwordSenhaUsuario.setEnabled(false);
		btnCadastrarUsuario.setEnabled(false);
		btnCancelarUsuario.setEnabled(false);
		btnNovoUsuario.grabFocus();
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

