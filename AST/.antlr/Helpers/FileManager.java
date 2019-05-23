package Helpers;

import Nodes.AbstractNode;
import Visitors.DeclarationManagerVisitor;
import Visitors.Evaluators.Evaluator;
import org.antlr.v4.runtime.*;
import ANTLR.*;
import java.io.*;
import java.util.Scanner;

public final class FileManager {
  public static final void parseFile(String path) {
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file);
      String input = "";
      while (sc.hasNextLine()) input = input.concat(sc.nextLine());
      CharStream inputStream = CharStreams.fromString(input);
      MapsLexer lexer = new MapsLexer(inputStream);
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);
      MapsParser parser = new MapsParser(tokenStream);
      AbstractNode ast = new BuildASTVisitor().visitProgram(parser.program());
      new DeclarationManagerVisitor().visit(ast);
      new Evaluator().visit(ast);
    } catch(FileNotFoundException error) {
      System.out.println("Could not find file " + path);
    }
  }
}
