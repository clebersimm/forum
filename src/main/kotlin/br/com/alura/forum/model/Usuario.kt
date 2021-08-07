package br.com.alura.forum.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class Usuario(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,
	val nome: String,
	val email: String
)
