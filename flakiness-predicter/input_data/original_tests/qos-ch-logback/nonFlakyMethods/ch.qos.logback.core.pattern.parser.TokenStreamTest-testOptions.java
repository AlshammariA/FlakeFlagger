@Test public void testOptions() throws ScanException {
{
    List tl=new TokenStream("%x{t}").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    List ol=new ArrayList<String>();
    ol.add("t");
    witness.add(new Token(Token.OPTION,ol));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%x{t,y}").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    List ol=new ArrayList<String>();
    ol.add("t");
    ol.add("y");
    witness.add(new Token(Token.OPTION,ol));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%x{\"hello world.\", \"12y  \"}").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    List ol=new ArrayList<String>();
    ol.add("hello world.");
    ol.add("12y  ");
    witness.add(new Token(Token.OPTION,ol));
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("%x{'opt}'}").tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"x"));
    List ol=new ArrayList<String>();
    ol.add("opt}");
    witness.add(new Token(Token.OPTION,ol));
    assertEquals(witness,tl);
  }
}
