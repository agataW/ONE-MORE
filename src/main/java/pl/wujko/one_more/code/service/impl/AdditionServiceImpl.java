package pl.wujko.one_more.code.service.impl;

import pl.wujko.one_more.code.dao.impl.AdditionDao;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.AdditionService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
public class AdditionServiceImpl implements AdditionService
{
    @Resource
    private AdditionDao additionDao;

    private List<Addition> additionList;

    private List<String> chickenSauce = Arrays.asList("X", "Y", "Z", "S", "Q2", "KECHUP");

    private List<String> chickenPotato = Arrays.asList("FRY", "ZIEM", "KULKI");

    @Override
    public List<Addition> findAll() {
        if (additionList == null){
            additionList = additionDao.findAll();
        }
        return additionList;
    }

    @Override
    public boolean isChicken(Addition addition)
    {
        return "KURCZAK".equals(addition.getKey());
    }

    @Override
    public boolean isChickenXXL(Addition addition)
    {
        return "KUR XXL".equals(addition.getKey());
    }

    @Override
    public boolean isChickenAddition(Addition addition)
    {
        return chickenSauce.contains(addition.getKey()) || chickenPotato.contains(addition.getKey());
    }

    @Override
    public boolean isPotato(Addition addition)
    {
        return chickenPotato.contains(addition.getKey());
    }

    @Override
    public boolean isSouse(Addition addition)
    {
        return chickenSauce.contains(addition.getKey());
    }
}
