package DDMaps;

import ANTLR.BuildASTVisitor;
import ANTLR.MapsLexer;
import ANTLR.MapsParser;
import Helpers.FileManager;
import Nodes.AbstractNode;
import Visitors.TypeChecker.DeclarationManagerVisitor;
import Visitors.Evaluators.Evaluator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DDMaps {
  public static void main(String[] args) {
    if(args.length > 0) {
      FileManager.parseFile(args[0], true, true);
    } else {
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
        catch(IOException error) {}
      }
    }
  }
}
