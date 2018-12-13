/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author muril
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.id = :id")
    , @NamedQuery(name = "Comentario.findByIdUsuario", query = "SELECT c FROM Comentario c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Comentario.findByUrl", query = "SELECT c FROM Comentario c WHERE c.url = :url")
    , @NamedQuery(name = "Comentario.findByCommentUser", query = "SELECT c FROM Comentario c WHERE c.commentUser = :commentUser")
    , @NamedQuery(name = "Comentario.findByCommentData", query = "SELECT c FROM Comentario c WHERE c.commentData = :commentData")
    , @NamedQuery(name = "Comentario.findByCommentText", query = "SELECT c FROM Comentario c WHERE c.commentText = :commentText")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "commentUser")
    private String commentUser;
    @Column(name = "commentData")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentData;
    @Basic(optional = false)
    @Column(name = "commentText")
    private String commentText;

    public Comentario() {
    }

    public Comentario(Integer id) {
        this.id = id;
    }

    public Comentario(Integer id, int idUsuario, String url, String commentUser, String commentText) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.url = url;
        this.commentUser = commentUser;
        this.commentText = commentText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public Date getCommentData() {
        return commentData;
    }

    public void setCommentData(Date commentData) {
        this.commentData = commentData;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Comentario[ id=" + id + " ]";
    }
    
}
