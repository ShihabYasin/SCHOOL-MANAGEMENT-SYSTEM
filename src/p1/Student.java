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
 * @author piya
 */
@Entity
@Table(name = "STUDENT", catalog = "", schema = "SHIHAB")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.findByBloodGroup", query = "SELECT s FROM Student s WHERE s.bloodGroup = :bloodGroup"),
    @NamedQuery(name = "Student.findByClass1", query = "SELECT s FROM Student s WHERE s.class1 = :class1"),
    @NamedQuery(name = "Student.findByClassRoll", query = "SELECT s FROM Student s WHERE s.classRoll = :classRoll"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId")})
public class Student implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;
    @Column(name = "CLASS")
    private BigInteger class1;
    @Column(name = "CLASS_ROLL")
    private BigInteger classRoll;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private String studentId;

    public Student() {
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        String oldBloodGroup = this.bloodGroup;
        this.bloodGroup = bloodGroup;
        changeSupport.firePropertyChange("bloodGroup", oldBloodGroup, bloodGroup);
    }

    public BigInteger getClass1() {
        return class1;
    }

    public void setClass1(BigInteger class1) {
        BigInteger oldClass1 = this.class1;
        this.class1 = class1;
        changeSupport.firePropertyChange("class1", oldClass1, class1);
    }

    public BigInteger getClassRoll() {
        return classRoll;
    }

    public void setClassRoll(BigInteger classRoll) {
        BigInteger oldClassRoll = this.classRoll;
        this.classRoll = classRoll;
        changeSupport.firePropertyChange("classRoll", oldClassRoll, classRoll);
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "p1.Student[ studentId=" + studentId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
