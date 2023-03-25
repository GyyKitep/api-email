package com.br.apiemail.mensagem;

import java.util.List;

public record DadosMensagem( List<String> destinatario, List<String> copia, String assunto, String corpo) {

}
