@Test public void testGetHiddenChildren(){
  Iterable<Tree> children=parent.getChildren();
  assertFalse(children.iterator().hasNext());
}
