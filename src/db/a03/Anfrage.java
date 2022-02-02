package db.a03;

public class Anfrage {
	final static String TBL_Anfrage = "Anfrage";

	final static String COL_AnfrageID = "AnfrageID";
	final static String COL_User_ID = "User_ID";
	final static String COL_Uhrzeit = "Uhrzeit";
	final static String COL_Datum = "Datum";

	final static String SELECT_STAR_FROM_ANFRAGE = "select * from " + TBL_Anfrage + "order by 1 asc";
	final static String INSERT_INTO_ANFRAGE = "insert into " + TBL_Anfrage + "(" + COL_AnfrageID + ", " + COL_User_ID + ", "
			+ COL_Uhrzeit + ", " + COL_Datum + ") "
			+ "select ID, to_char(ANONID), to_char(querytime, 'HH24'), to_char(querytime, 'DD.MM.YY') from aoldata.querydata where query like '%terrorism%'";

}
