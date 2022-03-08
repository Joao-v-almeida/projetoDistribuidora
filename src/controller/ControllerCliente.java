package controller;

import java.util.ArrayList;

import DAO.DaoCliente;
import model.ModelCliente;

public class ControllerCliente {
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
}
