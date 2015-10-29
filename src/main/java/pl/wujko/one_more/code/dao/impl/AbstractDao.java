package pl.wujko.one_more.code.dao.impl;

import pl.wujko.one_more.code.service.DatabaseService;
import pl.wujko.one_more.code.dao.DefaultDao;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Agata on 2015-05-14.
 */
public abstract class AbstractDao implements DefaultDao
{
    @Resource
    protected DatabaseService database;

    public List<Map<String, Object>> findAll() {
        ResultSet resultSet;
        List<Map<String, Object>> result;
        try {
            resultSet = database.getStatement().executeQuery("SELECT * FROM " + getTableName());
            result = convert(resultSet);
        } catch (SQLException e) {
            return null;
        }
        return result;
    }

    private List<Map<String, Object>> convert(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<String> attributes = getAttributes();
        while (resultSet.next()) {
            Map<String, Object> item = new HashMap<String, Object>();
            for (String attribute : attributes) {
                item.put(attribute, resultSet.getObject(attribute));
            }
            result.add(item);
        }
        return result;
    }

    abstract protected String getTableName();

    abstract protected List<String> getAttributes();

//    public List<Map<String, Object>> find(Map<String, Object> params) {
//        ResultSet resultSet;
//        List<Map<String, Object>> result;
//        try {
//            resultSet = database.getStatement().executeQuery(getQuery(params));
//            result = convert(resultSet);
//        } catch (SQLException e) {
//            return null;
//        }
//        return result;
//    }
//
//    private String getQuery(Map<String, Object> params) {
//        StringBuilder query = new StringBuilder();
//        query.append("SELECT * FROM " + getTableName());
//
//        if (params != null && !params.isEmpty()) {
//            query.append(" WHERE ");
//            for (Map.Entry<String, Object> entry : params.entrySet()) {
//                query.append(entry.getKey())
//            }
//        }
//
//
//        return null;
//    }
}
