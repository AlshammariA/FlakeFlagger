@Test public void defaultSeparatorOutsideVariable() throws ScanException {
  String input="{a:-b}";
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(Token.CURLY_LEFT_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,"a"));
  witnessList.add(Token.DEFAULT_SEP_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,"b"));
  witnessList.add(Token.CURLY_RIGHT_TOKEN);
  assertEquals(witnessList,tokenList);
}
