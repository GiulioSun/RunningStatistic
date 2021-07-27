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
			Double x = mI.next();
			Double y = nI.next();
			
			meanx += (x - meanx) / count;
			meany += (y - meany) / count;	

			cov = ((count - 1) * cov + (y - meanyt) * (x - meanx))/count; 

			count ++;

		}

		return cov;

	}
	
}
