package TestScript;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hamcrest.collection.IsMapContaining;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.xtimes.testautomation.codechallenge.MergeCounter;

public class Tests {
	private int[] a;
	private int[] b;
	private Map<Integer,Integer> charCountMap=new  LinkedHashMap<>();
		
	@Test
	public void lengthZero()
	{
			a=new int[0];
			b=new int[0];
			MergeCounter m=new MergeCounter();
			Assert.assertTrue(m.mergeCounter(a, b).isEmpty());
	}
		
	@Test
	public void exceedMaxInputLength()
	{
			 a=new int[10001];
			 int[] b={1,2,3};
			MergeCounter m=new MergeCounter();
			Assert.assertTrue(m.mergeCounter(a, b).isEmpty());
	}
		
	@Test
	public void charCount()
	{
			int[] a={1,2,1,5};
			int[] b={1,3,3,4,5};
			MergeCounter m=new MergeCounter();
			charCountMap=m.mergeCounter(a, b);
			Assert.assertEquals(charCountMap.size(), 5);
			assertThat(charCountMap,IsMapContaining.hasEntry(1, 3));
			assertThat(charCountMap,IsMapContaining.hasEntry(2, 1));
			assertThat(charCountMap,IsMapContaining.hasEntry(3, 2));
			assertThat(charCountMap,IsMapContaining.hasEntry(4, 1));
			assertThat(charCountMap,IsMapContaining.hasEntry(5, 2));
	}
		
	@Test
	public void negitiveAndZeroNumber()
	{
			int[] a={-1,1,2,1,5};
			int[] b={1,0,3,4,10002};
			MergeCounter m=new MergeCounter();
			charCountMap=m.mergeCounter(a, b);
			Assert.assertEquals(charCountMap.size(), 5);
			assertThat(charCountMap,IsMapContaining.hasEntry(1, 3));
			assertThat(charCountMap,IsMapContaining.hasEntry(2, 1));
			assertThat(charCountMap,IsMapContaining.hasEntry(3, 1));
			assertThat(charCountMap,IsMapContaining.hasEntry(4, 1));
			assertThat(charCountMap,IsMapContaining.hasEntry(5, 1));
			assertThat(charCountMap,not(IsMapContaining.hasEntry(0, 1)));
			assertThat(charCountMap,not(IsMapContaining.hasEntry(-1, 1)));
			assertThat(charCountMap,not(IsMapContaining.hasEntry(10002, 1)));
	}


}
