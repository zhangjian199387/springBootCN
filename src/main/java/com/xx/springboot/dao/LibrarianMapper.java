package com.xx.springboot.dao;

import com.xx.springboot.entity.Librarian;


import com.xx.springboot.entity.Librarian;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


public interface LibrarianMapper {
    Librarian selectLibrarian();
}
