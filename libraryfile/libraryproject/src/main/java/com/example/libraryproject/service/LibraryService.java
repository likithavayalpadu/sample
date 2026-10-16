package com.example.libraryproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.libraryproject.entity.Library;
import com.example.libraryproject.repository.LibraryRep;

@Service
public class LibraryService {

    private final LibraryRep libraryRep;

    public LibraryService(LibraryRep libraryRep) {
        this.libraryRep = libraryRep;
    }

    // Save all library information
    public List<Library> saveLibraries(List<Library> libraries) {
        return libraryRep.saveAll(libraries);
    }

    // Get all library information
    public List<Library> getAllLibraries() {
        return libraryRep.findAll();
    }
}