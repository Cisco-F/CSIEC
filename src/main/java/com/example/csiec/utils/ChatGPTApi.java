package com.example.csiec.utils;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.util.Proxys;

import java.net.Proxy;

public class ChatGPTApi {
    public static String oneChat(String message){
        Proxy proxy = Proxys.http("127.0.0.1", 7890);
        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey("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")
                .proxy(proxy)
                .apiHost("https://api.openai.com/")
                .build()
                .init();

        return chatGPT.chat(message);
    }
}
