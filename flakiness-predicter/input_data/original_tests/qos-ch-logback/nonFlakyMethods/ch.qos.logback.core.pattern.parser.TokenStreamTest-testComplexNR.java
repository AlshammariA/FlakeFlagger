@Test public void testComplexNR() throws ScanException {
  List tl=new TokenStream("%d{1234} [%34.-67toto] %n").tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"d"));
  List ol=new ArrayList<String>();
  ol.add("1234");
  witness.add(new Token(Token.OPTION,ol));
  witness.add(new Token(Token.LITERAL," ["));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.FORMAT_MODIFIER,"34.-67"));
  witness.add(new Token(Token.SIMPLE_KEYWORD,"toto"));
  witness.add(new Token(Token.LITERAL,"] "));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"n"));
  assertEquals(witness,tl);
}
