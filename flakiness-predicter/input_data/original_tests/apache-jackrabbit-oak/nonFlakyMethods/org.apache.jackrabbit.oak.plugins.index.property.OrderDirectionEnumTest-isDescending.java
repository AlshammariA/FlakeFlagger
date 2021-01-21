@Test public void isDescending(){
  NodeState indexMeta=null;
  assertFalse(OrderDirection.isDescending(indexMeta));
  indexMeta=EmptyNodeState.EMPTY_NODE.builder().setProperty(OrderedIndex.DIRECTION,OrderDirection.ASC.getDirection()).getNodeState();
  assertFalse(OrderDirection.isDescending(indexMeta));
  indexMeta=EmptyNodeState.EMPTY_NODE.builder().setProperty(OrderedIndex.DIRECTION,OrderDirection.DESC.getDirection()).getNodeState();
  assertTrue(OrderDirection.isDescending(indexMeta));
}
