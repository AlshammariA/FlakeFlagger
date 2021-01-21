@Test public void compositedKeywordFollowedByOptions() throws ScanException {
{
    List tl=new TokenStream("%d(A){o}",new AlmostAsIsEscapeUtil()).tokenize();
    List<Token> witness=new ArrayList<Token>();
    witness.add(Token.PERCENT_TOKEN);
    witness.add(new Token(Token.COMPOSITE_KEYWORD,"d"));
    witness.add(new Token(Token.LITERAL,"A"));
    witness.add(Token.RIGHT_PARENTHESIS_TOKEN);
    List ol=new ArrayList<String>();
    ol.add("o");
    witness.add(new Token(Token.OPTION,ol));
    assertEquals(witness,tl);
  }
}
