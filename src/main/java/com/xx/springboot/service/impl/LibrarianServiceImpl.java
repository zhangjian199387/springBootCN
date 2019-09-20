package com.xx.springboot.service.impl;

import com.xx.springboot.dao.LibrarianMapper;
import com.xx.springboot.entity.Librarian;
import com.xx.springboot.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LibrarianServiceImpl implements LibrarianService {
        @Autowired
        private LibrarianMapper librarianMapper;
        @Override
        public Librarian selectLibrarian() {
            // TODO Auto-generated method stub
            return librarianMapper.selectLibrarian();
        }

}
