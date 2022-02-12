package com.luxcampus.blog.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;

    @Column
    private String text;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Date creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Post post;


}
