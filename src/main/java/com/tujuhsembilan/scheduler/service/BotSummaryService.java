package com.tujuhsembilan.scheduler.service;


import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.tujuhsembilan.scheduler.model.Summary;
import com.tujuhsembilan.scheduler.model.dto.SummaryDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BotSummaryService extends TelegramLongPollingBot {
    
    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.chatId}")
    private String chatId;

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    public String getChatId() {
        return this.chatId;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            var message = update.getMessage();
            var chatId = message.getChatId();
            try {
                var reply = "hi";
                sendNotification(String.valueOf(chatId), reply);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startScheduledReporting(SummaryDto summaryDto) {
        try {
            String reply = summaryDto.toString();
            sendNotification(this.chatId, reply);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendNotification(String chatId, String message) throws TelegramApiException {
        var response = new SendMessage(chatId, message);
        execute(response);
    }

}
