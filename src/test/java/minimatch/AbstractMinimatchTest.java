/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Genuitec LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package minimatch;

import org.junit.Test;

/**
 * Base class for minimatch pattern tests.
 * 
 * @author Piotr Tomiak <piotr@genuitec.com>
 */
public class AbstractMinimatchTest {
	
	private final ITestCase testCase;
	
	public AbstractMinimatchTest(ITestCase testCase) {
		this.testCase = testCase;
	}
	
	@Test
	public void runTestCase() {
		testCase.run();
	}
	
	public interface ITestCase {
		
		void run();
		
	}
	
	public abstract static class AbstractTestCase implements ITestCase {
		
		protected TestCase testCase;
		
		@Override
		public void run() {
			try {
				internalRun();
			} catch (Error err) {
				testCase.setAsCauseOf(err);
				throw err;
			} catch (RuntimeException ex) {
				testCase.setAsCauseOf(ex);
				throw ex;
			}
		}
		
		protected abstract void internalRun();
		
	}
	
	
}
