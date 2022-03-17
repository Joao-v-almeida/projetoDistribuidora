package DAO;

import java.util.ArrayList;


import model.ModelUsuario;
import conexoes.ConexaoMySql;

	
	public class DaoUsuario extends ConexaoMySql {
		
		public int salvarUsuarioDAO(ModelUsuario usuario) {
			try {
				this.conectar();
				return this.insertSQL("INSERT INTO usu_usuario (" + "USU_NOME," + "USU_LOGIN," + "USU_SENHA"
						+ ") VALUES (" + "'" + usuario.getNomeUsuario() + "'," + "'" + usuario.getLoginUsuario() + "',"
						+ "'" + usuario.getSenhaUsuario() + "'" + ");");

			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				this.fecharConexao();
			}

		}

		public boolean excluirUsuarioDAO(int idUsuario) {
			try {
				this.conectar();
				return this.executarUpdateDeleteSQL("DELETE FROM USU_USUARIO WHERE USU_ID = '" + idUsuario + "';");
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				this.fecharConexao();
			}
		}

		public boolean alterarUsuarioDAO(ModelUsuario usuario) {
			try {
				this.conectar();
				return this.executarUpdateDeleteSQL("UPDATE USU_USUARIO SET " + "USU_NOME = '" + usuario.getNomeUsuario()
						+ "'," + "USU_LOGIN = '" + usuario.getLoginUsuario() + "'," + "USU_SENHA = '"
						+ usuario.getSenhaUsuario() + "'" + " WHERE USU_ID = '" + "';");
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				this.fecharConexao();
			}
		}

		public ModelUsuario retornarUsuarioDAO(int idUsuario) {
			ModelUsuario modelUsuario = new ModelUsuario();

			try {
				this.conectar();
				this.executarSQL("SELECT * FROM USU_USUARIO WHERE USU_ID = '" + idUsuario + "';");

				while (this.getResultSet().next()) {
					modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
					modelUsuario.setNomeUsuario(this.getResultSet().getString(2));
					modelUsuario.setLoginUsuario(this.getResultSet().getString(3));
					modelUsuario.setSenhaUsuario(this.getResultSet().getString(4));
					
				}
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				fecharConexao();
			}
			return modelUsuario;
		}

		public ArrayList<ModelUsuario> listaUsuarioDAO() {
			ArrayList<ModelUsuario> listaUsuario = new ArrayList<>();
			ModelUsuario modelUsuario = new ModelUsuario();

			try {
				this.conectar();
				this.executarSQL("SELECT * FROM USU_USUARIO;");

				while (this.getResultSet().next()) {
					modelUsuario = new ModelUsuario();
					modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
					modelUsuario.setNomeUsuario(this.getResultSet().getString(2));
					modelUsuario.setLoginUsuario(this.getResultSet().getString(3));
					modelUsuario.setSenhaUsuario(this.getResultSet().getString(4));
					listaUsuario.add(modelUsuario);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fecharConexao();
			}
			return listaUsuario;
		}
	}
