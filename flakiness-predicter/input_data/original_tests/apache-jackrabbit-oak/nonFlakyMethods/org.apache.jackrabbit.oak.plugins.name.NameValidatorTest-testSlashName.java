@Test(expected=CommitFailedException.class) public void testSlashName() throws CommitFailedException {
  validator.childNodeAdded("invalid/name",EMPTY_NODE);
}
