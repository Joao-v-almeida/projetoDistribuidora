package controller;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAO.DaoUsuario;
import model.ModelUsuario;

public class ControllerUsuario {
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	
	public int salvarUsuarioController(ModelUsuario modelUsuario) {
		return this.daoUsuario.salvarUsuarioDAO(modelUsuario);
	}
	
	public boolean excluirUsuarioController(int codigoUsuario) {
		return this.daoUsuario.excluirUsuarioDAO(codigoUsuario);
	}
	
	public boolean alterarUsuarioController(ModelUsuario modelUsuario) {
		return this.daoUsuario.alterarUsuarioDAO(modelUsuario);
		
	}
	
	public ModelUsuario retornarProdutoController(int codigoUsuario) {
		return this.daoUsuario.retornarUsuarioDAO(codigoUsuario);
	}

	public ArrayList<ModelUsuario> listaUsuarioController() {
		return this.daoUsuario.listaUsuarioDAO();
	}
	
	public boolean verificarDadosUsuario(ModelUsuario Usuario) {
		if (Usuario.getNomeUsuario().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "Obrigatório: Campo Nome", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		
		if (Usuario.getLoginUsuario().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Login", "Obrigatório: Campo Login", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;
		}
		
		if (Usuario.getSenhaUsuario().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo Senha", "Obrigatório: Campo Senha", 0,
					new ImageIcon(getClass().getResource("/img/icon_erro.png")));
			return false;	
		
		}
		return true;
	}
}
	

