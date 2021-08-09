package br.com.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.alura.forum.model.Topico
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

interface TopicoRepository : JpaRepository<Topico, Long> {

	fun findByCursoByNome(nomeCurso: String, paginacao: Pageable): Page<Topico>

}