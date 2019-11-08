/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pakoc.service;

import java.util.List;

import pl.pakoc.dto.AlbumDto;

public interface AlbumsService {
	
    List<AlbumDto> getAlbums(String userId);
}
