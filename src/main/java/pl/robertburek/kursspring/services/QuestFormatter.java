package pl.robertburek.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;
import pl.robertburek.kursspring.domain.Quest;
import pl.robertburek.kursspring.domain.repository.QuestRepository;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Robert Burek
 */
@Service
public class QuestFormatter implements Formatter<Quest> {

    @Autowired
    QuestRepository questRepository;

    @Override
    public Quest parse(String idAsStr, Locale locale) throws ParseException {
        Integer id=Integer.parseInt(idAsStr);
        return questRepository.getQuest(id);
    }

    @Override
    public String print(Quest quest, Locale locale) {
        return quest.toString();
    }
}
