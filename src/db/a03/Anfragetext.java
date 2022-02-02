package db.a03;

public class Anfragetext {
	final static String TBL_Anfragetext = "Anfragetext";
	final static String COL_AnfragetextID = "AnfragetextID";
	final static String COL_Anfrage_ID = "Anfrage_ID";
	final static String COL_aolText = "Aoltext";
	final static String COL_aolUrl = "Aolurl";

	final static String INSERT_INTO_ANFRAGETEXT = "insert into " + TBL_Anfragetext + "(" + COL_Anfrage_ID + ", "
			+ COL_aolText + ", " + COL_aolUrl
			+ ") select distinct ID, query, clickurl FROM aoldata.querydata WHERE query like '%terrorism%'";

	final static String SELECT_STAR_FROM_ANFRAGETEXT = "select * from " + TBL_Anfragetext;
}
