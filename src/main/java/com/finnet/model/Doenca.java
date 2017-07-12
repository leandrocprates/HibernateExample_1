/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finnet.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "doenca", catalog = "mkyongdb")
public class Doenca implements Serializable {
    
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
        
        
/* relacionamento errado funcionando         
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doencas")
        private List<Paciente> pacientes ;
	
	public List<Paciente> getPaciente() {
		return this.pacientes;
	}        
        public void setPacientes(List<Paciente> pacientes) {
            this.pacientes = pacientes;
        }
*/        
        
        
   /*     
    @ManyToMany
      @JoinTable(name="relacionamento", catalog = "mkyongdb",  joinColumns=
      {@JoinColumn(name="doencaId")}, inverseJoinColumns=
        {@JoinColumn(name="periodoId")})
      private List periodo;

    
    public List getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List periodo) {
        this.periodo = periodo;
    }
    */    

        
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doencas")
        private List<Periodo> periodos ;

        public List<Periodo> getPeriodos() {
            return periodos;
        }

        public void setPeriodos(List<Periodo> periodos) {
            this.periodos = periodos;
        }
	
    
}
