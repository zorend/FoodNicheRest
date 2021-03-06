package com.foodniche.db.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * @author Alexey Dubrov
 *
 *  Entity for any uploaded file.
 */

@Entity
@Table(name = "uploadedfiles")
@XmlRootElement
public class UploadedFiles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileid")
    private Integer fileId;

    @XmlTransient
    @Column(name = "serverfilename")
    private String serverFileName;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "contenttype")
    private String contentType;

    @Column(name = "filesize")
    private Long fileSize;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "filetype")
    private FileType fileType;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getServerFileName() {
        return serverFileName;
    }

    public void setServerFileName(String serverFileName) {
        this.serverFileName = serverFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadedFiles that = (UploadedFiles) o;

        if (!fileId.equals(that.fileId)) return false;
        if (!serverFileName.equals(that.serverFileName)) return false;
        if (!fileName.equals(that.fileName)) return false;
        if (!contentType.equals(that.contentType)) return false;
        if (!fileSize.equals(that.fileSize)) return false;
        return fileType == that.fileType;

    }

    @Override
    public int hashCode() {
        int result = fileId.hashCode();
        result = 31 * result + serverFileName.hashCode();
        result = 31 * result + fileName.hashCode();
        result = 31 * result + contentType.hashCode();
        result = 31 * result + fileSize.hashCode();
        result = 31 * result + fileType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UploadedFiles{" +
                "fileId=" + fileId +
                ", serverFileName='" + serverFileName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", fileSize=" + fileSize +
                ", fileType=" + fileType +
                '}';
    }
}
