package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import br.com.alura.forum.repository.UsuarioRepository

@Service
class UsuarioService(private val repository: UsuarioRepository) {

	fun buscaPorId(idUsuario: Long): Usuario {
		return repository.getOne(idUsuario)
	}

}
