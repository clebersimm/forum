package br.com.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.alura.forum.model.Topico
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.Query
import br.com.alura.forum.dto.TopicoPorCategoriaDTO

interface TopicoRepository : JpaRepository<Topico, Long> {

	fun findByCursoByNome(nomeCurso: String, paginacao: Pageable): Page<Topico>
	@Query("SELECT new br.com.alura.forum.dto.TopicoPorCategoria(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria ")
	fun relatorio(): List<TopicoPorCategoriaDTO>

}