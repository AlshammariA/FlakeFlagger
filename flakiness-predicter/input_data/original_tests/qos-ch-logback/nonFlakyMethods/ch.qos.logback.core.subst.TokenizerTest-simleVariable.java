@Test public void simleVariable() throws ScanException {
  String input="${abc}";
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(Token.START_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,"abc"));
  witnessList.add(Token.CURLY_RIGHT_TOKEN);
  assertEquals(witnessList,tokenList);
}
