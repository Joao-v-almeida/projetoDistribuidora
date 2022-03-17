package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class FrmPrincipal {

	private static final int MAXIMIZED_BOTH = 0;
	private JFrame frmDistribuidora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal window = new FrmPrincipal();
					window.frmDistribuidora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDistribuidora = new JFrame();
		frmDistribuidora.setResizable(false);
		frmDistribuidora.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmDistribuidora.setTitle("Distribuidora");
		frmDistribuidora.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/icon_menu.png")));
		frmDistribuidora.setBounds(100, 100, 450, 300);
		frmDistribuidora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmDistribuidora.setJMenuBar(menuBar);
		
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
				FrmUsuario frmUsuario = new FrmUsuario();
				frmUsuario.setVisible(true);
			}
		});
		menuUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/icon_usuario.png")));
		menuCadastro.add(menuUsuarios);
		
		JMenu menuVendas = new JMenu("Vendas");
		menuBar.add(menuVendas);
		
		JMenu menuArquivos = new JMenu("Sistema");
		menuBar.add(menuArquivos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/Icon_sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuArquivos.add(btnSair);
	}

}
