package teste;

import banco.DAOGenerico;
import modelo.Produto;

public class Teste {

	public static void main(String[] args) {
		Produto prod = new Produto();
		DAOGenerico dao = new DAOGenerico();

		prod.setCategoria("Touca");
		prod.setDescricao("Raposa de nove caudas");
		prod.setMarca("Nihon prod");
		prod.setPreco(15.0);
		prod.setQuantidade(40);
		dao.inserir(prod);

	}

}
