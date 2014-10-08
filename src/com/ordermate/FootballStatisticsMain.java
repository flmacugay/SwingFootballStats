package com.ordermate;

import com.ordermate.controller.FootballStatsController;
import com.ordermate.model.FootballStatsModel;
import com.ordermate.model.FootballStatsService;
import com.ordermate.view.FootballStatsView;

/**
 *
 * @author Froilan
 */
public class FootballStatisticsMain {
    
    public static void main(String[] args) {
        FootballStatsView view = new FootballStatsView();
        FootballStatsService model = new FootballStatsModel();
        new FootballStatsController(view, model);
    }
}
