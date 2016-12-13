package com.example;
//


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.example.actor.ActorA;
import com.example.actor.Listener;
import com.example.actor.Receiver;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserauthorizetestApplication.class)
@WebAppConfiguration
public class UserauthorizetestApplicationTests {

    @Test
    public void contextLoads() throws Exception {

    }

    @Test
    public void test() {
        int number = 10;
        print(10);
        number = number << 1;
        print(number);

        number = number >> 1;
        System.out.println(number);
    }

    public void print(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    @Test
    public void test2() {
        ActorSystem actorSystem = ActorSystem.create("system", ConfigFactory.load("application.conf"));
        ActorRef receiver = actorSystem.actorOf(Props.create(Receiver.class),"receiver");
        for (int i = 0; i < 10; i++) {
            actorSystem.actorOf(Props.create(ActorA.class),"actor"+i);
        }
        ActorRef listener = actorSystem.actorOf(Listener.props(receiver).withMailbox("priority-mailbox"),"listener");

    }

}

//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import akka.actor.Props;
//import com.example.model.user.ActorA;
//import com.example.model.user.ActorB;
//import com.typesafe.config.Config;
//import com.typesafe.config.ConfigFactory;
//import com.typesafe.config.ConfigObject;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
////@RunWith(SpringRunner.class)
////@SpringBootTest
////public class UserauthorizetestApplicationTests {
////
////	@Test
////	public void contextLoads() {
////		Assert.assertEquals(1.0,1.0);
//////		Config config  =  ConfigFactory.load();
//////		config.root().entrySet().stream().forEach(entry->{
//////			System.out.print(entry.getKey()+":");
//////			System.out.println(entry.getValue());
//////		});
//////		Map<String,Object> map = config.root().unwrapped();
//////		map.entrySet().stream().forEach(entry->{
//////			entry.getValue();
//////			System.out.println(entry.getKey());
//////			System.out.println(entry.getValue());
//////			System.out.println("-----------------");
//////		});
//////		Config config1 = ConfigFactory.load("a.conf");
//////		Config config2 = ConfigFactory.load("b.conf");
//////		Config config3 = config1.withFallback(config2);
////////		next we will talk about another thing
//////		Config config4 = ConfigFactory.load();
//////		ActorSystem system = ActorSystem.create("haozi_test",ConfigFactory.load());
//////		ActorRef actorA = system.actorOf(Props.create(ActorA.class),"actorA");
//////		ActorRef actorB = system.actorOf(Props.create(ActorB.class),"actorB");
//////		actorA.tell("hello i am A",actorB);
//////		HashMap<String,String> map = new HashMap<>();
//////		config3.entrySet().stream().forEach(entry->{
//////			map.put(entry.getKey(),entry.getValue().unwrapped().toString());
//////		});
//////		System.out.println("------begin");
//////		map.entrySet().stream().forEach(x->{
//////			System.out.print(x.getKey()+": ");
//////			System.out.println(x.getValue());
//////		});
//////		System.out.println("-------------end");
//
//	}
//
//}
