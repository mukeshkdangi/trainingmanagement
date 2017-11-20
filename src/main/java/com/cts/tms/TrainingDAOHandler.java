package com.cts.tms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public static void getTrainingDetailsByDate(String date) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = MysqlConnection.getConnection();
            stmt = conn.prepareStatement(SQL_GET_TRAINING_INFO);
            stmt.setString(1, date);
            ResultSet result = stmt.executeQuery();
            System.out.println("executeUpdate  for " + stmt.toString());
            while (result.next()) {
                System.out.println("trainer_id  for " + result.getString("trainer_id"));
                System.out.println("trn_name  for " + result.getString("trn_name"));
                System.out.println("start_date  for " + result.getString("start_date"));
                System.out.println("college_name  for " + result.getString("college_name"));
                System.out.println("duration  for " + result.getInt("duration"));
            }

        } catch (Exception e) {
            System.out.println("Exception  for " + e);
        } finally {
            MysqlConnection.closeConnection(conn, stmt);
        }

    }

}
