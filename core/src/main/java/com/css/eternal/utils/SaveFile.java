package com.css.eternal.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SaveFile {

    public String fileTitle;
    public String levelTitle;
    public Date lastModified;

    public SaveFile(String levelTitle, Date lastModified, String fileTitle) {
        this.fileTitle = fileTitle;
        this.levelTitle = levelTitle;
        this.lastModified = lastModified;
    }

    public String getLastModifiedFormatted() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm | MM/dd/yyyy");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }

}
