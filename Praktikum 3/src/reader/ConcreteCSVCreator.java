package reader;

import java.io.IOException;

public class ConcreteCSVCreator extends Creator{

	@Override
	public Product factoryMethod(String typ) throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteCSVProduct();
	}

}
