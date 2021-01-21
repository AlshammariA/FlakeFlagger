@Test public void moveToDescendant() throws CommitFailedException {
  NodeBuilder test=store.getRoot().builder().getChildNode("test");
  NodeBuilder x=test.getChildNode("x");
  if (fixture == NodeStoreFixture.SEGMENT_MK) {
    assertTrue(x.moveTo(x,"xx"));
    assertFalse(x.exists());
    assertFalse(test.hasChildNode("x"));
  }
 else {
    assertFalse(x.moveTo(x,"xx"));
    assertTrue(x.exists());
    assertTrue(test.hasChildNode("x"));
  }
}
