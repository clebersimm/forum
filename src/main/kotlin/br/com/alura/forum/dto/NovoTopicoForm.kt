package br.com.alura.forum.dto

data class NovoTopicoForm(
    var titulo: String,
    var mensagem: String,
    val idCurso: Long,
    val idUsuario: Long
)
