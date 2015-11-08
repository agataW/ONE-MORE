package pl.wujko.one_more.code.service;

import pl.wujko.one_more.code.item.entries.Topping;

import java.util.List;

/**
 * Created by Agata on 2015-05-18.
 */
public interface ToppingService {
    List<Topping> findAll();

    List<Topping> findAllVisible();

    Topping getByKey(String toppingKey);
}
