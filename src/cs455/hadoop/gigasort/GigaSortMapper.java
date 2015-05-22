package cs455.hadoop.gigasort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Mapper: Reads line by line. Emit <long, ""> pairs.
 */
public class GigaSortMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // tokenize into words.
        StringTokenizer itr = new StringTokenizer(value.toString());
        // emit word, count pairs.
        while (itr.hasMoreTokens()) {
            context.write(new LongWritable(Long.parseLong(itr.nextToken())), new Text(""));
        }
    }
}
