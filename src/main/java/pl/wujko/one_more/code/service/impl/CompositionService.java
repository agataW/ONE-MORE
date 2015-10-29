package pl.wujko.one_more.code.service.impl;

import pl.wujko.one_more.code.dao.impl.CompositionDao;
import pl.wujko.one_more.code.item.entries.Composition;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Agata on 2015-10-06.
 */
public class CompositionService
{
    @Resource
    private CompositionDao compositionDao;

    private List<Composition> compositionList;

    public List<Composition> findAll() {
        if (compositionList == null){
            compositionList = compositionDao.findAll();
        }
        return compositionList;
    }
}
