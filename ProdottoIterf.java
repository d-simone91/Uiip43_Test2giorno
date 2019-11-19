package it.uiip.esercitazioneFineModuloJavaIII.SimoneDElia;

import java.io.IOException;
import java.util.List;

public interface ProdottoIterf<T> {

	public void save(List<T> List) throws IOException;
	
	public List<T> read() throws IOException, ClassNotFoundException;
	
}
