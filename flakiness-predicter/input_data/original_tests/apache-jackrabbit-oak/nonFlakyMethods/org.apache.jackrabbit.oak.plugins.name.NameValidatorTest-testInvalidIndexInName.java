@Test(expected=CommitFailedException.class) public void testInvalidIndexInName() throws CommitFailedException {
  validator.childNodeAdded("name[x]",EMPTY_NODE);
}
