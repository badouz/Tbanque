package com.ensa.tbanque.batch;

import java.util.List;

import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.service.IBanqueService;
import com.ensa.tbanque.utilities.Filecontrole;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("operationWriter")
public class OperationWriter implements ItemWriter<Transaction> {
	@Autowired
	private IBanqueService service;

	@Override
	public void write(List<? extends Transaction> items) throws Exception {
		// TODO Auto-generated method stub
		for (Transaction op : items) {
			Transaction t = new Transaction();
			t=service.readTransactionById(op.getIdOp());
			t.setStatut(true);
			service.mergeTransaction(t);
		}
		Filecontrole fc = new Filecontrole();
		fc.cleanFile();
		

	}

}
