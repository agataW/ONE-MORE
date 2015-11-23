package pl.wujko.one_more.frontend.interfaces;

import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.panels.food.workshop.SpacePanel;

import java.util.LinkedList;

/**
 * Created by Agata on 2015-11-22.
 */
public class SpaceList<T extends Entry> extends LinkedList<T>
{
    private SpacePanel.Space space;

    public SpaceList(SpacePanel.Space space)
    {
        this.space = space;
    }

    public SpacePanel.Space getSpace()
    {
        return space;
    }
}
