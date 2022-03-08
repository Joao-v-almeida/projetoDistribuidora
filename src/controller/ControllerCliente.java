package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAO.DaoCliente;
import model.ModelCliente;

public class ControllerCliente { //TESTE JOÃO
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
			JOptionPane.showMessageDialog(null, "Preencha o campo 'Nome'", "Obrigatório: Campo Nome", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getEnderecoCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Endereço", "Obrigatório: Campo Endereço", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getBairroCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "Obrigatório: Campo Bairro", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getCidadeCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Cidade", "Obrigatório: Campo Cidade", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getUfCliente().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo UF", "Obrigatório: Campo UF", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getCepCliente().equals("     -   ")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo CEP", "Obrigatório: Campo CEP", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		if (Cliente.getTelefoneCliente().equals("(  )       -    ")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "Obrigatório: Campo Telefone", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		return true;
	}
}
