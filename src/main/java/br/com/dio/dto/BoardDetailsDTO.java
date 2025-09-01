package br.com.dio.dto;

import java.util.List;

// DTO que representa os detalhes de um quadro (Board).
// Contém o id, nome e a lista de colunas que fazem parte dele.
public record BoardDetailsDTO(Long id,
                              String name,
                              List<BoardColumnDTO> columns) {
}
