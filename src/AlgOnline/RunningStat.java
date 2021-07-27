package AlgOnline;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RunningStat {

	public Double runningMean(List<Double> m) {
		

		Double mean = 0.0;
		Double count = 1.0;
		
		for (Double x : m) {
		
			mean += (x - mean) / count;
			
			count ++;
		}
				
		return mean;
		
	}
	
	public Double runningVarinace(List<Double> m) {
		
		Double var = 0.0;
		Double count = 1.0;
		Double mean = 0.0;
		
		for (Double x : m) {
			
			Double meanx = mean; 
			
			mean += (x - mean) / count;		
			
			var = (var * (count - 1) + (x - mean) * (x - meanx))/count; 
			
			count ++;
			
		}
		return var;
		
	}
	
	public Double runningCovariance(List<Double> m, List<Double> n) {
		
		Iterator<Double> mI = m.iterator();
		Iterator<Double> nI = n.iterator();
		
		Double cov = 0.0;
		Double count = 1.0;
		Double meanx = 0.0;
		Double meany = 0.0;

		
		while (mI.hasNext() && nI.hasNext()) {
			Double meanyt = meany;    
			Double meanxt = meanx; 
			Double x = mI.next();
			Double y = nI.next();
			
			
			meanx += (x - meanx) / count;
			meany += (y - meany) / count;		

			
			cov = ((count - 1) * cov + (y - meany) * (x - meanx))/count; 
						
			count ++;
			
		}
		
		return cov;
		
	}
	
	public static void main(String[] args) {
	
		List<Double> list = new ArrayList<>();
		
		list.add(3.0);
		list.add(4.0);
		list.add(2.0);
		list.add(10.0);
		list.add(10.0);
		list.add(10.0);
		list.add(10.0);

		
		RunningStat f = new RunningStat();
		Double mean = f.runningMean(list);
		
		System.out.println(mean);
		
		Double var = f.runningVarinace(list);
		
		System.out.println(var);
		
		Double cov = f.runningCovariance(list, list);
		
		System.out.println(cov);
		
	}
}
