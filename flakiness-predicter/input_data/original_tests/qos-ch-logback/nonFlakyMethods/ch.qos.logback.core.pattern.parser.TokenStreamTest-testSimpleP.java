@Test public void testSimpleP() throws ScanException {
  List tl=new TokenStream("%(hello %class{.4?})").tokenize();
  List<Token> witness=new ArrayList<Token>();
  witness.add(Token.PERCENT_TOKEN);
  witness.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
  witness.add(new Token(Token.LITERAL,"hello "));
  witness.add(Token.PERCENT_TOKEN);
  witness.add(new Token(Token.SIMPLE_KEYWORD,"class"));
  List ol=new ArrayList<String>();
  ol.add(".4?");
  witness.add(new Token(Token.OPTION,ol));
  witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
  assertEquals(witness,tl);
}
