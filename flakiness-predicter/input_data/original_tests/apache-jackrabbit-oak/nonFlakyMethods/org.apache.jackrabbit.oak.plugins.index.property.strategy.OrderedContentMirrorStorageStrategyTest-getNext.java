@Test public void getNext(){
  NodeBuilder node=EmptyNodeState.EMPTY_NODE.builder();
  assertEquals("If the property is not there an empty string is expected","",OrderedContentMirrorStoreStrategy.getPropertyNext(node.getNodeState()));
  node.setProperty(NEXT,ImmutableList.of("bar","","",""),Type.STRINGS);
  assertEquals("bar",OrderedContentMirrorStoreStrategy.getPropertyNext(node.getNodeState()));
  node.setProperty(NEXT,ImmutableList.of("","","",""),Type.STRINGS);
  assertEquals("",OrderedContentMirrorStoreStrategy.getPropertyNext(node.getNodeState()));
  node=EmptyNodeState.EMPTY_NODE.builder();
  assertEquals("If the property is not there an empty string is expected","",OrderedContentMirrorStoreStrategy.getPropertyNext(node));
  node.setProperty(NEXT,ImmutableList.of("bar","","",""),Type.STRINGS);
  assertEquals("bar",OrderedContentMirrorStoreStrategy.getPropertyNext(node));
  node.setProperty(NEXT,ImmutableList.of("","","",""),Type.STRINGS);
  assertEquals("",OrderedContentMirrorStoreStrategy.getPropertyNext(node));
  node.setProperty(NEXT,ImmutableList.of("a","b","c","d"),Type.STRINGS);
  assertEquals("a",OrderedContentMirrorStoreStrategy.getPropertyNext(node));
  assertEquals("a",OrderedContentMirrorStoreStrategy.getPropertyNext(node,0));
  assertEquals("b",OrderedContentMirrorStoreStrategy.getPropertyNext(node,1));
  assertEquals("c",OrderedContentMirrorStoreStrategy.getPropertyNext(node,2));
  assertEquals("d",OrderedContentMirrorStoreStrategy.getPropertyNext(node,3));
  assertEquals("if we provide a number outside the range an empty next is expeted","",OrderedContentMirrorStoreStrategy.getPropertyNext(node,OrderedIndex.LANES + 100));
}
