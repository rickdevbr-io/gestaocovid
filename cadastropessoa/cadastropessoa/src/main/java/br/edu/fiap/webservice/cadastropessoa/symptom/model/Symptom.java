package br.edu.fiap.webservice.cadastropessoa.symptom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_symptom_symp")
@SequenceGenerator(name = "sq_symptom_symp", initialValue = 1, allocationSize = 1)
public class Symptom {
	
	@Id
	@GeneratedValue(generator = "sq_symptom_symp", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_symptom", nullable = false)
	private Long id;
	
	@Column(name = "st_description", nullable = false)
	private String description;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
}
