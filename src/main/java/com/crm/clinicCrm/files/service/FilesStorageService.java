package com.crm.clinicCrm.files.service;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.crm.clinicCrm.files.FileModel;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

    void init();

    void save(MultipartFile file);

    Resource load(String filename);

    void deleteAll();

    Stream<Path> loadAll();

    void saveInDB(FileModel fileModel);

    UUID fetchClientId(String filename);

    List<FileModel> findAllFilesByClientId(UUID clientId);

    void deleteByFilename(String filename);

    void delete(String filename);
}
