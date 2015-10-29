package pl.wujko.one_more.code.dao;

import java.util.List;

/**
 * Created by Agata on 2015-10-06.
 */
public interface Dao<T>
{
    List<T> findAll();
}
