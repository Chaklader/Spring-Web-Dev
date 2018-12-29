package org.privatechat.chat.DTOs;

public class EstablishedChatChannelDTO {
  private String channelUuid;
  
  private String userOneFullName;
  
  private String userTwoFullName;

  public EstablishedChatChannelDTO() {}
  
  public EstablishedChatChannelDTO(String channelUuid, String userOneFullName, String userTwoFullName) {
    this.channelUuid = channelUuid;
    this.userOneFullName = userOneFullName;
    this.userTwoFullName = userTwoFullName;
  }
  
  public void setChannelUuid(String channelUuid) {
    this.channelUuid = channelUuid;
  }
  
  public String getChannelUuid() {
    return this.channelUuid;
  }
  
  public void setUserOneFullName(String userOneFullName) {
    this.userOneFullName = userOneFullName;
  }
  
  public String getUserOneFullName() {
    return this.userOneFullName;
  }

  public void setUserTwoFullName(String userTwoFullName) {
    this.userTwoFullName = userTwoFullName;
  }
  
  public String getUserTwoFullName() {
    return this.userTwoFullName;
  }
}