@Test public void testEscape() throws ScanException {
{
    List tl=new TokenStream("\\%").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(new Token(Token.LITERAL,"%"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("\\%\\(\\t\\)\\r\\n").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(new Token(Token.LITERAL,"%(\t)\r\n"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("\\\\%x").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(new Token(Token.LITERAL,"\\"));
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%x\\)").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    witness.add(new Token(Token.LITERAL,")"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%x\\_a").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    witness.add(new Token(Token.LITERAL,"a"));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%x\\_%b").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"b"));
    assertEquals(witness,tl);
  }
}
