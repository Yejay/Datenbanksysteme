package db.a03;

public class Website {
	final static String TBL_Website = "Website";
	final static String COL_WebsiteID = "WebsiteID";
	final static String COL_Anfrage_ID = "Anfrage_ID";
	final static String COL_aolURL = "aolURL";

	final static String SELECT_STAR_FROM_WEBSITE = "select * from " + TBL_Website + "order by 1 asc";
	
	final static String INSERT_INTO_WEBSITE = "insert into " + TBL_Website + "(" + COL_aolURL + ", " + COL_Anfrage_ID
			+ ") select distinct clickurl, ID FROM aoldata.querydata WHERE query like '%terrorism%'";
	
	final static String DELETE_FROM_WEBSITE = "delete from " + TBL_Website + "where " + COL_aolURL + "is null";
}
