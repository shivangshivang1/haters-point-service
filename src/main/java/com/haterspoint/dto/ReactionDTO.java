package com.haterspoint.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ReactionDTO {
    private int productId;
    private int userId;
    private String reaction;
}
