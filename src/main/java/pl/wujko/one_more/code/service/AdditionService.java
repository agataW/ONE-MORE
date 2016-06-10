package pl.wujko.one_more.code.service;

import pl.wujko.one_more.code.item.entries.Addition;

import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
public interface AdditionService {
    List<Addition> findAll();

    boolean isChicken(Addition addition);

    boolean isChickenAddition(Addition addition);

    boolean isSouse(Addition addition);

    boolean isPotato(Addition addition);
}
