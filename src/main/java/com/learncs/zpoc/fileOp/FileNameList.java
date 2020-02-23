package com.learncs.zpoc.fileOp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileNameList {
	public static void main(String[] args) {
		try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\talka001\\Downloads\\RInstallation\\RInstallation"))) {

			List<String> result = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());

			result.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
