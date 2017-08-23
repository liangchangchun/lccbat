package iosplit;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.SpringLayout.Constraints;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;
import com.google.common.primitives.Ints;

public class SplitterTest {

	@Test
	public void test1(){
		String str = "a,,b,     c1,,,d2"; 

		Iterable<String> result = Splitter.on(',').omitEmptyStrings().trimResults(CharMatcher.DIGIT.or(CharMatcher.is(' ')))
		       .split(str); 

		System.out.println("--start--"); 
		for(String s: result){ 
		System.out.println(s); 
		} 
		System.out.println("--end--"); 
	}
	
	@Test
	public void test2(){
		String str = "aaaabbbbccccdddd"; 
		Iterable<String> result = Splitter.fixedLength(4)
			       .split(str); 
		System.out.println("--start--"); 
		for(String s: result){ 
		System.out.println(s); 
		} 
		System.out.println("--end--"); 
	}
	
	@Test
	public void test3(){
		Stopwatch stopwatch =Stopwatch.createStarted();
		String userInput = "nihao1234-1";

        CharMatcher ID_MATCHER = CharMatcher.DIGIT.or(CharMatcher.is('-'));

       System.out.println(ID_MATCHER.negate().retainFrom(userInput));
       long mill = stopwatch.elapsed(TimeUnit.MILLISECONDS);
       System.out.println(mill);

	}
	
	@Test
	public void test4(){
		//String str = "FirstName LastName +1 123 456 789 !@#$%^&*()_+|}{:\"?><";
		//System.out.println(CharMatcher.ANY.countIn(str));
		//System.out.println(str.length());
		boolean preCondition =true;
		Preconditions.checkArgument(!preCondition);
	}
	
	@Test
	public void test5(){
		 Map<String, Integer> salary = Maps.newHashMap();  
		    salary.put("John", 1000);  
		    salary.put("Jane", 1500);  
		    String result = Joiner.on(" , ").withKeyValueSeparator(" = ")  
		                                    .join(salary);  
		   
		   System.out.println(result);
	}
	
	@Test
	public void test6(){
		 List<String> names = Lists.newArrayList("John", null, "Jane", "Adam", "Tom");  
 		  String result = Joiner.on(",").skipNulls().join(names); 
 		 //String result = Joiner.on(",").useForNull("nameless").join(names); 
 		  System.out.println(result);
	}
	
	@Test
	public void test7(){
		//String input = "John=first,Adam=second";  
	   	 //  Map<String, String> result =
	   	//		   Splitter.on(",")  .withKeyValueSeparator("=")   .split(input);  
	   	String input = "apple.banana,,orange,,.";  
		List<String> result =
				Splitter.onPattern("[.|,]") .omitEmptyStrings()   .splitToList(input); 

	   	System.out.println(result);
	}
	
	@Test
	public void test8(){
		List<String> names = Lists.newArrayList();
        names.add("iamzhongyong");
        names.add("bixiao.zy");
        StringBuilder sb = new StringBuilder();
        String rs = Joiner.on("--").appendTo(sb, names).toString();
        System.out.println(rs);
	}
	
	@Test
	public void test9(){
		int[] array = { 1, 2, 3, 4, 5 };
		boolean has =Ints.contains(array, 3);
		String[] strarry = { "1", "2", "3", "4", "5" };
		System.out.println(Strings.commonPrefix("aaab", "a1ac"));
			String a="1234567";  
	        String b=Strings.padEnd(a, 10, 'x');  
	        System.out.println(b);  
	        HashSet<String> setB    =  Sets.newHashSet();
	       Map<String,String>  map =  Maps.newHashMap();
	}
	
	@Test
	public void test10(){
		 List<String> list = Lists.newArrayList();
	        list.add("a");
	        list.add("b");
	        list.add("c");
	        //对原有的List进行包装，相当于原有List的视图，快照,不够安全.
	       // List<String> readList = Collections.unmodifiableList(list);
	        //java.lang.UnsupportedOperationException
	        //readList.add("d");//报错
	        //list.add("d");//改变原有List   视图也一起改变  不报错
	       // System.out.println(readList);

	        //Guava
	        //对比查看  初始化List guava对只读设置安全可靠 并且相对简单
	        List<String> immutableList = ImmutableList.of("a","b","c");
	        //java.lang.UnsupportedOperationException
	       // immutableList.add("d");//报错
	        System.out.println(immutableList.toString());
	}
	
	@Test
	public void test11(){
	    //创建List 静态初始化
	    List<String> list = Lists.newArrayList("SDF","SDAF","FASD","MOOM","ESDSE");
	        //找出回文
	        //匿名内部类对象：匿名内部类，同时创建类对象
	        Collection<String> palindroomList = Collections2.filter(list, new Predicate<String>() {
	            public boolean apply(String input)
	            {
	                //业务逻辑
	                return new StringBuilder(input).reverse().toString().equals(input);
	            }
	        });

	        for(String temp:palindroomList)
	        {
	            System.out.println(temp);
	        }

	}
	
	@Test
	public void test12(){
		//类型转换
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(1000000L);
        timeSet.add(999999999999L);
        timeSet.add(20000000L);

        Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {
            public String apply(Long input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        });

        for(String temp:timeStrCol)
        {
            System.out.println(temp);
        }

	}
	
	@Test
	public void test13(){

	    //组合式函数编程
	        //确保容器中的字符串长度不超过5，超过进行截取，后全部大写
	        List<String> list = Lists.newArrayList("lovebaby","good","happiness");

	        //确保容器中的字符串长度不超过5，超过进行截取
	        Function<String, String> f1 = new Function<String, String>() {
	            public String apply(String input) {
	                return input.length()>5?input.substring(0,5):input;
	            }
	        };

	        //全部大写
	        Function<String, String> f2 = new Function<String, String>() {
	            public String apply(String input) {
	                return input.toUpperCase();
	            }
	        };

	        //组合使用
	        //String = f2(f1(String))
	        Function<String, String> f = Functions.compose(f1, f2);

	        Collection<String> resultCol = Collections2.transform(list,f);

	        for(String temp:resultCol)
	        {
	            System.out.println(temp);
	        }
	}
	
	@Test
	public void test14(){
		 /*Set<String> sets = Sets.newHashSet();
	        // 创建约束
	        Constraint<String> constraint = new Constraint<String>() {

	            public String checkElement(String element) {
	                // 非空验证
	                Preconditions.checkNotNull(element);

	                // 长度限制 5-20,否则报错
	                Preconditions.checkArgument(
	                        element.length() >= 5 && element.length() <= 20,
	                        element);
	                return element;
	            }

	        };

	        Set<String> cs = Constraints.constrainedSet(sets, constraint);*/
	}
	
	@Test
	public void test15(){
		 Set<Integer> sets = Sets.newHashSet(1,2,3,4,5,6);
	        Set<Integer> sets2 = Sets.newHashSet(3,4,5,6,7,8,9);

	        //交集
	        System.out.println("交集为：");
	        SetView<Integer> intersection = Sets.intersection(sets, sets2);
	        for(Integer temp:intersection)
	        {
	            System.out.print(temp+" ");
	        }
	        System.out.println();
	        //差集
	        System.out.println("差集为：");
	        SetView<Integer> diff = Sets.difference(sets, sets2);
	        for(Integer temp:diff)
	        {
	            System.out.print(temp+" ");
	        }
	        System.out.println();
	        //并集
	        System.out.println("并集为：");
	        SetView<Integer> union = Sets.union(sets, sets2);
	        for(Integer temp:union)
	        {
	            System.out.print(temp+" ");
	        }
	        System.out.println();
	}
	@Test
	public void test16(){
		Map<String,String> mapA =ImmutableMap.of("key1", "value1", "key2", "value2");  
		Map<String,String> mapB =ImmutableMap.of("key1", "value1", "key3", "value3");
		MapDifference<String, String> differenceMap = Maps.difference(mapA, mapB);  
		  
		System.out.println(differenceMap.areEqual());  
		Map entriesDiffering = differenceMap.entriesDiffering();  
		Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();  
		Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();  
		Map entriesInCommon = differenceMap.entriesInCommon(); 

		showMap(entriesDiffering);
		//showMap(entriesOnlyOnLeft);
		//showMap(entriesOnlyOnRight);
		//showMap(entriesInCommon);
	}
	
	@Test
	public void test17(){
		String str = "this is a cat that is a mice where is the food";
        //分割字符串
       // String[] strArray = str.split(" ");
		 Iterable<String> strArray = Splitter.on(' ').trimResults().split(str);
        //存储到Multiset中
        Multiset<String> set = HashMultiset.create();
        for(String temp :strArray)
        {
            set.add(temp);
        }
        //获取所有的单词Set
        Set<String> letters = set.elementSet();
        for(String temp:letters)
        {
            System.out.println(temp+"-->"+set.count(temp));
        }
	}
	
	@Test
	public void test18(){
		 Map<String,String> cours =Maps.newHashMap();
	        //加入测试数据 
	        cours.put("改革开放","邓小平");
	        cours.put("三个代表","江泽民");
	        cours.put("和谐社会","胡锦涛");
	        cours.put("八荣八耻","胡锦涛");
	        cours.put("互联网+","李克强");
	        //Multimap
	        Multimap<String, String> teachers = ArrayListMultimap.create();
	        //迭代器
	        Iterator<Map.Entry<String, String>> it = cours.entrySet().iterator();
	        while(it.hasNext())
	        {
	            Map.Entry<String, String> entry = it.next();
	            String key = entry.getKey();//课程
	            String value = entry.getValue();//教师
	            //教师-->课程
	            teachers.put(value,key);
	        }       
	        //查看Multimap
	        Set<String> keyset = teachers.keySet();
	        for(String key:keyset)
	        {
	            Collection<String> col = teachers.get(key);
	            System.out.println(key+"-->"+col); 
	        }
	}
	
	@Test
	public void test19(){
		 BiMap<String, String> biMap = HashBiMap.create();
	        biMap.put("liguodong", "liguodong@sina.com");
	        biMap.put("good","good@qq.com");
	        //通过邮箱找用户
	        String user = biMap.inverse().get("good@qq.com");
	        System.out.println(user);
	        System.out.println( biMap.inverse().inverse()==biMap );

	}
	
	@Test
	public void test20(){
		 Table<String, String, Integer> tables = HashBasedTable.create();
		    //测试数据
	        tables.put("a", "javase", 80);
	        tables.put("b", "javase", 90);
	        tables.put("a", "oracle", 100);
	        tables.put("c", "javase", 95);

	        //所有的行数据
	        Set<Cell<String, String, Integer>> cells = tables.cellSet();
	        for(Cell<String, String, Integer> temp:cells)
	        {
	            System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
	        }


	        System.out.println("=======学生查看成绩============");
	        System.out.print("学生\t");
	        //所有的课程
	        Set<String> cours = tables.columnKeySet();
	        for(String t:cours)
	        {
	            System.out.print(t+"\t");
	        }
	        System.out.println();

	        //所有的学生
	        Set<String> stus = tables.rowKeySet();

	        for(String stu:stus)
	        {
	            System.out.print(stu+"\t");//输出学生

	            //以下是输出学生的每一门课程
	            Map<String,Integer> scores = tables.row(stu);//<课程,分数>

	            for(String c:cours)//课程
	            {
	                System.out.print(scores.get(c)+"\t");
	            }
	            System.out.println();
	        }
	      

	        System.out.println("=======课程查看成绩============");
	        System.out.print("课程\t");
	        //所有的学生
	        Set<String> stus1 = tables.rowKeySet();

	        for(String t:stus1)
	        {
	            System.out.print(t+"\t");
	        }
	        System.out.println();

	        //所有的课程
	        Set<String> cours1 = tables.columnKeySet();

	        for(String c:cours1)
	        {
	            System.out.print(c+"\t");//课程
	            Map<String,Integer> scores = tables.column(c);//<学生,分数>
	            for(String s:stus1)
	            {
	                System.out.print(scores.get(s)+"\t");
	            }
	            System.out.println();
	        }

	        System.out.println("=======转换===========");
	        Table<String, String, Integer> tables2 = Tables.transpose(tables);

	        //所有的行数据
	        Set<Cell<String, String, Integer>> cells2 = tables2.cellSet();
	        for(Cell<String, String, Integer> temp:cells2)
	        {
	            System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
	        }
	        
	}
	
	
	private static void showMap(Map<String, String> map){
		
		for(Map.Entry<String, String> entry:map.entrySet()){
	          System.out.println(entry.getKey()+"--->"+entry.getValue());
		}
	}
}
