package com.neu.myStore.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.Statistics;

import com.neu.myStore.pojo.Genre;
import com.neu.myStore.pojo.Movie;
import com.neu.myStore.pojo.RequestedMovie;
import com.neu.myStore.pojo.Review;
import com.neu.myStore.pojo.User;

public class MovieDAO extends DAO {
	public MovieDAO() {

	}

	public Movie get(String imdbID) {

		Movie movie=null;
		try {
			begin();
			System.out.println("BEFORE BEGIN");
			Session session = getSession();
			System.out.println("BEFORE QUERY");
			Query q = session.createQuery("from Movie where imdbid = :imdbId");
			q.setString("imdbId", imdbID);
			// q.setCacheable(true);
			movie = (Movie) q.uniqueResult();
			// printData(movie, getStat(), 1);
			//System.out.println("MOVIE: " + movie.getActor());
			return movie;

		} catch (HibernateException e) {
			System.out.println("Could not find the movie: " + e.getMessage());
		}

		return movie;

	}

	public Movie create(Movie movie)  {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(movie);

			commit();
			return movie;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not Create the movie: " + e.getMessage());
		}  
		finally {
			if (getSession().isOpen())


				getSession().close();

		}
		return movie;

	}

	public void delete(Movie movie)   {
		try {
			begin();
			getSession().delete(movie);
			commit();
		} catch (HibernateException e) {
			rollback();
		}

	}

	public void update(Movie movie) {
		begin();

		getSession().update(movie);
		commit();

	}

	public RequestedMovie createRequestedMovie(RequestedMovie reqmovie) {
		try {
			begin();
			System.out.println("inside DAO");

			getSession().save(reqmovie);

			commit();
			return reqmovie;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not Create the movie: " + e.getMessage());
		}  
		finally {
			if (getSession().isOpen())
				getSession().close();

		}
		return reqmovie;

	}

	public ArrayList<String> getUserNames(Movie movie) {
		SQLQuery q = getSession().createSQLQuery("select firstname from userTable where id in (select id from userslikedmovies where movieid =:movieid)");
		q.setParameter("movieid",movie.getMovieid());
		ArrayList<String> users = (ArrayList<String>)q.list();
		System.out.println(users);
		return users;
	}

	public List<Review> getReview(Movie movie) {
		List<Review> reviews = null;

		try
		{

			Query q = getSession().createQuery("from Review where movie=:movie1");
			q.setParameter("movie1",movie);
			reviews=(List<Review> )q.list();
			System.out.print("Review...."+reviews);

		}
		catch(Exception e)
		{
			System.out.print("Exception...."+e.getMessage());
		}
		return reviews;
	}

	public List<Movie> getMovieListForGenre(String favGenre) {

		Criteria crit=getSession().createCriteria(Genre.class);
		
		crit.add(Restrictions.like("genreName","%"+favGenre+"%"));
		
		List<Genre> favgenres=(List<Genre>) crit.list();
		System.out.println("favgenres"+favgenres);

		List<String> movieids = new ArrayList<String> () ;


		for(Genre genr:favgenres)
		{

			SQLQuery q = getSession().createSQLQuery("select movieid from movie_genre where genreid="+genr.getGenreid());
			//q.setInteger("genids",genr.getGenreid());
			List movieids2 = q.list();
			if(!movieids2.isEmpty())
			{
				try{
					System.out.println("movieids "+q.list().get(0));
					String i = q.list().get(0).toString();
					movieids.add(i);
					System.out.println("movieids2 "+movieids);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}


		System.out.println("movieids "+movieids);

		List<Movie>favgmovies=new ArrayList<Movie>(); 
		for(String o:movieids)
		{
			System.out.println("o: "+o);

			long l = Long.parseLong(o);
			System.out.println("l: "+l);
			Criteria crit2=getSession().createCriteria(Movie.class);
			crit2.add(Restrictions.eq("movieid",l));
			favgmovies.add((Movie)crit2.list().get(0));

		}


		System.out.println("favgmovies"+favgmovies);
		return favgmovies;
	}

	public List<RequestedMovie> getRequestedMovies() {
		List<RequestedMovie> reqList=null;
		try {
			System.out.println("BEFORE BEGIN");
			Session session = getSession();
			System.out.println("BEFORE QUERY");
			Query q = session.createQuery("from RequestedMovie");
			//q.setString("imdbId", imdbID);
			reqList = (List<RequestedMovie>) q.list();
			// System.out.println("MOVIE: " + movie.getActor());
			return reqList;

		} catch (HibernateException e) {
			System.out.println("Could not find the requested movie: " + e.getMessage());
		}
		return reqList;
	}


	private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count="
				+ stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count="
				+ stats.getSecondLevelCacheHitCount());
		System.out
		.println("Second Level Miss Count="
				+ stats
				.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count="
				+ stats.getSecondLevelCachePutCount());
	}

	private static void printData(Movie mv, Statistics stats, int count) {
		System.out.println(count+":: MovieName="+mv.getTitle());
		printStats(stats, count);
	}

}
