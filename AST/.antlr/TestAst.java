import ANTLR.BuildASTVisitor;
import ANTLR.MapsLexer;
import ANTLR.MapsParser;
import Nodes.AbstractNode;

import Visitors.Evaluators.*;
import Visitors.TypeChecker.DeclarationManagerVisitor;
import org.antlr.v4.runtime.*;

import java.io.*;

public class TestAst {
  public static void main(String[] args) {
    while(true) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("> ");
      try{
        String exprText = br.readLine();
        CharStream inputStream = CharStreams.fromString(exprText);
        MapsLexer lexer = new MapsLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MapsParser parser = new MapsParser(tokenStream);
        AbstractNode ast = new BuildASTVisitor().visitProgram(parser.program());
        new DeclarationManagerVisitor().visit(ast);
        new Evaluator().visit(ast);
      }
      catch(IOException error) {

      }
    }
  }
}