package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            email = "test@example.com",
            nome = "Teste"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscaPorId(idUsuario: Long): Usuario {
        return usuarios.stream().filter { u ->
            u.id == idUsuario
        }.findFirst().get()
    }

}
