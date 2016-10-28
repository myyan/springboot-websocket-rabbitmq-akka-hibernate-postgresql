package com.freeland;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.freeland.model.user.ActorA;
import com.freeland.model.user.ActorB;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserauthorizetestApplicationTests {

	@Test
	public void contextLoads() {
//		Config config  =  ConfigFactory.load();
//		config.root().entrySet().stream().forEach(entry->{
//			System.out.print(entry.getKey()+":");
//			System.out.println(entry.getValue());
//		});
//		Map<String,Object> map = config.root().unwrapped();
//		map.entrySet().stream().forEach(entry->{
//			entry.getValue();
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			System.out.println("-----------------");
//		});
		Config config1 = ConfigFactory.load("a.conf");
		Config config2 = ConfigFactory.load("b.conf");
		Config config3 = config1.withFallback(config2);
//		next we will talk about another thing
		Config config4 = ConfigFactory.load();
		ActorSystem system = ActorSystem.create("haozi_test",ConfigFactory.load());
		ActorRef actorA = system.actorOf(Props.create(ActorA.class),"actorA");
		ActorRef actorB = system.actorOf(Props.create(ActorB.class),"actorB");
		actorA.tell("hello i am A",actorB);
		HashMap<String,String> map = new HashMap<>();
		config3.entrySet().stream().forEach(entry->{
			map.put(entry.getKey(),entry.getValue().unwrapped().toString());
		});
		System.out.println("------begin");
		map.entrySet().stream().forEach(x->{
			System.out.print(x.getKey()+": ");
			System.out.println(x.getValue());
		});
		System.out.println("-------------end");

	}

}
