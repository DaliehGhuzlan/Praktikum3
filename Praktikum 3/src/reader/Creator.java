package reader;

import java.io.IOException;

public abstract class Creator {
	public abstract Product factoryMethod(String typ) throws IOException;
}
