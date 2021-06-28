package com.example.b01_update_img_of_day.model.service;


import com.example.b01_update_img_of_day.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICommentService extends IGeneralService<Comment>{
    Page<Comment> findAllByAuthorContaining(String author, Pageable pageable);
    Page<Comment> findAllByOrderByStartDesc(Pageable pageable);

    void like(@Param("id") Long id);
}