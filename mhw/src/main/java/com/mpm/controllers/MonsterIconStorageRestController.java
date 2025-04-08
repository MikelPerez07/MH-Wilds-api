package com.mpm.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.apache.tika.mime.MimeTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mpm.storage.IMonsterIconStorageService;

@RestController
@RequestMapping("/media")
@CrossOrigin(origins = ("http://localhost:4201"))
public class MonsterIconStorageRestController {

	@Autowired
	private IMonsterIconStorageService monsterIconStorageService;

	@PostMapping("/monster-icon/{id}")
	public ResponseEntity<?> uploadImagen(@RequestParam("image") MultipartFile multipartFile, @PathVariable Long id) {
		// La anotación "imagen" hecha en @RequestParam es super importante porque es la
		// referencia que
		// debemos emplear en cliente

		Map<String, String> response = new HashMap<>();
		String url = null;

		try {

			String imageName = monsterIconStorageService.store(multipartFile, id);
			// EN ESTE PUNTO EL ARCHIVO FÍSICO YA ESTÁ SUBIDO Y LA ANOTACIÓN EFECTUADA EN LA
			// BBDD

			// A PARTIR DE ESTE PUNTO LO QUE VAMOS A HACER ES CONSEGUIR LA URL COMPLETA DE
			// LA IMAGEN
			// SUBIDA PARA DEVOLVERLA EN EL RESPONSE (response)
			// Vamos a conseguir la URL completa del archivo...

			url = monsterIconStorageService.getUrlCompletaImagen(imageName);

		} catch (RuntimeException e) {

			response.put("message", "Runtime error " + e.getMessage()); // Este es el mensaje de error
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);// Usamos 400 para indicar
																								// un error surgido en
																								// la capa de cliente

		} catch (MimeTypeException e) { // Excepcion de tipo checked. Nunca ponerla detrás del IOException

			response.put("message", "Error obtaining MIME type of the file");
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_ACCEPTABLE);// Usamos 406 para
																								// indicar que el
																								// archivo subido tiene
																								// algún problema con su
																								// tipo MIME. archivo
																								// corrupto???

		} catch (IOException e) {

			response.put("mensaje", "Error uploading the file to the server");
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);// Usamos 500
																										// para indicar
																										// un error en
																										// el proceso de
																										// escritura o
																										// creación del
																										// archivo
																										// físico

		}

		response.put("url", url);
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);// Utilizamos un 200 para indicar que
																				// todo ha ido genial

	}

	// Este método nos devuelve la imagen física
	@GetMapping("/monster-icon/{imageName:.+}")
	public ResponseEntity<?> getImagen(@PathVariable String imageName) {

		Map<String, String> response = new HashMap<>();
		Resource imagen = null;
		String contentType = null;

		try {

			imagen = monsterIconStorageService.loadAsResource(imageName);
			// Extraemos el content type (Tipo de contenido-Tipo MIME) para pasarlo en el
			// header de la response
			contentType = Files.probeContentType(imagen.getFile().toPath());
		} catch (Exception e) {

			response.put("message", "Error loading the file");
			return new ResponseEntity<Map<String, String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(imagen);

	}

}
