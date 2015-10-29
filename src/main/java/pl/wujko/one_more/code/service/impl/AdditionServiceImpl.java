package pl.wujko.one_more.code.service.impl;

import pl.wujko.one_more.code.dao.impl.AdditionDao;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.AdditionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
public class AdditionServiceImpl implements AdditionService{

    @Resource
    private AdditionDao additionDao;

    private List<Addition> additionList;

    @Override
    public List<Addition> findAll() {
        if (additionList == null){
            additionList = additionDao.findAll();
        }
        return additionList;
    }
}
