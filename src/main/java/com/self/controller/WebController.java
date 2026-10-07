/* (C)2026 */
package com.self.controller;

import com.self.dtos.GetImageURLsRequestDTO;
import com.self.entities.Song;
import com.self.services.bases.WebService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/web")
public class WebController {
    @Autowired WebService webService;

    @PostMapping(path = "/getImageURLs")
    public ResponseEntity<List<String>> getImageURLs(@RequestBody GetImageURLsRequestDTO request) {
        return ResponseEntity.of(Optional.of(webService.loadImages(request)));
    }

    @PostMapping(path = "/getImagesFromHTML")
    public ResponseEntity<List<String>> getImagesFromHTML(@RequestBody String htmlContent) {
        return ResponseEntity.of(
                Optional.of(
                        webService.loadImages(
                                GetImageURLsRequestDTO.builder().rawContent(htmlContent).build())));
    }

    @PostMapping(path = "/getSongInfoFromHTML")
    public ResponseEntity<List<Song>> getSongInfoFromHTML(@RequestBody String htmlContent) {
        return ResponseEntity.of(
                Optional.of(
                        webService.loadSongInfo(
                                GetImageURLsRequestDTO.builder().rawContent(htmlContent).build())));
    }
}
