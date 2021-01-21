@Test public void colon() throws ScanException {
  String input="a:b";
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(new Token(Token.Type.LITERAL,"a"));
  witnessList.add(new Token(Token.Type.LITERAL,":b"));
  assertEquals(witnessList,tokenList);
}
