package com.bisnode.chatroom;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Message {
    @Id
    private String id;
    private String text;
}
