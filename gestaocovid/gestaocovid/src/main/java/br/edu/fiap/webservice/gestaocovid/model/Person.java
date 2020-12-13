package br.edu.fiap.webservice.gestaocovid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tb_person_pers")
@SequenceGenerator(name = "sq_person_pers", initialValue = 1, allocationSize = 1)
public class Person {
	
	@Id
	@GeneratedValue(generator = "sq_person_pers", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_person", nullable = false)
	private Long id;
	
	@Column(name = "st_name", nullable = false)
	private String name;
	
	@Column(name = "st_identification", nullable = false)
	private String identification;
	
	@Column(name = "st_gender", nullable = false)
	private String gender;
	
	@Column(name = "dt_born")
	@Temporal(TemporalType.DATE)
	private Date born;

	@JoinColumn(name = "id_region")
	private Long idRegion;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

}
