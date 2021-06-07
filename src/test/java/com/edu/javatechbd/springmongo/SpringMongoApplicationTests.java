package com.edu.javatechbd.springmongo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class SpringMongoApplicationTests {

	@Test
	void contextLoads() throws IOException {

		Map<String,String> iusMap = new HashMap<>();
		Map<String,String> admMap = new HashMap<>();

		try (Stream<Path> paths = Files.walk(Paths.get("/home/mahadi/official_backup/IUSServer/cdnAppBaseIUS/cdn/WEB-INF/classes/sp"))) {
			paths
					.filter(Files::isRegularFile)
					.forEach(file-> {
						iusMap.put(file.getFileName().toString(), file.toString());
					});
		}
		try (Stream<Path> paths = Files.walk(Paths.get("/home/mahadi/official_backup/IUSServer/cdnAppBaseAdm/cdn/WEB-INF/classes/sp"))) {
			paths
					.filter(Files::isRegularFile)
					.forEach(file-> {
						admMap.put(file.getFileName().toString(), file.toString());
					});
		}

		System.out.println("iusMap: "+iusMap.size());
		System.out.println("admMap: "+admMap.size());

		admMap.entrySet().stream()
				.filter(o-> !iusMap.containsKey(o.getKey()))
				.forEach(o-> {
					System.out.println(o.getValue());
				});


	}

	@Test
	void notExistsTest() {

		List<String> ius = Arrays.asList("1","2","3","4","5");
		List<String> adm = Arrays.asList("1","2","4");

		ius.stream()
				.filter(o -> !adm.contains(o))
				.forEach(System.out::println);

	}
}
