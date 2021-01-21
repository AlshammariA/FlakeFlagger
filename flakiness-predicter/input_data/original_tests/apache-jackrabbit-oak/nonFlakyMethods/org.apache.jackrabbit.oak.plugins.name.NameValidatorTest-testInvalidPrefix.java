@Test(expected=CommitFailedException.class) public void testInvalidPrefix() throws CommitFailedException {
  validator.childNodeAdded("invalid:name",EMPTY_NODE);
}
