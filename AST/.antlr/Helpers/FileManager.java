package Helpers;

import Nodes.AbstractNode;
import Visitors.CodeGeneration.CodeEmitVisitor;
import Visitors.TypeChecker.DeclarationManagerVisitor;
import Visitors.Evaluators.Evaluator;
import org.antlr.v4.runtime.*;
import ANTLR.*;
import java.io.*;
import java.util.Scanner;

public final class FileManager {
  public static final void parseFile(String path, boolean typeCheck, boolean evaluate, boolean emit) {
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
      if(typeCheck) new DeclarationManagerVisitor().visit(ast);
      if(evaluate) new Evaluator().visit(ast);
      if(emit) new CodeEmitVisitor().visit(ast);
    } catch(FileNotFoundException error) {
      System.out.println("Could not find file " + path);
    }
  }

  public static final void generateJavaFile(String path) {
    try {
      FileWriter fileWriter = new FileWriter(new File(path + "_output.java"));
      fileWriter.write(CodeGenerator.generatedCode);
      fileWriter.close();
    } catch(IOException error) {
      System.out.println(error);
    }
  }

  public static final void appendBoilerplate() {
    CodeGenerator.appendCode(CodeGenerator.classBoilerplate);
    CodeGenerator.appendCode(CodeGenerator.mapOperationsBoilerplate);
  }
}
