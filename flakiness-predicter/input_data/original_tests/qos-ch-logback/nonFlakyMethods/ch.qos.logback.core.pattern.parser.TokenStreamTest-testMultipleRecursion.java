@Test public void testMultipleRecursion() throws ScanException {
  List tl=new TokenStream("%-1(%d %45(%class %file))").tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.FORMAT_MODIFIER,"-1"));
  witness.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"d"));
  witness.add(new Token(Token.LITERAL," "));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.FORMAT_MODIFIER,"45"));
  witness.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"class"));
  witness.add(new Token(Token.LITERAL," "));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"file"));
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  assertEquals(witness,tl);
}
