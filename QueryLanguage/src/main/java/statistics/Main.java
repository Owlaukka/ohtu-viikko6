package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
        QueryBuilder query = new QueryBuilder();
        
        Matcher m1 = query.playsIn("PHI")
                          .not()
                          .hasAtLeast(20, "goals")
                          .hasFewerThan(20, "assists")
                          .build();
        
        Matcher m2 = query.oneOf(
                                query.playsIn("PHI")
                                     .hasAtLeast(20, "goals")
                                     .hasFewerThan(20, "assists")
                                     .build(),
                
                                query.playsIn("CAR")
                                     .hasAtLeast(20, "goals")
                                     .build(),
                                
                                query.hasAtLeast(50, "goals")
                                     .build()
                                ).build();
        
        
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasFewerThan(20, "assists"),
                             new Not(new PlaysIn("PHI"))
        );
        
        for (Player player : stats.matches(m2)) {
            System.out.println( player );
        }
    }
}
