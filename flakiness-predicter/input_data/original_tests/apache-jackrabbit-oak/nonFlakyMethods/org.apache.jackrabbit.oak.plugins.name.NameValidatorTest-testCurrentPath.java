@Test(expected=CommitFailedException.class) public void testCurrentPath() throws CommitFailedException {
  validator.childNodeAdded(".",EMPTY_NODE);
}
