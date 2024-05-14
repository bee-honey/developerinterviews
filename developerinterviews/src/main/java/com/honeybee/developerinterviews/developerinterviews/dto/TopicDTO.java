package com.honeybee.developerinterviews.developerinterviews.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicDTO {
    private String topic_name;
    private Long category_id; // ID of the category under which the topic will be saved
}
