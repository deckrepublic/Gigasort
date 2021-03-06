package cs455.hadoop.gigasort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;

import java.io.IOException;


/**
 * Partitioner: splits mapping of numbers into partition based of 16 different ranges in the 2^30 + 1 numbers
 */
public class GigaSortPartitioner extends Partitioner<LongWritable, Text> {

    @Override
    public int getPartition(LongWritable key, Text value, int numReduceTasks) {
		 
		 double range_divider = Math.pow(2,64)/16;	
		
		 if(numReduceTasks == 0) return 0;

		 if(key.get() < (range_divider * 1)) return 0;
		 else if(key.get() > (range_divider * 1) && key.get() < (range_divider * 2)) return 1 % numReduceTasks;
		 else if(key.get() > (range_divider * 2) && key.get() < (range_divider * 3)) return 2 % numReduceTasks;
		 else if(key.get() > (range_divider * 3) && key.get() < (range_divider * 4)) return 3 % numReduceTasks;
		 else if(key.get() > (range_divider * 4) && key.get() < (range_divider * 5)) return 4 % numReduceTasks;
		 else if(key.get() > (range_divider * 5) && key.get() < (range_divider * 6)) return 5 % numReduceTasks;
		 else if(key.get() > (range_divider * 6) && key.get() < (range_divider * 7)) return 6 % numReduceTasks;
		 else if(key.get() > (range_divider * 7) && key.get() < (range_divider * 8)) return 7 % numReduceTasks;
		 else if(key.get() > (range_divider * 8) && key.get() < (range_divider * 9)) return 8 % numReduceTasks;
		 else if(key.get() > (range_divider * 9) && key.get() < (range_divider * 10)) return 9 % numReduceTasks;
		 else if(key.get() > (range_divider * 10) && key.get() < (range_divider * 11)) return 10 % numReduceTasks;
		 else if(key.get() > (range_divider * 11) && key.get() < (range_divider * 12)) return 11 % numReduceTasks;
		 else if(key.get() > (range_divider * 12) && key.get() < (range_divider * 13)) return 12 % numReduceTasks;
		 else if(key.get() > (range_divider * 13) && key.get() < (range_divider * 14)) return 13 % numReduceTasks;
		 else if(key.get() > (range_divider * 14) && key.get() < (range_divider * 15)) return 14 % numReduceTasks;                
		 else return 15;
    }
}
