package org.privatechat.chat.DTOs;

public class ChatChannelInitializationDTO {
  private long userIdOne;

  private long userIdTwo;

  public ChatChannelInitializationDTO() {}

  public void setUserIdOne(long userIdOne) {
    this.userIdOne = userIdOne;
  }

  public void setUserIdTwo(long userIdTwo) {
    this.userIdTwo = userIdTwo;
  }

  public long getUserIdOne() {
    return this.userIdOne;
  }

  public long getUserIdTwo() {
    return userIdTwo;
  }
}
