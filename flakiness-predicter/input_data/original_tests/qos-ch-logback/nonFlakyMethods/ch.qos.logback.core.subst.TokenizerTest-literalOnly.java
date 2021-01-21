@Test public void literalOnly() throws ScanException {
  String input="abc";
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(new Token(Token.Type.LITERAL,input));
  assertEquals(witnessList,tokenList);
}
