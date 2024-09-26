package com.netflix.reviews.types;

import java.util.List;

public record Movie(Integer showId, List<Review> reviews) implements Show{
}
