@Test public void fulltextChars(){
  for (  char c : "a\u00e4\u00dfzAZ\u00c409+\u3360".toCharArray()) {
    assertTrue("char:" + c,FullTextTerm.isFullTextCharacter(c));
  }
  for (  char c : "@-.,;!?\t\n\f".toCharArray()) {
    assertFalse("char:" + c,FullTextTerm.isFullTextCharacter(c));
  }
}
