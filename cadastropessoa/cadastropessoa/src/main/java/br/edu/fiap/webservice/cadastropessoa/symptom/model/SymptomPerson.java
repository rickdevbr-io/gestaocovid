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
@Table(name = "tb_person_symptom_pesy")
@SequenceGenerator(name = "sq_person_symptom_pesy", initialValue = 1, allocationSize = 1)
public class SymptomPerson {
	
	@Id
	@GeneratedValue(generator = "sq_person_symptom_pesy", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_person_symptom", nullable = false)
	private Long id;

	@Column(name = "id_person", nullable = false)
	private Long idPerson;
	
	@Column(name = "id_symptom", nullable = false)
	private Long idSymptom;

	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
}
