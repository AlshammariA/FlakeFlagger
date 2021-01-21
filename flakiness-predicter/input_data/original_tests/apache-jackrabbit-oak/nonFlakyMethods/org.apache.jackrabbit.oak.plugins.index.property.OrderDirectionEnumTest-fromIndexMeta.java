@Test public void fromIndexMeta(){
  assertEquals(OrderDirection.ASC,OrderDirection.fromIndexMeta(null));
  NodeState indexMeta=EmptyNodeState.EMPTY_NODE;
  assertEquals(OrderDirection.ASC,OrderDirection.fromIndexMeta(indexMeta));
  indexMeta=EmptyNodeState.EMPTY_NODE.builder().setProperty(OrderedIndex.DIRECTION,OrderDirection.ASC.getDirection()).getNodeState();
  assertEquals(OrderDirection.ASC,OrderDirection.fromIndexMeta(indexMeta));
  indexMeta=EmptyNodeState.EMPTY_NODE.builder().setProperty(OrderedIndex.DIRECTION,OrderDirection.DESC.getDirection()).getNodeState();
  assertEquals(OrderDirection.DESC,OrderDirection.fromIndexMeta(indexMeta));
}
