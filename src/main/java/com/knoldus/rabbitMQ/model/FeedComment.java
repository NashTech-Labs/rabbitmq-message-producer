package com.knoldus.rabbitMQ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class FeedComment {


    int feedCommentId;


    String email;

    String comment;

    @JsonIgnore

    private FeedData feedData;
}
