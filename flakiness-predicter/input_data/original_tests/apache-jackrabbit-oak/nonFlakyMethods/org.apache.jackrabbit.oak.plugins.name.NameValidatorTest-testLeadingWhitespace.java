@Test(expected=CommitFailedException.class) public void testLeadingWhitespace() throws CommitFailedException {
  validator.childNodeAdded(" name",EMPTY_NODE);
}
