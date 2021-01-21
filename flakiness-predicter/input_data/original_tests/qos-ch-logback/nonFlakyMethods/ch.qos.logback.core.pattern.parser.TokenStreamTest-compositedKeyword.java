@Test public void compositedKeyword() throws ScanException {
{
    List tl=new TokenStream("%d(A)",new AlmostAsIsEscapeUtil()).tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.COMPOSITE_KEYWORD,"d"));
    witness.add(new Token(Token.LITERAL,"A"));
    witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
    assertEquals(witness,tl);
  }
{
    List tl=new TokenStream("a %subst(%b C)",new AlmostAsIsEscapeUtil()).tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(new Token(Token.LITERAL,"a "));
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.COMPOSITE_KEYWORD,"subst"));
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.SIMPLE_KEYWORD,"b"));
    witness.add(new Token(Token.LITERAL," C"));
    witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
    assertEquals(witness,tl);
  }
}
