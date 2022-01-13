package com.company.utils;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.security.Key;
import java.util.Arrays;

public class MarkupUtil {
    public static KeyboardButton button(String text){
        KeyboardButton button = new KeyboardButton();
        button.setText(text);
        return button;
    }

    public static KeyboardRow row(KeyboardButton... buttons){
        KeyboardRow row = new KeyboardRow();
        for (KeyboardButton b : buttons){
            row.add(b);
        }
        return row;
    }

    public static ReplyKeyboardMarkup markup(KeyboardRow... rows){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setKeyboard(Arrays.asList(rows));
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        return markup;
    }

    public static ReplyKeyboardMarkup mainMarkup(){
        KeyboardButton b1 = button("➕ Xarajat qo'shish");
        KeyboardButton b2 = button("📜 Xarajatlar ro'yxati");
        KeyboardButton b3 = button("📝 O'rtacha yer uchun xarajat");

        KeyboardRow r1 = row(b1);
        KeyboardRow r2 = row(b2);
        KeyboardRow r3 = row(b3);

        ReplyKeyboardMarkup markup = markup(r1, r2, r3);
        return markup;
    }

    public static ReplyKeyboardMarkup plusMarkup(){
        KeyboardButton b1 = button("👝 Mineral o'g'it");
        KeyboardButton b2 = button("🚜 Yer xaydash");
        KeyboardButton b3 = button("⛽ Sarflangan yoqilg'i");
        KeyboardButton b4 = button("👷‍♂️ Ishchilarga");
        KeyboardButton b5 = button("🌱 Urug' uchun");
        KeyboardButton b6 = button("🐛 Gerbitsid");
        KeyboardButton b7 = button("🦼 Texnika uchun");
        KeyboardButton b8 = button("➕ Boshqa xarajat");
        KeyboardButton b9 = button("🔙 Orqaga");

        KeyboardRow r1 = row(b1, b2);
        KeyboardRow r2 = row(b3, b4);
        KeyboardRow r3 = row(b5, b6);
        KeyboardRow r4 = row(b7, b8);
        KeyboardRow r5 = row(b9);

        ReplyKeyboardMarkup markup = markup(r1, r2, r3, r4, r5);
        markup.setInputFieldPlaceholder("Xarajat turini tanlang.");
        return markup;
    }
}
