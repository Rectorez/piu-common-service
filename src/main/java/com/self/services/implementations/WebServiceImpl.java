/* (C)2026 */
package com.self.services.implementations;

import com.self.dtos.GetImageURLsRequestDTO;
import com.self.entities.Song;
import com.self.services.bases.WebService;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebServiceImpl implements WebService {
    public List<String> loadImages(GetImageURLsRequestDTO request) {
        if (request.getUrl() != null && !request.getUrl().isBlank())
            return loadImagesFromURL(request.getUrl());
        else if (request.getRawContent() != null && !request.getRawContent().isBlank())
            return loadImagesFromRawContent(request.getRawContent());
        return List.of();
    }

    public List<Song> loadSongInfo(GetImageURLsRequestDTO request) {
        return List.of();
    }

    private List<String> loadImagesFromURL(String url) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Response Body: {}", response.body());

            return loadImagesFromRawContent(response.body());
        } catch (Exception exception) {
            log.error("loadImagesURLs Error: {}", exception.toString());
        }
        return List.of();
    }

    private List<String> loadImagesFromRawContent(String content) {
        List<String> htmlSegments = Arrays.stream(content.split("([\"'])")).toList();
        List<String> imageSegments =
                htmlSegments.stream()
                        .filter(segment -> segment.matches(".*\\.(png|jpg).*"))
                        .toList();
//        log.info("HTML Segments: {}", htmlSegments);
        log.info("Image Segments: {}", imageSegments);

        return imageSegments.stream().distinct().toList();
    }

    // Used for the official UCS site, to assign song details
    private List<Song> loadSongContentFromRawContent(String content) {
        List<Song> songList = new ArrayList<>();

        List<String> songHtmlSegmentList = Arrays.stream(content.split("(<tr>|</tr>)")).toList();
        log.info("Song Info HTML Segments: {}", songHtmlSegmentList);
        return List.of();
    }
}
