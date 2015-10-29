package pl.wujko.one_more.code.item.entries;

import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

/**
 * Created by Agata on 2015-10-06.
 */
public class Composition extends Entry
{
    @Override
    public EntryTypeEnum getType()
    {
        return EntryTypeEnum.COMPOSITION;
    }
}
