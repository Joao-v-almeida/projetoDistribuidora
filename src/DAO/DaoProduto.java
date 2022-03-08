package DAO;

import java.util.ArrayList;

import conexoes.ConexaoMySql;
import model.ModelProduto;

public class DaoProduto extends ConexaoMySql {

	public int salvarProdutoDAO(ModelProduto produto) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO PRO_PRODUTOS (" + "PRO_NOME," + "PRO_VALOR," + "PRO_ESTOQUE"
					+ ") VALUES (" + "'" + produto.getnomeProduto() + "'," + "'" + produto.getValorProduto() + "',"
					+ "'" + produto.getEstoqueProduto() + "'" + ");");

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.fecharConexao();
		}

	}

	public boolean excluirProdutoDAO(int idProduto) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("DELETE FROM PRO_PRODUTOS WHERE PRO_ID = '" + idProduto + "';");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	public boolean alterarProdutoDAO(ModelProduto produto) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE PRO_PRODUTOS SET " + "PRO_NOME = '" + produto.getnomeProduto()
					+ "'," + "PRO_VALOR = '" + produto.getValorProduto() + "'," + "PRO_ESTOQUE = '"
					+ produto.getEstoqueProduto() + "'" + " WHERE PRO_ID = '" + produto.getIdProduto() + "';");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	public ModelProduto retornarProdutoDAO(int idProduto) {
		ModelProduto modelProduto = new ModelProduto();

		try {
			this.conectar();
			this.executarSQL("SELECT PRO_ID, PRO_NOME, PRO_VALOR, PRO_ESTOQUE FROM PRO_PRODUTOS WHERE PRO_ID = '"
					+ idProduto + "';");

			while (this.getResultSet().next()) {
				modelProduto.setIdProduto(this.getResultSet().getInt(1));
				modelProduto.setnomeProduto(this.getResultSet().getString(2));
				modelProduto.setValorProduto(this.getResultSet().getDouble(3));
				modelProduto.setEstoqueProduto(this.getResultSet().getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}
		return modelProduto;
	}

	public ArrayList<ModelProduto> listaProdutosDAO() {
		ArrayList<ModelProduto> listaProdutos = new ArrayList<>();
		ModelProduto modelProduto = new ModelProduto();

		try {
			this.conectar();
			this.executarSQL("SELECT PRO_ID, PRO_NOME, PRO_VALOR, PRO_ESTOQUE FROM PRO_PRODUTOS;");

			while (this.getResultSet().next()) {
				modelProduto = new ModelProduto();
				modelProduto.setIdProduto(this.getResultSet().getInt(1));
				modelProduto.setnomeProduto(this.getResultSet().getString(2));
				modelProduto.setValorProduto(this.getResultSet().getDouble(3));
				modelProduto.setEstoqueProduto(this.getResultSet().getInt(4));
				listaProdutos.add(modelProduto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return listaProdutos;
	}
}
