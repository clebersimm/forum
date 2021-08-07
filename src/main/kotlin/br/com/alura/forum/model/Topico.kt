package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne
import javax.persistence.Enumerated
import javax.persistence.EnumType
import javax.persistence.OneToMany

@Entity
data class Topico(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null,
	val titulo: String,
	val mensagem: String,
	val dataCriacao: LocalDateTime = LocalDateTime.now(),
	@ManyToOne
	val curso: Curso,
	@ManyToOne
	val usuario: Usuario,
	@Enumerated(value = EnumType.STRING)
	val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
	@OneToMany(mappedBy = "topico")
	val respostas: List<Resposta> = ArrayList()
)