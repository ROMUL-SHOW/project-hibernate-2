package org.movie.domain.interactor;

import org.movie.data.entity.Language;
import org.movie.domain.repository.LanguageRepository;

import java.util.List;

public class LanguageInteractor {
    private final LanguageRepository languageRepository;

    public LanguageInteractor(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public Language findById(Byte id) {
        return languageRepository.findById(id);
    }

    public void save(Language language) {
        languageRepository.save(language);
    }

    public void update(Language language) {
        languageRepository.update(language);
    }

    public void delete(Byte id) {
        languageRepository.delete(id);
    }
}
