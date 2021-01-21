@Test public void testDeleted() throws CommitFailedException {
  validator.childNodeDeleted(".",EMPTY_NODE);
  validator.childNodeDeleted("..",EMPTY_NODE);
  validator.childNodeDeleted("valid:name",EMPTY_NODE);
  validator.childNodeDeleted("invalid:name",EMPTY_NODE);
  validator.childNodeDeleted("invalid/name",EMPTY_NODE);
}
