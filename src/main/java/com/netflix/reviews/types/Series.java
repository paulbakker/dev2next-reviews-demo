package com.netflix.reviews.types;

import java.util.List;

public record Series(Integer showId, List<Review> reviews) implements Show{
}
