package org.privatechat.user.DTOs;

public class NotificationDTO {
  private String type;

  private String contents;

  private long fromUserId;

  public NotificationDTO() {}

  public NotificationDTO(String type, String contents, long fromUserId) {
    this.type = type;
    this.contents = contents;
    this.fromUserId = fromUserId;
  }

  public String getType() {
    return this.type;
  }

  public String getContent() {
    return this.contents;
  }

  public long getfromUserId() {
    return this.fromUserId;
  }
}