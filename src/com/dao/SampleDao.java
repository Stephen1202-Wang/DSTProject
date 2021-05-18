package com.dao;

import com.bean.Sample;
import com.dbutils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SampleDao extends BaseDao {

    public int save(String name) {
        AtomicInteger key = new AtomicInteger();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sample(created_at, name) values (?,?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
                preparedStatement.setString(2, name);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                while (generatedKeys.next()) {
                    key.set(generatedKeys.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return key.get();
    }

    public List<Sample> findAll() {
        List<Sample> samples = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from sample order by id DESC");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int sampleId = resultSet.getInt("id");
                    Date createdAt = new Date(resultSet.getTimestamp("created_at").getTime());
                    String name = resultSet.getString("name");
                    Sample sample = new Sample(sampleId, createdAt, name);
                    samples.add(sample);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return samples;
    }

    public Sample findById(int id) {
        AtomicReference<Sample> sample = new AtomicReference<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select id, created_at, name from sample where id = ?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int sampleId = resultSet.getInt("id");
                    Date createdAt = new Date(resultSet.getTimestamp("created_at").getTime());
                    String name = resultSet.getString("name");
                    sample.set(new Sample(sampleId, createdAt, name));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return sample.get();
    }
}
