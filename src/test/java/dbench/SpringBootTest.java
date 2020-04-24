package dbench;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dbench.models.Contract;
import dbench.models.Message;
import dbench.models.Tender;
import dbench.repo.ConractRepository;
import dbench.repo.MessageRepository;
import dbench.repo.TenderRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
// @org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ConractRepository contractRepository;
	
	@Autowired
	private TenderRepository tenderRepository;
	
	@org.junit.jupiter.api.Test
	@Transactional
	@Rollback(false)
	public void Test() {
		System.out.println("Hello from test");
				
		List<Message> messages = new ArrayList<Message>(); 
		
		for (Integer i = 0; i < 10; i++) {
			Message m = new Message();
			m.setText(UUID.randomUUID().toString());
			messages.add(m);
		}
		
		messageRepository.saveAll(messages);
	}
	
	@org.junit.jupiter.api.Test
	@Transactional
	@Rollback(false)
	public void ContractTest() {
		Contract contract = contractRepository.findById(1L).get(); 
		
		assertNotNull(contract);
		assertNotNull(contract.getZreport());
		assertNotNull(contract.getCurator());
		
		assertNotNull(contract.getZreport().getData());
		assertNotNull(contract.getCurator().getName());
	}
	
	@org.junit.jupiter.api.Test
	@Transactional
	@Rollback(false)
	public void ApprovalTest() {
		Contract contract = contractRepository.findById(1L).get(); 
		
		assertTrue(contract.getApprovals().size() > 0);
		
		Tender tender = tenderRepository.findById(1L).get(); 
		
		assertTrue(tender.getApprovals().size() > 0);
	}
}
