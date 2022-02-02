package db.a03;

public class Statements {
	/** Question Nr. 1 Halbwegs richtig nur 1 Spalte */
	final static String QUESTION_1 = "select count(DISTINCT(querytime)) from AOLDATA.querydata where query like '%terrorism%'";
	/** Question Nr. 2 FUNKTIONIERT */
	final static String QUESTION_2 = "select to_char(querytime, 'MM.YY') as month, count(*) as anzahl from aoldata.querydata where query like '%terrorism%' group by to_char(querytime, 'MM.YY') order by 1 asc";
	/** Question Nr. 3 Diagramm nicht sinnvoll */
	final static String QUESTION_3 = "select * from aoldata.querydata where query like '%terrorism%' AND query like '%israel%'";
	/** Question Nr. 4 FUNKTIONIERT */
	final static String QUESTION_4 = "select to_char(querytime, 'HH24') as time, count(*) as anzahl from aoldata.querydata where query like '%terrorism%' group by to_char(querytime, 'HH24') order by 1 asc";
	/** Question Nr. 5 Halbwegs richtig nur 1 Spalte */
	final static String QUESTION_5 = "select count(DISTINCT querytime) from AOLDATA.querydata where query like '%9 11%' OR query like '%9/11%'\r\n"
			+ "OR query like '%911%'OR query like '%nine eleven%' OR query like '%war on terror%'\r\n";
	/** Question Nr. 6 Diagramm nicht sinnvoll */
	final static String QUESTION_6 = "select * from aoldata.querydata where query like '%terrorism%' AND query like '%pakistan%'s";
	/** Question Nr. 7 FUNKTIONIERT */
	final static String QUESTION_7 = "select CLICKURL, count(*) as Website from aoldata.querydata where query like '%terrorism%' and Clickurl is not null group by CLICKURL order by 2 desc fetch next 10 rows only";
	/** Question Nr. 8 Halbwegs richtig nur 1 Spalte */
	final static String QUESTION_8 = "select count(DISTINCT anonID)  FROM aoldata.querydata where query like '%terrorism%'";
	/** Question Nr. 9 Behindert */
	final static String QUESTION_9 = "select * from aoldata.querydata where query like '%terrorism%'";
	/** Question Nr. 10 Halbwegs richtig nur 1 Spalte */
	final static String QUESTION_10 = "select count(DISTINCT query) FROM aoldata.querydata \r\n"
			+ "WHERE query like '%terrorism%' AND query like '%religion%'\r\n";
}
