package com.crm.clinicCrm.files.service;

import com.crm.clinicCrm.files.FileModel;
import com.crm.clinicCrm.files.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
    private final Path root = Paths.get("uploads");

    @Autowired
    FileRepository fileRepository;

    @Override
    public void init() {
        try {
            if (!Files.exists(root))
            { Files.createDirectory(root); }

        }   catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        }   catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error:" + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }   else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
          throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public void delete(String filename) {
        try {
                FileSystemUtils.deleteRecursively(root.resolve(filename));
        }   catch (IOException e) {
                e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        }   catch (IOException e ) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public void saveInDB(FileModel fileModel) {
        fileRepository.save(fileModel);
    }

    @Override
    public UUID fetchClientId(String filename) {

        return fileRepository.findByFileName(filename).getClientId();
    }

    @Override
    public List<FileModel> findAllFilesByClientId(UUID clientId) {
        return fileRepository.findAllFilesByClientId(clientId);
    }

    @Override
    public void deleteByFilename(String filename) {
        fileRepository.deleteByFilename(filename);
        delete(filename);
    }
}
