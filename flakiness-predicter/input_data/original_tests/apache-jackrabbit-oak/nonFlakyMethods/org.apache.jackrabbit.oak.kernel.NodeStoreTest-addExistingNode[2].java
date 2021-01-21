@Test public void addExistingNode() throws CommitFailedException {
  assumeTrue(fixture != NodeStoreFixture.MONGO_MK);
  assumeTrue(fixture != NodeStoreFixture.MONGO_NS);
  CommitHook hook=new CompositeHook(new ConflictHook(JcrConflictHandler.JCR_CONFLICT_HANDLER),new EditorHook(new ConflictValidatorProvider()));
  NodeBuilder b1=store.getRoot().builder();
  NodeBuilder b2=store.getRoot().builder();
  for (int k=0; k < 1002; k++) {
    b1.setChildNode("n" + k);
    b2.setChildNode("m" + k);
  }
  b1.setChildNode("conflict");
  b2.setChildNode("conflict");
  store.merge(b1,hook,CommitInfo.EMPTY);
  store.merge(b2,hook,CommitInfo.EMPTY);
}
