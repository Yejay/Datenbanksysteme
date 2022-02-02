package db.a03;

public class Ort {
	final static String TBL_Ort = "Ort";
	final static String COL_OrtsID = "OrtsID";
	final static String COL_aolLocation = "aolLocation";
	
	final static String SELECT_STAR_FROM_ORT = "select * from " + TBL_Ort;
	final static String INSERT_INTO_ORT = "insert into " +  TBL_Ort + "(" + COL_aolLocation + 
			") select distinct QUERY FROM aoldata.querydata WHERE query like '%pakistan%' AND query like '%terrorism%'";
}
