package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAO.DaoCliente;
import model.ModelCliente;

public class ControllerCliente { //TESTE JO�O
	private DaoCliente daoCliente = new DaoCliente();

	public int salvarClienteController(ModelCliente modelCliente) {
		return this.daoCliente.salvarClienteDAO(modelCliente);
	}

	public boolean excluirClienteController(int codigoCliente) {
		return this.daoCliente.excluirClienteDAO(codigoCliente);
	}

	public boolean alterarProdutoController(ModelCliente modelCliente) {
		return this.daoCliente.alterarClienteDAO(modelCliente);
	}

	public ModelCliente retornarProdutoController(int codigoCliente) {
		return this.daoCliente.retornarClienteDAO(codigoCliente);
	}

	public ArrayList<ModelCliente> listaClienteController() {
		return this.daoCliente.listaClienteDAO();
	}
	
	public boolean verificarDadosCliente(ModelCliente Cliente) {
		if (Cliente.getNomeCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo 'Nome'", "Obrigat�rio: Campo Nome", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getEnderecoCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Endere�o", "Obrigat�rio: Campo Endere�o", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getBairroCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "Obrigat�rio: Campo Bairro", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getCidadeCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Cidade", "Obrigat�rio: Campo Cidade", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getUfCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo UF", "Obrigat�rio: Campo UF", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getCepCliente().equals("     -   ")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo CEP", "Obrigat�rio: Campo CEP", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getTelefoneCliente().equals("(  )       -    ")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "Obrigat�rio: Campo Telefone", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		return true;
	}
}
