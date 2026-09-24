package br.edu.uapi.devshowcase;

import jakarta.validation.constraints.*;

public record FeedbackRequest(
    @NotNull(message = "A nota é obrigatória.")
    @Min(value = 1, message = "A nota deve ser de 1 a 5.")
    @Max(value = 5, message = "A nota deve ser de 1 a 5.")
    Integer rating,

    @NotBlank(message = "O comentário é obrigatório.")
    @Size(max = 1000, message = "O comentário deve ter no máximo 1000 caracteres.")
    String comment
) {}
