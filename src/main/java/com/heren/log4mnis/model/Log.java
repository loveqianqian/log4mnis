package com.heren.log4mnis.model;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description: log pojo</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/16
 */
public class Log {

    private long logId;
    private String type;
    private long timestamp;
    private byte[] content;
    private String contentType;
    private String original;
    private String code;
    private String keyWords;

    @Override
    public String toString() {
        return "logId:" + logId + "\ntype:" + type + "\ntimestamp:" + timestamp + "\ncontent:" + new String
                (content) +"\ncontentType:" + contentType + "\noriginal:" + original + "\ncode:" + code +
                "\nkeyWords:" + keyWords;
    }

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
