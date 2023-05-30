package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Pergunta")
public class Pergunta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private String descricao; 
	  private String[] alternativas; 
	  private int correta;
	  private int valor; 

	  public Pergunta() {
		  
	  }
	  
	  public Pergunta(String descricao, String[] alternativas, int correta, int valor) {
	    this.descricao = descricao;
	    this.alternativas = alternativas;
	    this.correta = correta;
	    this.valor = valor;
	  }

	  
	  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
	    return descricao;
	  }

	  public String[] getAlternativas() {
	    return alternativas;
	  }

	  public int getCorreta() {
	    return correta;
	  }

	  public int getValor() {
	    return valor;
	  }

	  public void setDescricao(String descricao) {
	    this.descricao = descricao;
	  }

	  public void setAlternativas(String[] alternativas) {
	    this.alternativas = alternativas;
	  }

	  public void setCorreta(int correta) {
	    this.correta = correta;
	  }

	  public void setValor(int valor) {
	    this.valor = valor;
	  }
	  public void imprimirAlternativas() {
		    for (int i = 0; i < alternativas.length; i++) {
		        System.out.println((i + 1) + ". " + alternativas[i]);
		    }
		}

	}

