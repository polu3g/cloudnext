package com.cloud.pc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.kafka.clients.producer.*;

import com.cloud.pc.entity.Customer;
import com.cloud.pc.entity.KafkaProperties;

@RestController
public class BusinessFacadeController {

	@Autowired
	private KafkaProperties kp;

	/**
	 * This method accept the customer object & trigger kafka event for
	 * downstream processing....
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@RequestMapping("/createCustomer")
	public List createCustomer(@RequestParam(value = "name", defaultValue = "World") String name) {

		List<Customer> resp = new ArrayList<Customer>();
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("Paul");
		cust.setAddress("10 Oxford Street. Luxemburg. Germany");
		resp.add(cust);

		try {
			String brokers = kp.getCLOUDKARAFKA_BROKERS();
			String topicPrefix = kp.getCLOUDKARAFKA_TOPIC_PREFIX();

			Properties props = new Properties();
			props.put("bootstrap.servers", brokers);
			props.put("group.id", "test");
			props.put("enable.auto.commit", "true");
			props.put("auto.commit.interval.ms", "1000");
			props.put("session.timeout.ms", "30000");
			props.put("key.serializer", org.apache.kafka.common.serialization.StringSerializer.class.getName());
			props.put("value.serializer", org.apache.kafka.common.serialization.StringSerializer.class.getName());
			props.put("security.protocol", "SSL");
			props.put("ssl.truststore.location", "truststore.jks");
			props.put("ssl.truststore.password", "test1234");
			props.put("ssl.keystore.location", "keystore.jks");
			props.put("ssl.keystore.password", "test1234");
			props.put("ssl.keypassword", "test1234");

			Producer<String, String> producer = new KafkaProducer<>(props);
			for (int i = 0; i < 10; i++)
				producer.send(new ProducerRecord<String, String>(topicPrefix + "healthcare", Integer.toString(i),
						Integer.toString(i)));
 			producer.close();
		} catch (Exception ee) {
			cust = new Customer();
			cust.setId(1);
			cust.setName("Paul");
			StringWriter writer = new StringWriter();
			PrintWriter pWriter = new PrintWriter(writer);
			ee.printStackTrace(pWriter);
			cust.setAddress(writer.toString());
			resp.add(cust);
		} finally {
			return resp;
		}
		
	}

}
