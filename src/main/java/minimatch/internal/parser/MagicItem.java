/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Angelo
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
package minimatch.internal.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minimatch.Options;

public class MagicItem extends ParseItem {

	private final Pattern pattern;

	public MagicItem(String source, Options options) {
		super(source);
		this.pattern = Pattern.compile("^" + source + "$",
				options.isNocase() ? Pattern.CASE_INSENSITIVE : 0);
	}

	@Override
	public boolean match(String input, Options options) {
		Matcher m = pattern.matcher(input);
		return m.matches();
	}

	@Override
	public String toString() {
		return "RegExp(\"" + getSource() + "\")";
	}
}
