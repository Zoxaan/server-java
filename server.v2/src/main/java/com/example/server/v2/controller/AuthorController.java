package com.example.server.v2.controller;

import com.example.server.v2.entity.AuthorEntity;
import com.example.server.v2.entity.BookEntity;
import com.example.server.v2.response.AuthorListResponse;
import com.example.server.v2.response.BaseResponse;
import com.example.server.v2.response.BookListResponse;
import com.example.server.v2.servise.AuthorServise;
import com.example.server.v2.servise.BookServise;
import com.example.server.v2.utils.BookValidationUtuls;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorServise servise;
    public AuthorController(AuthorServise servise) {this.servise = servise;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody AuthorEntity data){
        try {


            servise.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"автор добавлен"));
        } catch (Exception e){
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){return ResponseEntity.ok(new AuthorListResponse(servise.getAll())); }





}
