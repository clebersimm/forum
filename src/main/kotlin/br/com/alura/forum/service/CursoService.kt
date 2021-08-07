package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*
import br.com.alura.forum.repository.CursoRepository

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscaPorId(id: Long): Curso {
        return repository.getOne(id)
    }

}
