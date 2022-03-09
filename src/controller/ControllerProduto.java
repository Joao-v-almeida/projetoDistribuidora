package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
	
	public boolean verificarItens(String Nome, String Estoque, String Valor) {

		if (Nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo 'Nome'", "Obrigatório: Campo Nome", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}

		// ESTOQUE
		if (Estoque.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo 'Estoque'", "Obrigatório: Campo Estoque", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}

		try {
			int x = Integer.parseInt(Estoque);
			if (x <= 0) {
				JOptionPane.showMessageDialog(null, "Estoque não pode ser menor ou igual a zero", "Erro", 0,
						new ImageIcon(getClass().getResource("/img/icon_erro.png")));
				return false;
			}
		} catch (NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Insira um número válido no campo 'Estoque'", "Erro", 0,
					new ImageIcon("Imagens/erro.png"));
			return false;
		}

		// VALOR
		if (Valor.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo 'Valor'", "Obrigatório: Campo Valor", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}

		double x = Double.parseDouble(Valor);
		if (x <= 0) {
			JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a zero", "Erro", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}

		return true;
	}
}
