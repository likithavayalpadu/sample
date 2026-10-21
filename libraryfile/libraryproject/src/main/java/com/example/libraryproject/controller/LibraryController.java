package com.example.libraryproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryproject.entity.Library;
import com.example.libraryproject.service.LibraryService;

@RequestMapping("/Library")
@RestController 
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    @PostMapping
public List<Library> saveLibraries(@RequestBody List<Library> libraries) {
    return libraryService.saveLibraries(libraries);
}


    
   @GetMapping 
    public List<Library> getAllLibraries(){
        return libraryService.getAllLibraries();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibrary(@PathVariable Long id ){
    libraryService.deleteLibrary(id);
    return ResponseEntity.ok("Library deleted successfully");
}
}
