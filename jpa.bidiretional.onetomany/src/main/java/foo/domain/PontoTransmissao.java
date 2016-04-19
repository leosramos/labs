package foo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 
 * @author jcruz
 *
 */
@Entity
public class PontoTransmissao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String nome;

	@OneToMany(cascade = { CascadeType.MERGE })
	@BatchSize(size = 10)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@JoinColumn(name = "PONTOTRANSMISSAO_ID")
	private List<LocalVotacao> locaisVotacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LocalVotacao> getLocaisVotacao() {
		if (this.locaisVotacao == null) {
			this.locaisVotacao = new ArrayList<LocalVotacao>();
		}
		return locaisVotacao;
	}

	public void setLocaisVotacao(List<LocalVotacao> locaisVotacao) {
		this.locaisVotacao = locaisVotacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoTransmissao other = (PontoTransmissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PontoTransmissao [id=" + id + ", nome=" + nome + ", locaisVotacao=" + locaisVotacao.size() + "]";
	}

}
