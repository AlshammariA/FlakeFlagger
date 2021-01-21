@Test public void mix() throws ScanException {
  String input="a${b}c";
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(new Token(Token.Type.LITERAL,"a"));
  witnessList.add(Token.START_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,"b"));
  witnessList.add(Token.CURLY_RIGHT_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,"c"));
  assertEquals(witnessList,tokenList);
}
