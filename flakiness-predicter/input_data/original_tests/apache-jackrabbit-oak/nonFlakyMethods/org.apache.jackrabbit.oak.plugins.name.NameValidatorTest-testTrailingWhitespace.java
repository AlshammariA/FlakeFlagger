@Test(expected=CommitFailedException.class) public void testTrailingWhitespace() throws CommitFailedException {
  validator.childNodeAdded("name ",EMPTY_NODE);
}
