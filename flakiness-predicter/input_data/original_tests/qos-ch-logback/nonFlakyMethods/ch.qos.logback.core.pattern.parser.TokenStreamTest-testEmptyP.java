@Test public void testEmptyP() throws ScanException {
  List tl=new TokenStream("()").tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(new Token(Token.LITERAL,"("));
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  assertEquals(witness,tl);
}
