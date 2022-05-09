package com.crm.clinicCrm.files;

import com.crm.clinicCrm.files.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files")
public class FilesController {
    @Autowired
    FilesStorageService storageService;

    @PostMapping("/upload/{clientId}")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable UUID clientId) {
        String message = "";
            storageService.save(file);
            storageService.saveInDB(new FileModel(file.getOriginalFilename(), clientId ));
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//        }  {
//            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//        }
    }

    @GetMapping("/all-files/{clientId}")
    public ResponseEntity<List<FileInfoModel>> getAllFilesByClientId(@PathVariable  UUID clientId) {
        List<String> selectedFiles = storageService.findAllFilesByClientId(clientId).stream().map(FileModel::getName).collect(Collectors.toList());
        List<FileInfoModel> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfoModel(filename, url, clientId);
        }).filter(fileInfoModel -> selectedFiles.contains(fileInfoModel.getName())).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/all-files")
    public ResponseEntity<List<FileInfoModel>> getListFiles() {
        List<FileInfoModel> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            UUID clientId = storageService.fetchClientId(filename);
            return new FileInfoModel(filename, url, clientId);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @DeleteMapping("/delete/{filename}")
    public ResponseEntity<ResponseMessage> deleteByFileName(@PathVariable String filename) {
        String message = "";
        storageService.deleteByFilename(filename);
        message = "Deleted the file successfully: " + filename;
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
