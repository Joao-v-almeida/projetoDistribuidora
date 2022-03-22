package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Dimension;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/icon_menu.png")));
		setTitle("Distribuidora");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 744);
		contentPane = new JPanel();
		contentPane.setRequestFocusEnabled(false);
		contentPane.setOpaque(false);
		contentPane.setPreferredSize(new Dimension(20, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 22);
		contentPane.add(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastros");
		menuBar.add(menuCadastro);
		
		JMenuItem menuClientes = new JMenuItem("Clientes");
		menuClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCliente frmCliente = new FrmCliente();
				frmCliente.setVisible(true);
			}
		});
		menuClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon_cliente.png")));
		menuCadastro.add(menuClientes);
		
		JMenuItem menuProdutos = new JMenuItem("Produtos");
		menuProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProduto frmProduto = new FrmProduto();
				frmProduto.setVisible(true);
			}
		});
		menuProdutos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon_produto.png")));
		menuCadastro.add(menuProdutos);
		
		JMenuItem menuUsuarios = new JMenuItem("Usu\u00E1rios");
		menuUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon_usuario.png")));
		menuCadastro.add(menuUsuarios);
		
		JMenu menuVendas = new JMenu("Vendas");
		menuBar.add(menuVendas);
		
		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Icon_sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuSistema.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 705);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImgFundo = new JLabel("");
		lblImgFundo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/img_fundo.jpg")));
		lblImgFundo.setBounds(0, 0, 1366, 705);
		panel.add(lblImgFundo);
	}
}