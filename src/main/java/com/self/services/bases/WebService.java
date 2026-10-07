/* (C)2026 */
package com.self.services.bases;

import com.self.dtos.GetImageURLsRequestDTO;
import java.util.List;

import com.self.entities.Song;
import org.springframework.stereotype.Service;

@Service
public interface WebService {
    List<String> loadImages(GetImageURLsRequestDTO request);
    List<Song> loadSongInfo(GetImageURLsRequestDTO requestDTO);
}
