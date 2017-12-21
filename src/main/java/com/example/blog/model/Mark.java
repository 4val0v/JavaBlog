package com.example.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name="postMark", joinColumns = @JoinColumn(name="idMark"), inverseJoinColumns = @JoinColumn(name="idPost"))
    private Set<Post> posts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
