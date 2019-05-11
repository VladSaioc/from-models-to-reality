import Nodes.AbstractNode;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

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
        AbstractNode ast = new BuildAST().visitProgram(parser.program());
      }
      catch(IOException error) {

      }
    }
  }
}