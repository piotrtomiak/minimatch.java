package minimatch;

public class GlobStar extends ParseItem {

	public GlobStar() {
		super(null);
	}

	@Override
	public boolean match(String f, Options options) {
		throw new UnsupportedOperationException();
	}

}
