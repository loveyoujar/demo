package com.ltq.demo.util.email;

/**
 * 邮件传输类
 * @author LTQ
 */
public class EmailEntity {

    /**
     * 接收方电子邮件名称
     */
	private String receiver;
    /**
     *  邮件主题
     */
    private String subject;
    private String text;
    /**
     * 邮件内容
     */
    private String content;
 
    public String getReceiver() {
        return receiver;
    }
 
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
 
    public String getSubject() {
        return subject;
    }
 
    public void setSubject(String subject) {
        this.subject = subject;
    }
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
 
    public String getContent() {
        return content;
    }
 
    public void setContent(String content) {
        this.content = content;
    }

    public EmailEntity(String receiver, String subject, String text, String content) {
        this.receiver = receiver;
        this.subject = subject;
        this.text = text;
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}