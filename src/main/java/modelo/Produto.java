package modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private Long id;

	@NotNull(message = "Preencha campo marca")
	@Column(nullable = false)
	private String marca;

	@NotNull(message = "Preencha campo categoria")
	@Column(nullable = false)
	private String categoria;

	@NotNull(message = "Preencha o campo nome")
	@Column(nullable = false)
	private String descricao;

	@NotNull(message = "Preencha o campo de quantidade")
	@Min(value = 1, message = "Valor mínimo permitido é 1")
	@Column(nullable = false)
	private Integer quantidade;

	@NotNull(message = "Preencha o campo preço")
	@Column(nullable = false)
	private Double preco;

	private String foto;

	public Produto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
