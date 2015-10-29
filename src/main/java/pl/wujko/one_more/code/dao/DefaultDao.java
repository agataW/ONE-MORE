package pl.wujko.one_more.code.dao;

import pl.wujko.one_more.code.item.entries.Topping;

import java.util.List;
import java.util.Map;

/**
 * Created by Agata on 2015-05-14.
 */
public interface DefaultDao {
    List<Map<String, Object>> findAll();

    void add(Topping topping);
}
