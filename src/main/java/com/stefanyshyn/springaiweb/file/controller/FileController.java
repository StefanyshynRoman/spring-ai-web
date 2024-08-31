package com.stefanyshyn.springaiweb.file.controller;

import com.stefanyshyn.springaiweb.file.FileFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ai/file")
@RequiredArgsConstructor
public class FileController {
    private final FileFacade fileFacade;
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/load")
    void loadFileToVectorStore(){
        fileFacade.loadFileToVectorStore();
    }
}
