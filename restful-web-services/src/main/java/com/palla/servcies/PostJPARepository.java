package com.palla.servcies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palla.data.Post;
import com.palla.data.User;

@Repository
public interface PostJPARepository extends JpaRepository<Post, Integer>{

}
