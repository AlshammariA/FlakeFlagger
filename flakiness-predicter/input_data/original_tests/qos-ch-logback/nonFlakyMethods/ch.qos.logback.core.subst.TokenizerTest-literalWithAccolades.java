@Test public void literalWithAccolades() throws ScanException {
  String input0="%logger";
  String input1="24";
  String input2=" - %m";
  String input=input0 + "{" + input1+ "}"+ input2;
  Tokenizer tokenizer=new Tokenizer(input);
  List<Token> tokenList=tokenizer.tokenize();
  witnessList.add(new Token(Token.Type.LITERAL,input0));
  witnessList.add(Token.CURLY_LEFT_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,input1));
  witnessList.add(Token.CURLY_RIGHT_TOKEN);
  witnessList.add(new Token(Token.Type.LITERAL,input2));
  assertEquals(witnessList,tokenList);
}
