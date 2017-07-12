/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finnet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author lprates
 */

@Entity
@Table(name = "paciente", catalog = "mkyongdb")
public class Paciente implements Serializable {
    
        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
    
	private Integer id;
        @Column(name = "name", nullable = true, length = 255)
	private String name;
    
        
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        
/*        
    @ManyToMany
      @JoinTable(name="relacionamento", catalog = "mkyongdb",  joinColumns=
      {@JoinColumn(name="pacienteId")}, inverseJoinColumns=
        {@JoinColumn(name="doencaId")})
    private List<Doenca> doencas ;
    
    
    public List<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List doencas) {
        this.doencas = doencas;
    }
*/
        

        
    @ManyToMany
      @JoinTable(name="relacionamento", catalog = "mkyongdb",  joinColumns=
      {@JoinColumn(name="pacienteId")}, inverseJoinColumns=
        {@JoinColumn(name="periodoId")})
    private List<Periodo> periodos ;

    
    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }
    


    
    
}
