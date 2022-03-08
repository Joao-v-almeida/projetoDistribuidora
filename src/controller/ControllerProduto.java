package controller;

import java.util.ArrayList;

import DAO.DaoProduto;
import model.ModelProduto;

public class ControllerProduto {

	private DaoProduto daoProduto = new DaoProduto();

	public int salvarProdutoController(ModelProduto modelProduto) {
		return this.daoProduto.salvarProdutoDAO(modelProduto);
	}

	public boolean excluirProdutoController(int codigoProduto) {
		return this.daoProduto.excluirProdutoDAO(codigoProduto);
	}

	public boolean alterarProdutoController(ModelProduto modelProduto) {
		return this.daoProduto.alterarProdutoDAO(modelProduto);
	}

	public ModelProduto retornarProdutoController(int codigoProduto) {
		return this.daoProduto.retornarProdutoDAO(codigoProduto);
	}

	public ArrayList<ModelProduto> listaProdutoController() {
		return this.daoProduto.listaProdutosDAO();
	}
}
