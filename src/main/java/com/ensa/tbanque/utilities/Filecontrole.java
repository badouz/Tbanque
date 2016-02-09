package com.ensa.tbanque.utilities;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.ensa.tbanque.entities.Transaction;
public class Filecontrole {

	final static ClassPathResource resource = new ClassPathResource("Operations.txt");
	public File getHistorytFile() {
		File f = null;
		try {
			f = new File(resource.getURI());
			System.out.println("path " + resource.getPath() + " - " + resource.getURI());
			if (!f.exists()) {
				f.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public int addInFile(Transaction t) {
		File history_file = this.getHistorytFile();
		System.out.println("**************////////****************:"+ history_file);
		if (history_file == null || t == null)
			return 0;
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(history_file, true));
			String _ligne = t.getIdOp()+"";
			this.write(out, _ligne);
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 1;
	}
	private void write(BufferedWriter bw, String string) throws IOException {
		if (bw == null)
			return;
		bw.append(string).append(System.lineSeparator());
		bw.flush();
	}
	public void cleanFile() {
		File history_file = this.getHistorytFile();
		if (history_file == null) {

		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(history_file));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
