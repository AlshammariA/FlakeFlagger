@Test(expected=CommitFailedException.class) public void testParentPath() throws CommitFailedException {
  validator.childNodeAdded("..",EMPTY_NODE);
}
