/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author MAHFUZ_CSE'11
 */
@Entity
@Table(name = "RESULT", catalog = "", schema = "SHIHAB")
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findByBangla", query = "SELECT r FROM Result r WHERE r.bangla = :bangla"),
    @NamedQuery(name = "Result.findByEnglish", query = "SELECT r FROM Result r WHERE r.english = :english"),
    @NamedQuery(name = "Result.findByStudentId", query = "SELECT r FROM Result r WHERE r.studentId = :studentId")})
public class Result implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "BANGLA")
    private BigInteger bangla;
    @Column(name = "ENGLISH")
    private BigInteger english;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private String studentId;

    public Result() {
    }

    public Result(String studentId) {
        this.studentId = studentId;
    }

    public BigInteger getBangla() {
        return bangla;
    }

    public void setBangla(BigInteger bangla) {
        BigInteger oldBangla = this.bangla;
        this.bangla = bangla;
        changeSupport.firePropertyChange("bangla", oldBangla, bangla);
    }

    public BigInteger getEnglish() {
        return english;
    }

    public void setEnglish(BigInteger english) {
        BigInteger oldEnglish = this.english;
        this.english = english;
        changeSupport.firePropertyChange("english", oldEnglish, english);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        String oldStudentId = this.studentId;
        this.studentId = studentId;
        changeSupport.firePropertyChange("studentId", oldStudentId, studentId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "p1.Result[ studentId=" + studentId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
