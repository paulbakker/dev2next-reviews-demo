package com.netflix.reviews.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.netflix.reviews.types.Movie;
import com.netflix.reviews.types.Review;
import com.netflix.reviews.types.Series;
import com.netflix.reviews.types.Show;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@DgsComponent
public class ShowDataFetcher {

    private final static Logger LOGGER = LoggerFactory.getLogger(ShowDataFetcher.class);

    @DgsData(parentType = "Show")
    public List<Review> reviews(DgsDataFetchingEnvironment dfe) {

        Show show = dfe.getSourceOrThrow();
        LOGGER.info("Get reviews for show {}", show.showId());

        return List.of(new Review(5, "Great show " + show.showId()));
    }



    @DgsEntityFetcher(name = "Movie")
    public Movie movie(Map<String, Object> values) {
        return new Movie((Integer) values.get("showId"), null);
    }

    @DgsEntityFetcher(name = "Series")
    public Series series(Map<String, Object> values) {
        return new Series((Integer) values.get("showId"), null);
    }
}
