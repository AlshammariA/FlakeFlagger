@Test public void testValidIndexInName() throws CommitFailedException {
  validator.childNodeAdded("name[1]",EMPTY_NODE);
}
