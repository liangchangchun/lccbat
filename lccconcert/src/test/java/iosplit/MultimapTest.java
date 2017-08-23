package iosplit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.io.ByteSink;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.OutputSupplier;
import com.google.common.math.IntMath;

public class MultimapTest {

	Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();
	
	@Test
	public void test1(){
		 for(int i=10;i<20;i++){
	            StudentScore studentScore=new StudentScore();
	            studentScore.CourseId=1001+i;
	            studentScore.score=100-i;
	            addStudentScore("peida",studentScore);
	        }
	        
	        System.out.println("StudentScoreMap:"+StudentScoreMap.size());
	        System.out.println("StudentScoreMap:"+StudentScoreMap.containsKey("peida"));
	            
	        System.out.println("StudentScoreMap:"+StudentScoreMap.containsKey("jerry"));
	        System.out.println("StudentScoreMap:"+StudentScoreMap.size());
	        System.out.println("StudentScoreMap:"+StudentScoreMap.get("peida").size());

	        List<StudentScore> StudentScoreList=StudentScoreMap.get("peida");
	        if(StudentScoreList!=null&&StudentScoreList.size()>0){
	            for(StudentScore stuScore:StudentScoreList){
	                System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
	            }
	        }
	}
	

	
	@Test
    public void teststuScoreMultimap(){
        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create(); 
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        
        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        studentScore.clear();
        StudentScore studentScoreNew=new StudentScore();
        studentScoreNew.CourseId=1034;
        studentScoreNew.score=67;
        studentScore.add(studentScoreNew);
        
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
    }
	
		@Test
	    public void teststuScoreMultimap1(){
	        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create(); 
	        for(int i=10;i<20;i++){
	            StudentScore studentScore=new StudentScore();
	            studentScore.CourseId=1001+i;
	            studentScore.score=100-i;
	            scoreMultimap.put("peida",studentScore);
	        }
	        System.out.println("scoreMultimap:"+scoreMultimap.size());
	        System.out.println("scoreMultimap:"+scoreMultimap.keys());
	        
	        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
	        StudentScore studentScore1=new StudentScore();
	        studentScore1.CourseId=1034;
	        studentScore1.score=67;
	        studentScore.add(studentScore1);
	        
	        StudentScore studentScore2=new StudentScore();
	        studentScore2.CourseId=1045;
	        studentScore2.score=56;
	        scoreMultimap.put("jerry",studentScore2);
	        
	        System.out.println("scoreMultimap:"+scoreMultimap.size());
	        System.out.println("scoreMultimap:"+scoreMultimap.keys());
	        
	        
	        for(StudentScore stuScore : scoreMultimap.values()) {
	            System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
	        }
	        
	        scoreMultimap.remove("jerry",studentScore2); 
	        System.out.println("scoreMultimap:"+scoreMultimap.size());
	        System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));
	        
	        scoreMultimap.put("harry",studentScore2);
	        scoreMultimap.removeAll("harry");
	        System.out.println("scoreMultimap:"+scoreMultimap.size());
	        System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));
	    }
	
	public void addStudentScore(final String stuName,final StudentScore studentScore) {
        List<StudentScore> stuScore = StudentScoreMap.get(stuName);
        if (stuScore == null) {
            stuScore = new ArrayList<StudentScore>();
            StudentScoreMap.put(stuName, stuScore);
        }
        stuScore.add(studentScore);
    }
	
	class StudentScore{
	    int CourseId;
	    int score;
	}
	
	 @Test
	    public void testOptional() throws Exception { 
	        Optional<Integer> possible=Optional.of(6);
	        Optional<Integer> absentOpt=Optional.absent();
	        Optional<Integer> NullableOpt=Optional.fromNullable(null);
	        Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
	        if(possible.isPresent()){
	            System.out.println("possible isPresent:"+possible.isPresent());
	            System.out.println("possible value:"+possible.get());
	        }
	        if(absentOpt.isPresent()){
	            System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
	        }
	        if(NullableOpt.isPresent()){
	            System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
	        }
	        if(NoNullableOpt.isPresent()){
	            System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
	        }
	    } 
	 
	 @Test
	 public void filetest() throws IOException{
		 File original  = new File("D:\\lcc\\2");
		 File copy = new File("D:\\lcc\\1");
		 Files.copy(original, copy);
		 List<String> readLines = Files.readLines(original, Charsets.UTF_8);
		 for(String str:readLines){
			 System.out.println(str);
		 }
	 }
	 
	 @Test
	 public void test3() throws Exception{
		 Closer closer = Closer.create();
		 try {
		 	File destination = new File("D:\\lcc\\3.txt");
		 	BufferedReader reader = new BufferedReader(new FileReader("D:\\lcc\\2"));
		 	BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
		 	closer.register(reader);
		 	closer.register(writer);
		 	String line;
		 	while ((line = reader.readLine()) != null) {
		 		writer.write(line);
		 	}
		 } catch (Throwable t) {
		 	throw closer.rethrow(t);
		 } finally {
		 	closer.close();
		 }
	 }
	 @Test
	 public void test4() throws IOException{
		 File dest = new File("D:\\lcc\\destfile.txt");
		 ByteSink byteSink = Files.asByteSink(dest);
		 File file = new File("D:\\lcc\\srcfile.txt");
		 byteSink.write(Files.toByteArray(file));
	 }
	 @Test
	 public void test5(){
		int a =  IntMath.checkedAdd(1, 2); 
		System.out.println(a);
	 }
	 
	 @Test
	 public void test6() throws ExecutionException{
		 LoadingCache<String,String> cahceBuilder=CacheBuilder
			        .newBuilder()
			        .build(new CacheLoader<String, String>(){
			            @Override
			            public String load(String key) throws Exception {        
			                String strProValue="hello "+key+"!";                
			                return strProValue;
			            }
			            
			        });        
			        
			        System.out.println("jerry value:"+cahceBuilder.apply("jerry"));
			        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
			        System.out.println("peida value:"+cahceBuilder.get("peida"));
			        System.out.println("peida value:"+cahceBuilder.apply("peida"));
			        System.out.println("lisa value:"+cahceBuilder.apply("lisa"));
			        cahceBuilder.put("harry", "ssdded");
			        System.out.println("harry value:"+cahceBuilder.get("harry"));
	 }

}
