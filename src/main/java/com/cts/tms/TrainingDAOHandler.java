package com.cts.tms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;

public class TrainingDAOHandler {

    private TrainingRecord tainingRecord;

    @Builder
    TrainingDAOHandler(TrainingRecord tainingRecord) {
        this.tainingRecord = tainingRecord;
    }

    private static final String TABLE_TRAINING_INFO         = "trainer_info";
    private static final String TABLE_TRAINING_SCHEDULE     = "training_schedule";

    private static final String SQL_STORE_TRAINING_INFO     = "insert into " + TABLE_TRAINING_INFO
            + " values (?, ?, ?)";
    private static final String SQL_STORE_TRAINING_SCHEDULE = "insert into " + TABLE_TRAINING_SCHEDULE
            + " (trainer_id, trn_name, start_date, duration, college_name) values (?, ?, ?, ?, ?)";

    private static final String SQL_GET_TRAINING_INFO       = "select * from  " + TABLE_TRAINING_SCHEDULE
            + " where start_date = (?) ";

    public void storeTrainingDetails() {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = MysqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_STORE_TRAINING_INFO);
            stmt.setInt(1, tainingRecord.getTrainerID());
            stmt.setString(2, tainingRecord.getTrainerName());
            stmt.setString(3, tainingRecord.getDomain());
            stmt.executeUpdate();
            System.out.println("executeUpdate  for " + stmt.toString());
            MysqlConnection.closeConnection(conn, stmt);

            conn = MysqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_STORE_TRAINING_SCHEDULE);
            stmt.setInt(1, tainingRecord.getTrainerID());
            stmt.setString(2, tainingRecord.getTrainerName());
            stmt.setString(3, tainingRecord.getDate());
            stmt.setInt(4, tainingRecord.getDuration());
            stmt.setString(5, tainingRecord.getCollegeName());
            stmt.executeUpdate();
            System.out.println("executeUpdate  for " + stmt.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MysqlConnection.closeConnection(conn, stmt);
        }

    }

    public static List<TrainingRecord> getTrainingDetailsByDate(String date) {
        PreparedStatement stmt = null;
        Connection conn = null;
        List<TrainingRecord> tRecordList = new ArrayList<>();
        try {
            conn = MysqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_GET_TRAINING_INFO);
            stmt.setString(1, date);
            ResultSet result = stmt.executeQuery();
            System.out.println("executeUpdate  for " + stmt.toString());
            while (result.next()) {
                TrainingRecord tRecord = new TrainingRecord();
                tRecord.setTrainerID(result.getInt("trainer_id"));
                tRecord.setTrainerName(result.getString("trn_name"));
                tRecord.setDate(result.getString("start_date"));
                //tRecord.setTrainingName(result.getString("start_date"));
                tRecord.setCollegeName(result.getString("college_name"));
                tRecord.setDuration(result.getInt("duration"));
               // tRecord.setDomain(result.getString("domain"));
                tRecordList.add(tRecord);
            }

        } catch (Exception e) {
            System.out.println("Exception  for " + e);
        } finally {
            MysqlConnection.closeConnection(conn, stmt);
        }
        return tRecordList;

    }

}
