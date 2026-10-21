package com.example.libraryproject.service;

import com.example.libraryproject.repository.StudentRepo;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.libraryproject.entity.Library;
import com.example.libraryproject.repository.LibraryRep;

@Service
public class LibraryService {

    private final StudentRepo studentRepo;
    private final LibraryRep libraryRep;

    public LibraryService(LibraryRep libraryRep, StudentRepo studentRepo) {
        this.libraryRep = libraryRep;
        this.studentRepo = studentRepo;
    }

    // Save all library information
    public List<Library> saveLibraries(List<Library> libraries) {
        return libraryRep.saveAll(libraries);
    }

    // Get all library information
    public List<Library> getAllLibraries() {
        return libraryRep.findAll();
    }
    //Delete a library id
    public String deleteLibrary(Long id){
        if(!libraryRep.existsById(id)){
     throw new RuntimeException("Library id not found:" + id);
        }
     libraryRep.deleteById(id);
     return "Library id delated sucessfully";
        }
    }
