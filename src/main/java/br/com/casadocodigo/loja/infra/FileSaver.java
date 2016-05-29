/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author bruno
 */
@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String saveFile(String baseFolder, MultipartFile file) {
		try {
			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			return baseFolder + "/" + file.getOriginalFilename();
		} catch (IOException | IllegalStateException ex) {
			Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException(ex);
		}
	}

}
