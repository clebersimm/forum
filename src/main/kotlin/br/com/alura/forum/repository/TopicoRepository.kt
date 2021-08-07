package br.com.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.alura.forum.model.Topico

interface TopicoRepository : JpaRepository<Topico, Long> {
}