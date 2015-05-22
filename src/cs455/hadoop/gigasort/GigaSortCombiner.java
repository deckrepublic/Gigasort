package cs455.hadoop.gigasort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Counter;

import java.io.IOException;

/**
 * Reducer: Input to the reducer is the output from the mapper. It receives long, list<word> pairs.
 * Emits sorted <long, ""> sorted pairs.
 */
public class GigaSortCombiner extends Reducer<LongWritable, Text, LongWritable, Text> {
  
    int counter = 0;
    @Override
    protected void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

	//int counter = 0;
	//preserve duplicates
	//Counter counter = context.getCounter(MoreIterations.numberOfIterations);
	
        //for(Text val : values){
	    //if((counter % 10) == 0) {
		//counter.increment(1);
		context.write(key, new Text(Integer.toString(counter)));
	    //}
	    //counter ++;
       // }
	
        
    }
}
