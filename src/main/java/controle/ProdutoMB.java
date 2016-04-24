package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import banco.DAOGenerico;
import modelo.Produto;

@SessionScoped
@ManagedBean
public class ProdutoMB {

	private Produto objeto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	private DAOGenerico dao = new DAOGenerico();

	public ProdutoMB() {
		preencherLista();
	}

	public String salvar() {
		if (objeto.getId() == null) {
			dao.inserir(objeto);
		} else {
			dao.alterar(objeto);
		}
		preencherLista();
		criarNovoObjeto();
		return "lista_produto.jsf";
	}

	public void excluir(Produto obj) {
		this.objeto = obj;
		if (objeto.getId() != null) {
			try {
				dao.exluir(objeto);
			} catch (Exception ex) {

			}
		}
		criarNovoObjeto();
		preencherLista();
	}

	public String cancelar() {
		criarNovoObjeto();
		return "lista_produto.jsf";
	}

	public String cadastrar() {
		criarNovoObjeto();
		return "cadastro_produto.jsf";
	}

	public String alterar() {
		return "cadastro_produto.jsf";
	}

	public void criarNovoObjeto() {
		objeto = new Produto();
	}

	public void preencherLista() {
		produtos = dao.listar(Produto.class);
	}

	// GETTER E SETTER
	public Produto getObjeto() {
		return objeto;
	}

	public void setObjeto(Produto objeto) {
		this.objeto = objeto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
