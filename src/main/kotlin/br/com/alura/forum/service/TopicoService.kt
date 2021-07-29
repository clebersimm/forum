package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            TopicoView(
                id = t.id,
                titulo = t.titulo,
                mensagem = t.mensagem,
                dataCriacao = t.dataCriacao,
                status = t.status
            )
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val t = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }

    fun cadastrar(topicoDTO: NovoTopicoForm) {
        topicos = topicos.plus(
            Topico(
                id = topicos.size.toLong() + 1,
                titulo = topicoDTO.titulo,
                mensagem = topicoDTO.mensagem,
                curso = cursoService.buscaPorId(topicoDTO.idCurso),
                usuario = usuarioService.buscaPorId(topicoDTO.idUsuario)
            )
        )
    }

}