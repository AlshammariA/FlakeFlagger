@Test(expected=CommitFailedException.class) public void testOnlyWhitespace() throws CommitFailedException {
  validator.childNodeAdded(" ",EMPTY_NODE);
}
