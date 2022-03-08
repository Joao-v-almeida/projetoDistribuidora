package DAO;

import java.util.ArrayList;

import conexoes.ConexaoMySql;
import model.ModelCliente;

public class DaoCliente extends ConexaoMySql {
	public int salvarClienteDAO(ModelCliente cliente) {
		try {
			this.conectar();
			return this.insertSQL(
					"INSERT INTO CLI_CLIENTE (" + "CLI_NOME," + "CLI_ENDERECO," + "CLI_BAIRRO," + "CLI_CIDADE,"
							+ "CLI_UF," + "CLI_CEP," + "CLI_TELEFONE" + ") VALUES (" + "'" + cliente.getNomeCliente()
							+ "'," + "'" + cliente.getEnderecoCliente() + "'," + "'" + cliente.getBairroCliente() + "',"
							+ "'" + cliente.getCidadeCliente() + "'," + "'" + cliente.getUfCliente() + "'," + "'"
							+ cliente.getCepCliente() + "'," + "'" + cliente.getTelefoneCliente() + "'" + ");");

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.fecharConexao();
		}

	}

	public boolean excluirClienteDAO(int idCliente) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("DELETE FROM CLI_CLIENTE WHERE CLI_ID = '" + idCliente + "';");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	public boolean alterarClienteDAO(ModelCliente cliente) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE CLI_CLIENTE SET " + "CLI_NOME = '" + cliente.getNomeCliente()
					+ "'," + "CLI_ENDERECO = '" + cliente.getEnderecoCliente() + "'," + "CLI_BAIRRO = '"
					+ cliente.getBairroCliente() + "'," + "CLI_CIDADE = '" + cliente.getCidadeCliente() + "'," + "',"
					+ "CLI_UF = '" + cliente.getUfCliente() + "'," + "CLI_CEP = '" + cliente.getCepCliente() + "',"
					+ "CLI_TELEFONE = '" + cliente.getTelefoneCliente() + "'" + " WHERE CLI_ID = '"
					+ cliente.getIdCliente() + "';");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	public ModelCliente retornarClienteDAO(int idCliente) {
		ModelCliente modelCliente = new ModelCliente();

		try {
			this.conectar();
			this.executarSQL("SELECT * FROM CLI_CLIENTE WHERE CLI_ID = '" + idCliente + "';");

			while (this.getResultSet().next()) {
				modelCliente.setIdCliente(this.getResultSet().getInt(1));
				modelCliente.setNomeCliente(this.getResultSet().getString(2));
				modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
				modelCliente.setBairroCliente(this.getResultSet().getString(4));
				modelCliente.setCidadeCliente(this.getResultSet().getString(5));
				modelCliente.setUfCliente(this.getResultSet().getString(6));
				modelCliente.setCepCliente(this.getResultSet().getString(7));
				modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}
		return modelCliente;
	}

	public ArrayList<ModelCliente> listaClienteDAO() {
		ArrayList<ModelCliente> listaCliente = new ArrayList<>();
		ModelCliente modelCliente = new ModelCliente();

		try {
			this.conectar();
			this.executarSQL("SELECT * FROM CLI_CLIENTE;");

			while (this.getResultSet().next()) {
				modelCliente = new ModelCliente();
				modelCliente.setIdCliente(this.getResultSet().getInt(1));
				modelCliente.setNomeCliente(this.getResultSet().getString(2));
				modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
				modelCliente.setBairroCliente(this.getResultSet().getString(4));
				modelCliente.setCidadeCliente(this.getResultSet().getString(5));
				modelCliente.setUfCliente(this.getResultSet().getString(6));
				modelCliente.setCepCliente(this.getResultSet().getString(7));
				modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
				listaCliente.add(modelCliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return listaCliente;
	}
}
