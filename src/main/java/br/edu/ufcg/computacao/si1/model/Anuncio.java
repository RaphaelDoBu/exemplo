package br.edu.ufcg.computacao.si1.model;

import javax.persistence.*;

import br.edu.ufcg.computacao.si1.controller.UsuarioController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Marcus Oliveira on 08/12/16.
 */
@Entity
@Table(name="tb_anuncio")
public class Anuncio {

    private static final String[] tipos = new String[] {"movel", "imovel", "emprego", "serviço"};


    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id", nullable = false, unique = true)
    private Long _id;
    
    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "data_criacao", nullable = false)
    private Date dataDeCriacao;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "nota")
    private String nota;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    UsuarioController uc = new UsuarioController();
    
    public Anuncio(String titulo, Date dataDeCriacao, double preco, String nota, String tipo, long idUsuario) {
        //this.titulo = ;
    	this.titulo = titulo;
        this.dataDeCriacao = dataDeCriacao;
        this.preco = preco;
        this.nota = nota;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }

    public Anuncio() {
        titulo = "";
        dataDeCriacao = removeTime(new Date());
        preco = 0;
        nota = "";
        tipo = "";
        this.idUsuario = (long)-1;
    }

    /**
     * Retorna o id do anuncio
     * @return o id do anuncio
     */
    public Long get_id() {
        return _id;
    }

    /**
     * Modifica o id do anuncio
     * @param _id id a ser colocado no anuncio
     */public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataDeCriacao() {
        return DATE_FORMAT.format(dataDeCriacao);
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio)) return false;

        Anuncio anuncio = (Anuncio) o;

        if (Double.compare(anuncio.getPreco(), getPreco()) != 0) return false;
        if (!get_id().equals(anuncio.get_id())) return false;
        if (!getTitulo().equals(anuncio.getTitulo())) return false;
        if (!getDataDeCriacao().equals(anuncio.getDataDeCriacao())) return false;
        if (getNota() != null ? !getNota().equals(anuncio.getNota()) : anuncio.getNota() != null) return false;
        return getTipo().equals(anuncio.getTipo());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = get_id().hashCode();
        result = 31 * result + getTitulo().hashCode();
        result = 31 * result + getDataDeCriacao().hashCode();
        temp = Double.doubleToLongBits(getPreco());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getNota() != null ? getNota().hashCode() : 0);
        result = 31 * result + getTipo().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "_id=" + _id +
                ", titulo='" + titulo + '\'' +
                ", dataDeCriacao=" + getDataDeCriacao() +
                ", preco=" + preco +
                ", nota=" + nota +
                ", tipo='" + tipo + '\'' +
                '}';
    }
    
    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
