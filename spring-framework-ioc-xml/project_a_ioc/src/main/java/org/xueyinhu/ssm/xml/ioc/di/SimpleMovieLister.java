package org.xueyinhu.ssm.xml.ioc.di;

public class SimpleMovieLister {
    private MovieFinder movieFinder;
    private String movieName;
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
