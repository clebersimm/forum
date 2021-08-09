package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

@Service
class TopicoService(
	private var repository: TopicoRepository,
	private val topicoViewMapper: TopicoViewMapper,
	private val topicoFormMapper: TopicoFormMapper,
	private val notFoundMessage: String = "Topico não encontrado"
) {

	fun listar(
		nomeCurso: String?,
		paginacao: Pageable
	): Page<TopicoView> {
		val topicos = if (nomeCurso == null) {
			repository.findAll(paginacao)
		} else {
			repository.findByCursoByNome(nomeCurso, paginacao)
		}
		return topicos.map { t ->
			topicoViewMapper.map(t)
		}
	}

	fun buscarPorId(id: Long): TopicoView {
		val t = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
		return topicoViewMapper.map(t)
	}

	fun cadastrar(topicoDTO: NovoTopicoForm): TopicoView {
		var topico = topicoFormMapper.map(topicoDTO)
		repository.save(topico)
		return topicoViewMapper.map(topico)
	}

	fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
		val t = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
		t.titulo = form.titulo
		t.mensagem = form.mensagem
		return topicoViewMapper.map(t)
	}

	fun deletar(id: Long) {
		repository.deleteById(id)
	}
}