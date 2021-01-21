@Test public void testEscapedParanteheses() throws ScanException {
{
    List tl=new TokenStream("\\(%h\\)").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(new Token(Token.LITERAL,"("));
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"h"));
    witness.add(new Token(Token.LITERAL,")"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("(%h\\)").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(new Token(Token.LITERAL,"("));
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"h"));
    witness.add(new Token(Token.LITERAL,")"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%a(x\\)").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.COMPOSITE_KEYWORD,"a"));
    witness.add(new Token(Token.LITERAL,"x)"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%a\\(x)").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"a"));
    witness.add(new Token(Token.LITERAL,"(x"));
    witness.add(new Token(Token.RIGHT_PARENTHESIS));
    assertEquals(witness,tl);
  }
}
