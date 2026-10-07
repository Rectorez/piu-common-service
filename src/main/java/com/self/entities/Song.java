/* (C)2026 */
package com.self.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SONG")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "SONG_NAME")
    private String songName;

    @Column(name = "ARTIST_ID")
    private String artistId;

    @Column(name = "SONG_TYPE_ID")
    private String songTypeId;

    @Column(name = "GENRE_ID")
    private String genreId;

    @Column(name = "MIN_BPM")
    private String minBpm;

    @Column(name = "MAX_BPM")
    private String maxBpm;

    @Column(name = "VERSION_ID")
    private String versionId;

    @Column(name = "IMAGE_URL")
    private String imageUrl;
}
