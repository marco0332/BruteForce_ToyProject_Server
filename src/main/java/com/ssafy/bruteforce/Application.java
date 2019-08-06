package com.ssafy.bruteforce;

import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private BoardRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Comment("cid","wid","wname","new comment"));
		System.out.println(repository.insert(new Comment("cid2","wid2","wname2","new comment2")));
		System.out.println(repository.findByWriterUid("wid2"));
		repository.deleteById("cid2");
		System.out.println(repository.findByWriterUid("wid2"));

	}


}
