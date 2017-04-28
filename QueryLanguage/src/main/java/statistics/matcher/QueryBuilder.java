/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ola
 */
public class QueryBuilder {
    
    private List<Matcher> matchers;
    
    public QueryBuilder() {
        matchers = new ArrayList<>();
    }
    
    public Matcher build() {
        Matcher[] arr = new Matcher[0];
        Matcher returnM = new And(matchers.toArray(arr));
        matchers = new ArrayList<>();
        return returnM;
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public QueryBuilder not() {
        Matcher lastMatcherReversed = new Not(matchers.get(matchers.size()-1));
        matchers.remove(matchers.size()-1);
        matchers.add(lastMatcherReversed);
        return this;
    }
}
