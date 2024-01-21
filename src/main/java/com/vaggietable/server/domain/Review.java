package com.vaggietable.server.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    private Long reviewId;
    private Long rId;
    private String content;
    private float score;
}
