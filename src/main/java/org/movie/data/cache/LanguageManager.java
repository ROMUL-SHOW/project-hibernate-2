package org.movie.data.cache;

import org.movie.data.db.dao.LanguageDAO;
import org.movie.data.entity.Language;

import java.util.List;

public class LanguageManager {
    private final LanguageDAO languageDAO;

    public LanguageManager(LanguageDAO languageDAO) {
        this.languageDAO = languageDAO;
    }

    public List<Language> findAll() {
        return languageDAO.findAll();
    }

    public Language findById(Byte id) {
        return languageDAO.findById(id);
    }

    public void save(Language language) {
        languageDAO.save(language);
    }

    public void update(Language language) {
        languageDAO.update(language);
    }

    public void delete(Byte id) {
        languageDAO.delete(id);
    }
}
