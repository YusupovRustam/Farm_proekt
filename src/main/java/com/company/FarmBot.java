package com.company;

import com.company.utils.CheckingUtil;
import com.company.utils.MarkupUtil;
import com.company.utils.MessageUtil;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class FarmBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Useful_Calculation_bot";
    }

    @Override
    public String getBotToken() {
        return "5076236211:AAE4RTlpHsM_2lTMn0fRQs49iboRJU8qEzw";
    }

    Manager manager = new Manager();

    String old;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String text = message.getText();
            SendMessage sendMessage = new SendMessage();


            switch (text) {
                case "/start":
                    String answer = "Assalomu aleykum <b>" + message.getFrom().getUserName() + "</b>, " +
                            "botga xush kelibsiz. Bu bot fermerlarga mo'ljallangan bo'lib, xarajat ishlarini " +
                            "hisoblashda 📝 yordam beradi.";
                    sendMessage = getSendMessage(message, answer, MarkupUtil.mainMarkup());
                    break;

                case "➕ Xarajat qo'shish":
                    sendMessage = getSendMessage(message, "✔ Xarajat turini tanlang.", MarkupUtil.plusMarkup());
                    break;

                case "🔙 Orqaga":
                    sendMessage = getSendMessage(message, "<b><i>Asosiy Menu</i></b>", MarkupUtil.mainMarkup());
                    break;
                case "➕ Boshqa xarajat":
                    sendMessage = MessageUtil.sendMessage(message, "✏ Xarajat nomini kiriting.");
                    old = "✏ Xarajat nomini kiriting.";
                    break;

                default:
                    switch (old){
                        case "✏ Xarajat nomini kiriting.":
                            Info info=manager.createInfo(text);
                            sendMessage = MessageUtil.sendMessage(message, "Miqdorini kiriting");
                            old="Miqdorini kiriting";
                            break;
                        case"Miqdorini kiriting":
                            manager.getCurrent().setQuantity(Double.parseDouble(text));
                            old="Summani kiriting";
                            sendMessage = MessageUtil.sendMessage(message, old);
                            break;
                        case "Summani kiriting":
                            manager.getCurrent().setAmount(Double.parseDouble(text));
                            old="Xarajat kiritildi";
                            sendMessage = MessageUtil.sendMessage(message, old);
                            System.out.println(manager.getCurrent().toString());
                            break;
                    }
                  break;}

            send(sendMessage);
            return;

        }
    }

    public void send(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static SendMessage getSendMessage(Message message, String text, ReplyKeyboardMarkup markup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(markup);
        sendMessage.setParseMode("HTML");
        return sendMessage;
    }
}
