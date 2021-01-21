@Test public void testNested() throws ScanException {
  List tl=new TokenStream("%(%a%(%b))").tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(Token.PERCENT_TOKEN);
  witness.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"a"));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"b"));
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  assertEquals(witness,tl);
}
