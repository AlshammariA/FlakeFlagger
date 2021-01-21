@Test public void colonFollowedByDollar() throws ScanException {
  String input="a:${b}";
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(new Token(Token.Type.LITERAL,"a"));
  witnessList.add(new Token(Token.Type.LITERAL,":"));
  witnessList.add(Token.START_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,"b"));
  witnessList.add(Token.CURLY_RIGHT_TOKEN);
  assertEquals(witnessList,tokenList);
}
