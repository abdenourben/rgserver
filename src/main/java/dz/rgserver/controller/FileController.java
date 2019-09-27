package dz.rgserver.controller;



import dz.rgserver.fileResponse.FileResponse;
import dz.rgserver.model.DBFile;
import dz.rgserver.service.DBFileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class FileController {
	@Autowired
    private DBFileStorageService DBFileStorageService;
 
 
    @PostMapping("/uploadFile")
    public FileResponse uploadDBFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = DBFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getFileName())
                .toUriString();

        return new FileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
   

  
    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadDBFile(@PathVariable Long fileId) {
        // Load file from database
        DBFile dbFile = DBFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
    
    @GetMapping("/getFile/{fileId}")
    public ResponseEntity<Resource> getFile(@PathVariable Long fileId) {
    	 DBFile dbFile = DBFileStorageService.getFile(fileId);
	     return ResponseEntity.ok()
	    		  .contentType(MediaType.parseMediaType(dbFile.getFileType()))
	                
                  .body(new ByteArrayResource(dbFile.getData()));
	}
}
