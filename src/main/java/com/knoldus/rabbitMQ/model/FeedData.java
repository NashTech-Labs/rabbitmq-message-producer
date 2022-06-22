package com.knoldus.rabbitMQ.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class FeedData {


    private int feedId;


    private int contributionId;


    private String email;


    private String contributionType;


    private String title;


    private String description;


    private Date feedTime;


    private String url;

    private List<FeedLike> feedLike = new ArrayList<>();

    private List<FeedComment> feedComments = new ArrayList<>();

}
