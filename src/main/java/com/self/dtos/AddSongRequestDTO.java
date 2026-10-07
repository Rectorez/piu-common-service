/* (C)2026 */
package com.self.dtos;

import lombok.Data;

@Data
public class AddSongRequestDTO {
    private String songName;
    private String artistId;
    private String songTypeId;
    private String genreId;
    private String minBpm;
    private String maxBpm;
    private String versionId;
}
