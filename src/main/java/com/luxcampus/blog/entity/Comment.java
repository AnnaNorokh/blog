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

    @Column
    //@ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Integer postId;

}
