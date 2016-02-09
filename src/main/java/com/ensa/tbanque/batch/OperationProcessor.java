package com.ensa.tbanque.batch;

import com.ensa.tbanque.entities.Transaction;
import com.ensa.tbanque.utilities.*;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


@Service("TransactionProcessor")
public class OperationProcessor implements ItemProcessor<Transaction, Transaction> {

	@Override
	public Transaction process(final Transaction TransactionInput) throws Exception {
		// TODO Auto-generated method stub
		Transaction transactionOutput = null;
		
		if(TransactionInput.isStatut()== false){
			
			transactionOutput = new Transaction();
					transactionOutput.setIdOp(TransactionInput.getIdOp());
			System.out.println("*************************************************"+TransactionInput.getIdOp());
		}
		return transactionOutput;
	}

	


}
