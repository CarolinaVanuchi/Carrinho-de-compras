package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import banco.DAOGenerico;
import modelo.Produto;
import util.CalculoFreteCorreio;
import util.RetornoFrete;


@SessionScoped
@ManagedBean
public class CarrinhoMB implements Serializable {
	private DAOGenerico dao = new DAOGenerico();
	private List<Produto> listaProdutos = new ArrayList<>();
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	private Double total = 0.;
	private Integer quantidade = 0;
	RetornoFrete retorno = new RetornoFrete();
	private String cepDestino = "";

	public CarrinhoMB() {
		preenherListaProduto();
	}

	/**
	 * Metodo para adcionar os produtos a lista, essa lista corresponde aos
	 * itens que o cliente comprou
	 */
	public void adicionarProduto(Produto prod) {
		this.produtos.add(prod);
		this.total += prod.getPreco();
		quantidade++;
	}

	/**
	 * Este metodo tem como objetivo adicionar ao atributo lista produto, os
	 * produtos cadastrados no banco de dados
	 */
	public void preenherListaProduto() {
		listaProdutos = dao.listar(Produto.class);
	}

	/**
	 * Este metodo tem o objetiva redirecionar o usuário a outra pagina, quando
	 * clicar no botão de finalizar compra
	 */
	public String finalizarCompra() {
		return "itens_comprados.xhtml";
	}

	/**
	 * Informar o valor do cep do usuário
	 */
	public void calcularFrete() {
		retorno = CalculoFreteCorreio.calculaFrete(cepDestino);
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public RetornoFrete getRetorno() {
		return retorno;
	}

	public void setRetorno(RetornoFrete retorno) {
		this.retorno = retorno;
	}
}
