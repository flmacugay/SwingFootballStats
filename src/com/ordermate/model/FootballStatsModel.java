package com.ordermate.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.ordermate.model.FootballStatsService;

/**
 *
 * @author Froilan
 */
public class FootballStatsModel implements FootballStatsService {
    
    private String mostConsistentTeam;
    private final int PTS_FOR=6, PTS_AGN=7, WIN=3, DRAW=4, TOT_GAMES=2;

    @Override
    public void calculateMostConsistentTeam(TableModel tblModel) throws NumberFormatException {
        String team="";
        BigDecimal teamRating = null;
        for(int i=0; i<tblModel.getRowCount(); i++){
            String tmpTeam=(String) tblModel.getValueAt(i, 1);
            BigDecimal tmpTeamRating=computeRating(tblModel, i);
            if(i==0 || tmpTeamRating.compareTo(teamRating)<0) {
                team=tmpTeam;
                teamRating=tmpTeamRating;
            }
        }
        mostConsistentTeam=team;
    }
    
    @Override
    public String getMostConsistentTeam() {
        return mostConsistentTeam;
    }
    
    private BigDecimal computeRating(TableModel tblModel, int i) throws NumberFormatException{
        return computeRating(parseInt(tblModel.getValueAt(i, PTS_FOR)), 
                    parseInt(tblModel.getValueAt(i, PTS_AGN)), 
                    parseInt(tblModel.getValueAt(i, WIN)), 
                    parseInt(tblModel.getValueAt(i, DRAW)), 
                    parseInt(tblModel.getValueAt(i, TOT_GAMES)));
    }
    
    /**
     * 
     * the most consistent is the team that has the smallest gap between winning expectation and actual winning percentage
     * most consistent = winning expectation - actual winning percentage
     * where
     * winning expectation = points scored for / (points scored for + points scored against)
     * actual winning percentage = (wins + (draw/2)) / (total games played)
     * 
     */
    private BigDecimal computeRating(int ptsFor, int ptsAgn, int win, int draw, int totGames) throws NumberFormatException{
        BigDecimal winningExpectation=BigDecimal.valueOf(ptsFor).divide(BigDecimal.valueOf(ptsFor).add(BigDecimal.valueOf(ptsAgn)),2,RoundingMode.HALF_UP);
        BigDecimal winningPercentage=BigDecimal.valueOf(win).add(BigDecimal.valueOf(draw).divide(BigDecimal.valueOf(2))).divide(BigDecimal.valueOf(totGames),2,RoundingMode.HALF_UP);
        return winningExpectation.subtract(winningPercentage).abs(new MathContext(2, RoundingMode.UNNECESSARY));
    }
    
    private int parseInt(Object val) throws NumberFormatException{
        return Integer.parseInt((String) val);
    }
    
}
