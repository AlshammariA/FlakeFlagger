@Test public void isAscending(){
  NodeState indexMeta=null;
  assertTrue(OrderDirection.isAscending(indexMeta));
  indexMeta=EmptyNodeState.EMPTY_NODE.builder().setProperty(OrderedIndex.DIRECTION,OrderDirection.ASC.getDirection()).getNodeState();
  assertTrue(OrderDirection.isAscending(indexMeta));
  indexMeta=EmptyNodeState.EMPTY_NODE.builder().setProperty(OrderedIndex.DIRECTION,OrderDirection.DESC.getDirection()).getNodeState();
  assertFalse(OrderDirection.isAscending(indexMeta));
}
