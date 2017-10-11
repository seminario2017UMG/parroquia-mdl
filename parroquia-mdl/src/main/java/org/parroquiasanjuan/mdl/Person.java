/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.parroquiasanjuan.mdl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lveliz
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson")
    , @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Person.findByFirstname2", query = "SELECT p FROM Person p WHERE p.firstname2 = :firstname2")
    , @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")
    , @NamedQuery(name = "Person.findByLastname2", query = "SELECT p FROM Person p WHERE p.lastname2 = :lastname2")
    , @NamedQuery(name = "Person.findByBirthdate", query = "SELECT p FROM Person p WHERE p.birthdate = :birthdate")
    , @NamedQuery(name = "Person.findByIdentificationNumber", query = "SELECT p FROM Person p WHERE p.identificationNumber = :identificationNumber")
    , @NamedQuery(name = "Person.findByGenre", query = "SELECT p FROM Person p WHERE p.genre = :genre")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSON")
    private Integer idPerson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 25)
    @Column(name = "FIRSTNAME_2")
    private String firstname2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LASTNAME_2")
    private String lastname2;
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "GENRE")
    private String genre;
    @JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID_ADDRESS")
    @ManyToOne(optional = false)
    private Address idAddress;
    @JoinColumn(name = "ID_IDENTIFICATION_TYPE", referencedColumnName = "ID_IDENTIFICATION_TYPE")
    @ManyToOne(optional = false)
    private IdentificationType idIdentificationType;
    @JoinColumn(name = "ID_MARITAL_STATUS", referencedColumnName = "ID_MARITAL_STATUS")
    @ManyToOne(optional = false)
    private MaritalStatus idMaritalStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private List<Employee> employeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private List<Phone> phoneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private List<Patient> patientList;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String firstname, String lastname, String lastname2, String identificationNumber, String genre) {
        this.idPerson = idPerson;
        this.firstname = firstname;
        this.lastname = lastname;
        this.lastname2 = lastname2;
        this.identificationNumber = identificationNumber;
        this.genre = genre;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    public IdentificationType getIdIdentificationType() {
        return idIdentificationType;
    }

    public void setIdIdentificationType(IdentificationType idIdentificationType) {
        this.idIdentificationType = idIdentificationType;
    }

    public MaritalStatus getIdMaritalStatus() {
        return idMaritalStatus;
    }

    public void setIdMaritalStatus(MaritalStatus idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @XmlTransient
    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @XmlTransient
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.parroquiasanjuan.mdl.Person[ idPerson=" + idPerson + " ]";
    }
    
}
