package com.example.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class Matebot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Jony_by_Krasota_bot";
    }

    @Override
    public String getBotToken() {
        return "6238803444:AAEECUDH4fzIMJvjaBvlldJeKZ2nOYwVgaQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String rules = "";
        Message message = update.getMessage();
        System.out.println("Message received " + message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("На жаль такого часу не існує\uD83D\uDE22");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        String userName = message.getChat().getUserName();

        if(message.getText().equals("/start")){
            String text = "Вітаю, "+ userName + " в середовищі \uD83D\uDC4B\nяке допоможе вам з вивченням Англійської!\nВиберіть, будь ласка, потрібний вам час⌛️\n";
            text = text + "";
            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup keyboardMarkup = getMenuKeyboard();
            sendMessage.setReplyMarkup(keyboardMarkup);
            sendMessage.setText(text);

        }
        if(message.getText().equals("Past Simple")){
            rules = rules + "Past Simple описує одноразову закінчену дію, яка відбулася у минулому.\n";
            rules = rules + "I, he, she, it - was (я був, він був, вона була, це було)\nI, he, she, it - wasn’t (я не був, він не був, вона не була)\n";
            rules = rules + "Was I, he, she, it ..?\nWere+ you, we, they …?\nyou, we, they were (ти був (ви були), ми були, вони були)\nyou, we, they - weren’t(ти не був (ви не були), ми не були)\n";
            rules = rules + "Для правильних дієслів (regular verbs) діють чіткі правила:\nI, you, we, they, he, she, it + verb + ED(закінчення ED)\nI, you, we, they, he, she, it + DIDN'T + verb(без закінчення ED)\n";
           sendMessage.setText(rules);
        }
        if(message.getText().equals("Present Simple")){
            rules = rules + "Використовуємо Present Simple, щоб описати дію, яка відбувається:\nщодня (every day) щотижня (every week). щомісяця (every month) - наша рутина\n" +
                    "за розкладом (schedule) - наприклад, розклад руху автобусів (buses), потягів (trains) і т.д.\n" +
                    "відповідно до законів природи (nature), а отже - це завжди правда (наприклад, схід і захід сонця - sunrise and sunset)\n";
            rules = rules + "1. I, you, we, they + дія (дієслово - verb):I always eat a lot\nI, you, we, they + don’t + дія (дієслово - verb): I don’t eat a lot\n Do + I, you, we, they + дія ..?\n";
            rules = rules + "2. He, she, it + дія із закінченням S (verb + s): He always eats a lot\nHe, she, it + doesn’t + дія без закінчення S : He doesn’t eat a lot\nDoes + he, she, it + дія (без закінчення S) …?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Future Simple")){
            rules = rules + "Future Simple описує дію, яка відбудеться у майбутньому, особливо коли говоримо про наші передбачення та спонтанні рішення.\n";
            rules = rules + "I, he, she, it, you, we, they + will + дієслово\n" + "I, he, she, it, you, we, they + won’t (will not) + дієслово\n";
            rules = rules + "Will + I, he, she, it, you, we, they + дієслово\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Past Continuous")){
            rules = rules + "Past Continuous (минулий тривалий час) використовується, як і визначає його назва, для описання дій, які продовжувалася якийсь час у минулому, наприклад:\n"+
            "+ I did my homework - Я виконав домашнє завдання - Past Simple\n" + "+ I was doing my homework - Я виконував домашнє завдання - Past Continuous\n" + "Цей час підкреслює, що дія відбувалася протягом якогось часу у минулому і завершилася у минулому.\n";
            rules = rules + "Будується Past Continuous за допомогою допоміжного was або were + основного дієслова із закінченням -ing:\n" + "+ I, he, she, it + was + look +ing\n"+ "+ You, we, they + were + look + ing\n";
            rules = rules + "У запереченні після was або were просто додаємо частку not:\n" + "- I, he, she, it + wasn’t + look +ing\n" + "- You, we, they + weren’t + look + ing\n";
            rules = rules + "У питаннях was або were виносимо на перше місце або ставимо їх одразу після питальних слів (why, who, where, what, when):\n" + "? Was he reading an article yesterday?\n" +
            "? Were you looking for a job yesterday?\n" +"? Why were you looking for a new job?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Present Continuous")){
            rules = rules + "Використовуємо Present Continuous, щоб описати дію, яка відбувається саме зараз, або будь-яку тимчасову дію (що відбувається лише цими днями, на цьому тижні, в цьому місяці і т.д.)\n";
            rules = rules + "Time indicators:\nnow\n" +
                    "· these days\n" +
                    "· this week\n" +
                    "· this month\n" +
                    "· this year\n";
            rules = rules + "+ I’m + дієслово +ing\n" +
                    "- I’m not + дієслово +ing\n" +
                    "? Am I + дієслово +ing …?\n";
            rules = rules + "+ You, we, they + are + дієслово +ing\n" +
                    "- You, we, they + aren’t + дієслово +ing\n" +
                    "? Are + you, we, they + дієслово +ing …?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Future Continuous")){
            rules = rules + "Future Continuous  утворюється за допомогою допоміжного дієслова will (рідше shall для I та We) та форми тривалого інфінітиву (be + дієслово з закінченням -ing).\n"+
            "+ I shall be working here. – Я буду тут працювати.\n" + "+ He will be drinking tea with us. – Він буде пити з нами чай.\n" +"+ He will be drinking tea with us. – Він буде пити з нами чай.\n";
            rules = rules + "Заперечення в Future Continuous утворюється за допомогою додавання частки not після дієслова will або shall.\n" + "- I will not be working here. – Я не буду працювати тут.\n"
            + "- He will not be drinking tea with us. – Він не буде пити з нами чай.\n" +"- We shan’t be dancing all night. – Ми не будемо танцювати всю ніч.\n";
            rules = rules + "Загальне питання в Future Continuous утворюється за допомогою винесення допоміжного дієслова will (або shall) на початок речення перед підметом.\n"+
            "? Will I be working here? – Я буду тут працювати?\n" + "? Whom will he be drinking tea with? – З ким він буде пити чай?\n" +"? How long will we be dancing? – Як довго ми будемо танцювати?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Past Perfect")){
            rules = rules + "В Past Perfect стверджувальне речення формується за допомогою допоміжного дієслова had та форми Past Participle (третя форма дієслова). Had – це форма минулого часу допоміжного дієслова have.\n"+
            "Форми Past Perfect, на відміну від Past Simple, завжди утворюються допоміжним дієсловом had та формою Past Participle (третя форма дієслова(-ed)) від смислового дієслова.\n"+
            "+ I had booked the table. – Я замовила (забронювала) столик.\n" + "+ She had washed her hair. – Вона вимила волосся.\n" + "+ They had seen the sunset. – Вони побачили захід сонця.\n";
            rules = rules + "Для того, щоб утворити заперечення Past Perfect, слід додати заперечну частку not після допоміжного дієслова had.\n"+
            "- I had not booked a table. – Я не забронювала столик.\n" + "- She had not washed her hair. – Вона не вимила волосся.\n";
            rules = rules + "Загальне питання в Past Perfect формується шляхом винесення допоміжного дієслова had на початок речення перед підметом.\n" + "? Had you booked a table? – Ти забронювала столик?\n" +
            "? Where had she washed this cup? – Де вона мила цю чашку?\n" + "? Who had seen the sunset? – Хто побачив захід сонця?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Present Perfect")){
            rules = rules + "Граматичний час Present Perfect утворюється за допомогою допоміжного дієслова have або has та форми Past Participle (третьої форми смислового дієслова(-ed)).\n"+
            "В залежності від особи та числа, в якому стоїть підмет у реченні, використовується та чи інша форма допоміжного дієслова have.\n" + "+ I have dug a hole for planting trees. – Я вирив яму для посадки дерев.\n" +
            "+ He has just finished his first book. – Він тільки-но закінчив свою першу книгу.\n" + "+ We have bought all the furniture. – Ми придбали всі меблі.\n";
            rules = rules + "В заперечних реченнях в Present Perfect після допоміжного дієслова have або has додається заперечна частка not.\n" +
            "- He has not finished his first book. – Він не закінчив свою першу книгу.\n" + "- We haven’t bought all the furniture. – Ми не придбали всі меблі.\n";
            rules = rules + "Загальне питання в Present Perfect утворюється шляхом винесення допоміжного дієслова have або has на початок речення перед підметом.\n"+ "? Have I dug a hole? – Я (вже) вирив яму?\n"+
            "? Where have we bought all the furniture? – Де ми придбали всі меблі?\n" + "? How deep have you dug a hole? – Наскільки глибоку яму ти вирив?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Future Perfect")){
            rules = rules + "Future Perfect утворюється за допомогою допоміжного дієслова will (або рідше shall) та форми доконаного інфінітиву Perfect Infinitive (have + смислове дієслово в третій формі(-ed)) без частки to.\n"+
            "+ I shall have done this work by 5 o’clock tomorrow. – Я виконаю цю роботу до 5-ї години завтра.\n" + "+ She will have bought these flowers before the beginning of the party. – Вона придбає ці квіти до початку вечірки.\n"+
            "+ They will have found the new actor by next week. – Вони знайдуть нового актора до наступного тижня.\u200B\n";
            rules = rules + "Заперечення в Future Perfect утворюється шляхом додавання частки not після допоміжного дієслова will або shall.\n" + "- I will not have done this work by 5 o’clock tomorrow. – Я не виконаю цю роботу до 5-ї години завтра.\n" +
            "- They will not have found the new actor by next week. – Вони не знайдуть нового актора до наступного тижня.\n" + "- She won’t have bought these flowers before the beginning of the party. – Вона не придбає ці квіти до початку вечірки.\n";
            rules = rules + "Утворення загального питання в Future Perfect відбувається шляхом винесення допоміжного дієслова will або shall на початок речення перед підметом.\n" + "? Will I have done this work by 5 o’clock tomorrow? – Я виконаю цю роботу до 5-ї години завтра?\n"+
            "? When will she have bought these flowers? – Коли вона придбає ці квіти? (до якого часу?)\n" + "? Where will they have found a new actor by next week? – Де вони знайдуть нового актора до наступного тижня?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Past Perfect Continuous")){
            rules = rules + "Стверджувальне речення в Past Perfect Continuous (Past Perfect Progressive) утворюється за допомогою комплексного допоміжного дієслова had been (форма Past Perfect від допоміжного дієслова be), що використовується для всіх осіб однини та множини, та форми Present Participle (першої форми смислового дієслова з закінченням -ing).\n"+
            "+ We had been searching for a room for two hours before we found a free one. – Ми шукали кімнату дві години, поки не знайшли вільну.\n"+ "+ I had been waiting for them all morning, so I felt annoyed. – Я чекала їх весь ранок, тому я була роздратована.\n" +
            "+ She’d been driving a car for an hour before she came to the gas station. – Вона керувала машиною з цілу годину, поки не приїхала на автозаправну станцію\n";
            rules = rules + "В Past Perfect Continuous заперечення формується за допомогою заперечної частки not, що ставиться після допоміжного дієслова had. Загальний порядок слів в реченні при цьому не змінюється.\n" +
            "- We had not been searching for a room for two hours before we found a free one. – Ми не шукали кімнату з дві години, поки не знайшли вільну.\n"+
            "- I had not been waiting for them all morning, so I didn’t feel annoyed. – Я не чекала їх весь ранок, тому я не була роздратована.\n";
            rules = rules + "Для того, щоб утворити загальне питання в Past Perfect Continuous, необхідно had (частину комплексного дієслова) винести на початок речення перед підметом (так званий непрямий порядок слів).\n"+
            "? Had you been searching for a room for two hours before we found a free one? – Ви шукали кімнату дві години, поки не знайшли вільну?\n"+
            "? Had she been waiting for them all morning, so she felt annoyed? – Вона прочекала їх весь ранок, тому вона була роздратована?\n"+
            "? Whom had I been waiting all morning then? – Кого я тоді чекала весь ранок?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Present Perfect Continuous")){
            rules = rules + "Стверджувальне речення в Present Perfect Continuous (Present Perfect Progressive) утворюється за допомогою комплексного допоміжного дієслова have been або has been (форми Present Perfect дієслова to be) у поєднанні з формою Present Participle (першої форми дієслова з закінченням -ing).\n"+
            "+ I have been watching this trick all this time. – Я дивилася на цей трюк весь цей час.\n"+
            "+ She has been waiting for you for half an hour. – Вона чекала (чекає) на тебе з півгодини.\n"+
            "+ We’ve been talking about our wedding. – Ми розмовляли (розмовляємо) про наше весілля.\n";
            rules = rules + "В Present Perfect Continuous заперечення утворюється за допомогою заперечної частки not, що ставиться після have або ж has та перед been.\n"+
            "- I have not been watching this trick all this time. – Я не дивилася на цей трюк (фокус) весь цей час.\n" + "- She has not been waiting for you for half an hour. – Вона не чекала (не чекає) на тебе з півгодини.\n";
            rules = rules + "Загальне питання в Present Perfect Continuous утворюється за допомогою винесення допоміжного дієслова have або has на початок речення перед підметом.\n"+
            "? Have you been watching this trick all this time? – Ти дивилася на цей фокус весь цей час?\n" +
            "? How long has she been waiting for you? – Як довго вона тебе чекає?\n" +
            "? Why have we been talking about our wedding? – Чому ми розмовляли про наше весілля?\n";
            sendMessage.setText(rules);
        }
        if(message.getText().equals("Future Perfect Continuous")){
            rules = rules + "Future Perfect Continuous (Future Perfect Progressive) утворюється за допомогою допоміжного дієслова will (або ж рідше shall) та форми доконано-тривалого інфінітиву Perfect Continuous Infinitive без частки to (have been + дієслово із закінченням -ing).\n"+
            "+ I will have been driving for 2 hours before the moment we reach New York. – Я буду (вже) їхати дві години до того моменту, коли ми доїдемо до Нью-Йорка.\n"+
            "+ By the time of her birthday she will have been teaching French for 15 years. – На момент свого дня народження вона буде викладати французьку мову протягом 15 років.\n";
            rules = rules + "Заперечення в Future Perfect Continuous утворюється шляхом додавання частки not після допоміжного дієслова will або shall.\n"+
            "- I will not have been driving for 2 hours before the moment we reach New York. – Я не буду їхати дві години до того моменту, коли ми доїдемо до Нью-Йорка.\n"+
            "- By the time of her birthday she will not have been teaching French for 15 years. – На момент свого дня народження вона (ще) не буде викладати французьку мову протягом 15 років.";
            rules = rules + "Утворення загального питання в Future Perfect Continuous відбувається шляхом винесення допоміжного дієслова will або shall на початок речення перед підметом.\n"+
            "? Will I have been driving for 2 hours before the moment we reach New York? – Чи буду я їхати протягом двох годин до того часу, коли ми доберемося до Нью-Йорка?\n"+
            "? How long will I have been driving before the moment we reach New York? – Як довго я буду їхати до того моменту як ми досягнемо Нью-Йорка?\n"+
            "? By what time will she have been teaching French for 15 years? – До якого часу вона буде викладати французьку мову протягом 15 років?\n";
            sendMessage.setText(rules);
        }



        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    private ReplyKeyboardMarkup getMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Past Simple");
        keyboardRow.add("Present Simple");
        keyboardRow.add("Future Simple");
        KeyboardRow keyboardSecondRow = new  KeyboardRow();
        keyboardSecondRow.add("Past Continuous");
        keyboardSecondRow.add("Present Continuous");
        keyboardSecondRow.add("Future Continuous");
        KeyboardRow keyboardThirdRow = new  KeyboardRow();
        keyboardThirdRow.add("Past Perfect");
        keyboardThirdRow.add("Present Perfect");
        keyboardThirdRow.add("Future Perfect");
        KeyboardRow keyboardFourthRow = new  KeyboardRow();
        keyboardFourthRow.add("Past Perfect Continuous");
        keyboardFourthRow.add("Present Perfect Continuous");
        keyboardFourthRow.add("Future Perfect Continuous");
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        keyboardRows.add(keyboardFourthRow);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
}
