@Test public void testEmptyP2() throws ScanException {
  List tl=new TokenStream("%()").tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(Token.PERCENT_TOKEN);
  witness.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  assertEquals(witness,tl);
}
