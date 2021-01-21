@Test public void testWindowsLikeBackSlashes() throws ScanException {
  List tl=new TokenStream("c:\\hello\\world.%i",new AlmostAsIsEscapeUtil()).tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(new Token(Token.LITERAL,"c:\\hello\\world."));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"i"));
  assertEquals(witness,tl);
}
