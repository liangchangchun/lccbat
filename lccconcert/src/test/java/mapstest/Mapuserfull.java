package mapstest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class Mapuserfull {

	@Test
	public void mapstest1(){
	
		String cas = "上汽荣威荣威RX5,8;华晨宝马宝马5系,5;奇瑞捷豹路虎-路虎揽胜极光,3;上汽通用别克君越,4;上汽大众朗逸,6";
		Map<String, String> result = Splitter.on(";").withKeyValueSeparator(",").split(cas); 
		Collection<String> valueCollection = result.values();
		List<String> cnts = new ArrayList<String>(valueCollection);
		System.out.println("排序前"+cnts);
		Collections.sort(cnts);
		System.out.println("升序输出"+cnts);
		Collections.sort(cnts,new Comparator<String>(){
			            public int compare(String o1, String o2) {
			                 return o2.compareTo(o1);
		             }});
		System.out.println("降序输出"+cnts);
		Collections.reverse(cnts);
		System.out.println("反转"+cnts);
	    
		Set<String> infos = result.keySet();
		String  carsInfo = infos.toString();
		System.out.println(carsInfo);
	   
		String re = CharMatcher.DIGIT.or(CharMatcher.is(',')).negate().retainFrom(cas).replace(";", ",");
		System.out.println(re);
		
		System.out.println(cas.substring(0,cas.length()-1));
	}
}
