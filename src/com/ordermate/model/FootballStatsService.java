package com.ordermate.model;

/**
 *
 * @author Froilan
 */
public interface FootballStatsService {
    void calculateMostConsistentTeam(TableModel tblModel) throws NumberFormatException;
    String getMostConsistentTeam();
}
